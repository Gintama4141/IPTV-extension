package com.indonesianiptv

import com.indonesianiptv.model.M3UChannel
import com.indonesianiptv.model.M3UParser
import com.indonesianiptv.util.Constants
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.syncproviders.SyncIdName
import com.lagradost.cloudstream3.utils.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class IndonesianIPTVProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io"
    override var name = "Indonesian IPTV"
    override var lang = "id"
    override var hasMainPage = true
    override var supportedTypes = setOf(TvType.Live)
    override val supportedSyncNames = setOf<SyncIdName>()
    override var vpnStatus = VPNStatus.None

    private var allChannels: List<Constants.CategorizedChannel> = emptyList()
    private var channelCache: Map<String, Constants.CategorizedChannel> = emptyMap()
    private var lastFetch = 0L
    private val cacheTtl = 10 * 60 * 1000L

    private val m3uExclusions = setOf(
        "metro tv", "kompas tv", "tvone", "btv", "indonesiana",
        "magna", "rodja", "rri net", "celestial", "hits", "hiys",
        "kix", "k-plus", "kplus", "my cinema", "my kidz",
        "rock action", "rock entertainment", "sea today", "my family",
        "thrill", "tvn asia", "tvn movies", "tvri", "antv", "inews",
        "indosiar", "net tv",
        "gtv", "mnc tv", "rcti", "sctv", "trans7", "moji", "idtv", "mdtv",
        "net.", "cinemaworld", "rock entertaiment"
    )

    override val mainPage = mainPageOf(
        "Nasional" to "${Constants.CATEGORY_FLAGS["Nasional"]} Nasional",
        "Berita" to "${Constants.CATEGORY_FLAGS["Berita"]} Berita",
        "Edukasi" to "${Constants.CATEGORY_FLAGS["Edukasi"]} Edukasi",
        "Religi" to "${Constants.CATEGORY_FLAGS["Religi"]} Religi",
        "Daerah" to "${Constants.CATEGORY_FLAGS["Daerah"]} Daerah",
        "Hiburan" to "${Constants.CATEGORY_FLAGS["Hiburan"]} Hiburan",
        "Musik" to "${Constants.CATEGORY_FLAGS["Musik"]} Musik",
        "Anak" to "${Constants.CATEGORY_FLAGS["Anak"]} Anak",
        "Olahraga" to "${Constants.CATEGORY_FLAGS["Olahraga"]} Olahraga",
        "International" to "${Constants.CATEGORY_FLAGS["International"]} International"
    )

    private fun countryFlag(code: String): String =
        Constants.COUNTRIES.firstOrNull { it.code == code }?.flag ?: ""

    private suspend fun refreshCache() {
        val now = System.currentTimeMillis()
        if (now - lastFetch < cacheTtl && allChannels.isNotEmpty()) return
        lastFetch = now

        val channels = mutableListOf<Constants.CategorizedChannel>()

        channels.addAll(Constants.TVRI_CATEGORIZED)
        channels.addAll(Constants.INDONESIAN_CHANNELS)

        // M3U - Indonesian sources (sequential, break on first success)
        for (source in Constants.M3U_SOURCES) {
            val parsed = runCatching {
                val resp = app.get(source)
                M3UParser.parse(resp.text)
            }.getOrNull() ?: continue
            channels.addAll(parsed.mapNotNull { categorizeM3uChannel(it) })
            if (parsed.isNotEmpty()) break
        }

        // International sources — parallel M3U fetch per country
        val countryResults = runCatching {
            coroutineScope {
                Constants.COUNTRIES.filter { it.m3uUrl != null }.map { country ->
                    async {
                        val m3uUrl = country.m3uUrl!!
                        runCatching {
                            val resp = app.get(m3uUrl)
                            M3UParser.parse(resp.text)
                        }.getOrNull().orEmpty()
                    }
                }.map { it.await() }
            }
        }.getOrNull().orEmpty()

        val countryMap = Constants.COUNTRIES.filter { it.m3uUrl != null }.zip(countryResults)
        for ((country, parsed) in countryMap) {
            val hc = Constants.INTERNATIONAL_CHANNELS.filter { it.category == country.code }
            channels.addAll(hc)
            for (ch in parsed) {
                channels.add(Constants.CategorizedChannel(
                    name = ch.name,
                    url = ch.streamUrl,
                    category = country.code,
                    tvgId = ch.tvgId,
                    tvgLogo = ch.tvgLogo,
                    headers = ch.headers,
                    quality = parseQualityInt(ch.quality)
                ))
            }
        }
        // Countries without M3U url — add only hardcoded channels
        for (country in Constants.COUNTRIES.filter { it.m3uUrl == null }) {
            channels.addAll(Constants.INTERNATIONAL_CHANNELS.filter { it.category == country.code })
        }

        val seenUrls = mutableSetOf<String>()
        val seenNames = mutableSetOf<String>()
        allChannels = channels.filter { channel ->
            val nameKey = channel.name.lowercase().trim()
            val urlKey = channel.url
            when {
                urlKey in seenUrls -> false
                nameKey in seenNames -> false
                else -> {
                    seenUrls.add(urlKey)
                    seenNames.add(nameKey)
                    true
                }
            }
        }
        channelCache = allChannels.associateBy { it.url }
    }

    private fun categorizeM3uChannel(ch: M3UChannel): Constants.CategorizedChannel? {
        val name = ch.name.lowercase()
        if (m3uExclusions.any { name.contains(it) }) return null
        if (ch.streamUrl.contains("b1world") || ch.streamUrl.contains("h/h06")) return null

        val group = ch.group?.lowercase()?.trim() ?: ""

        val category = if (group.isEmpty()) {
            categorizeByName(name)
        } else {
            Constants.CATEGORY_KEYWORDS.entries.firstOrNull { entry ->
                entry.value.any { keyword -> group.contains(keyword) }
            }?.key ?: categorizeByName(name)
        }

        return Constants.CategorizedChannel(
            name = ch.name,
            url = ch.streamUrl,
            category = category,
            tvgId = ch.tvgId,
            tvgLogo = ch.tvgLogo,
            headers = ch.headers,
            quality = parseQualityInt(ch.quality)
        )
    }

    private fun categorizeByName(name: String): String =
        Constants.CATEGORY_KEYWORDS.entries.firstOrNull { entry ->
            entry.value.any { name.contains(it) }
        }?.key ?: "Nasional"

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        refreshCache()
        val key = request.data
        val items = allChannels.filter { it.category == key }
        val pageSize = 50
        val start = (page - 1) * pageSize
        val end = minOf(start + pageSize, items.size)
        return newHomePageResponse(
            list = HomePageList(
                name = "${key} (${items.size} ch)",
                list = items.subList(start, end).map { it.toSearchResponse() }
            ),
            hasNext = end < items.size
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        refreshCache()
        val q = query.lowercase()
        return allChannels.filter {
            it.name.lowercase().contains(q) ||
            it.category.lowercase().contains(q) ||
            it.tvgId?.lowercase()?.contains(q) == true
        }.map { it.toSearchResponse() }
    }

    override suspend fun load(url: String): LoadResponse? {
        refreshCache()
        val channel = channelCache[url] ?: return null
        val siblings = allChannels.filter { it.category == channel.category }
        val episodes = siblings.mapIndexed { idx, ch ->
            newEpisode(ch.url) {
                this.name = ch.name
                this.season = 1
                this.episode = idx + 1
                this.posterUrl = Constants.resolveLogo(ch.name, ch.tvgId, ch.tvgLogo)
            }
        }
        return newAnimeLoadResponse(
            name = channel.name,
            url = url,
            type = TvType.TvSeries
        ) {
            this.posterUrl = Constants.resolveLogo(channel.name, channel.tvgId, channel.tvgLogo)
            this.episodes = mutableMapOf(DubStatus.Dubbed to episodes)
            this.plot = "${siblings.size} channel • ${channel.category}"
            this.tags = listOf("IPTV", channel.category)
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        refreshCache()
        val channel = channelCache[data] ?: return false
        val isYouTube = data.contains("youtube.com", ignoreCase = true) ||
                data.contains("youtu.be", ignoreCase = true)
        callback.invoke(
            newExtractorLink(
                source = this.name,
                name = channel.name,
                url = data,
                type = if (isYouTube) ExtractorLinkType.VIDEO else ExtractorLinkType.M3U8
            ) {
                this.quality = channel.quality
                this.headers = channel.headers
            }
        )
        return true
    }

    private fun Constants.CategorizedChannel.toSearchResponse() = newLiveSearchResponse(
        name = name,
        url = url
    ) { this.posterUrl = Constants.resolveLogo(name, tvgId, tvgLogo) }

    private fun parseQualityInt(q: String?): Int = q?.filter { it.isDigit() }
        ?.toIntOrNull()
        ?.let { num ->
            when {
                num >= 4000 -> 2160
                num >= 1000 -> 1080
                num >= 720 -> 720
                num >= 576 -> 576
                num >= 480 -> 480
                num >= 360 -> 360
                num >= 240 -> 240
                else -> -1
            }
        } ?: -1
}
