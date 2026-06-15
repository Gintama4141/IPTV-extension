package com.indonesianiptv

import com.indonesianiptv.model.M3UChannel
import com.indonesianiptv.model.M3UParser
import com.indonesianiptv.util.Constants
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class IndonesianIPTVProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io"
    override var name = "Indonesian IPTV"
    override var lang = "id"
    override var hasMainPage = true
    override var supportedTypes = setOf(TvType.Live)

    private var allChannels: List<Constants.CategorizedChannel> = emptyList()
    private var channelCache: Map<String, Constants.CategorizedChannel> = emptyMap()
    private var lastFetch = 0L
    private val cacheTtl = 10 * 60 * 1000L

    override val mainPage = mainPageOf(
        "Nasional" to "${Constants.CATEGORY_FLAGS["Nasional"]} Nasional",
        "Berita" to "${Constants.CATEGORY_FLAGS["Berita"]} Berita",
        "Edukasi" to "${Constants.CATEGORY_FLAGS["Edukasi"]} Edukasi",
        "Religi" to "${Constants.CATEGORY_FLAGS["Religi"]} Religi",
        "Daerah" to "${Constants.CATEGORY_FLAGS["Daerah"]} Daerah",
        "Hiburan" to "${Constants.CATEGORY_FLAGS["Hiburan"]} Hiburan",
        "Anak" to "${Constants.CATEGORY_FLAGS["Anak"]} Anak",
        "Olahraga" to "${Constants.CATEGORY_FLAGS["Olahraga"]} Olahraga",
        "JP" to "${countryFlag("JP")} Jepang",
        "KR" to "${countryFlag("KR")} Korea",
        "TH" to "${countryFlag("TH")} Thailand",
        "MY" to "${countryFlag("MY")} Malaysia",
        "BN" to "${countryFlag("BN")} Brunei",
        "SG" to "${countryFlag("SG")} Singapura",
        "PH" to "${countryFlag("PH")} Filipina"
    )

    private fun countryFlag(code: String): String {
        return Constants.COUNTRIES.find { it.code == code }?.flag ?: ""
    }

    private suspend fun refreshCache() {
        val now = System.currentTimeMillis()
        if (now - lastFetch < cacheTtl && allChannels.isNotEmpty()) return
        lastFetch = now

        val channels = mutableListOf<Constants.CategorizedChannel>()

        // Hardcoded Indonesian channels (TVRI, Nasional, Berita, Religi, Daerah, Hiburan, Anak)
        channels.addAll(Constants.TVRI_CATEGORIZED)
        channels.addAll(Constants.INDONESIAN_CHANNELS)

        // M3U - Indonesian sources
        for (source in Constants.M3U_SOURCES) {
            try {
                val resp = app.get(source)
                val parsed = M3UParser.parse(resp.text)
                channels.addAll(parsed.mapNotNull { categorizeM3uChannel(it) })
                if (parsed.isNotEmpty()) break
            } catch (_: Exception) { }
        }

        // International sources (hardcoded + M3U)
        for (country in Constants.COUNTRIES) {
            val hc = Constants.INTERNATIONAL_CHANNELS.filter { it.category == country.code }
            channels.addAll(hc)

            val m3uUrl = country.m3uUrl ?: continue
            try {
                val resp = app.get(m3uUrl)
                val parsed = M3UParser.parse(resp.text)
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
            } catch (_: Exception) { }
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
        val group = ch.group?.lowercase()?.trim() ?: ""
        val name = ch.name.lowercase()

        val category = when {
            group.isEmpty() -> categorizeByName(name)
            else -> Constants.CATEGORY_KEYWORDS.entries.find { entry ->
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

    private fun categorizeByName(name: String): String {
        return Constants.CATEGORY_KEYWORDS.entries.find { entry ->
            entry.value.any { keyword -> name.contains(keyword) }
        }?.key ?: "Nasional"
    }

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
        return newLiveStreamLoadResponse(
            name = channel.name,
            url = url,
            dataUrl = url
        ) { this.posterUrl = Constants.resolveLogo(channel.name, channel.tvgId, channel.tvgLogo) }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        refreshCache()
        val channel = channelCache[data] ?: return false
        callback.invoke(
            newExtractorLink(
                source = this.name,
                name = channel.name,
                url = data
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

    private fun parseQualityInt(q: String?): Int {
        if (q == null) return -1
        val digits = q.filter { it.isDigit() }
        val num = digits.toIntOrNull() ?: return -1
        return when {
            num >= 4000 -> 2160
            num >= 1000 -> 1080
            num >= 720 -> 720
            num >= 576 -> 576
            num >= 480 -> 480
            num >= 360 -> 360
            num >= 240 -> 240
            else -> -1
        }
    }
}
