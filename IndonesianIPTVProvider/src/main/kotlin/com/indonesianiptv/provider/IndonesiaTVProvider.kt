package com.indonesianiptv.provider

import com.indonesianiptv.model.M3UChannel
import com.indonesianiptv.model.M3UParser
import com.indonesianiptv.util.Constants
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class IndonesiaTVProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io"
    override var name = "Indonesia TV"
    override var lang = "id"
    override var hasMainPage = true
    override var supportedTypes = setOf(TvType.Live)

    private var allChannels: List<Constants.CategorizedChannel> = emptyList()
    private var channelCache: Map<String, Constants.CategorizedChannel> = emptyMap()
    private var lastFetch = 0L
    private val cacheTtl = 10 * 60 * 1000L

    override val mainPage = mainPageOf(
        "Nasional" to "Nasional",
        "Berita" to "Berita",
        "Edukasi" to "Edukasi",
        "Religi" to "Religi",
        "Daerah" to "Daerah",
        "Hiburan" to "Hiburan",
        "Musik" to "Musik",
        "Anak" to "Anak",
        "Olahraga" to "Olahraga",
        "Pemerintah" to "Pemerintah"
    )

    private suspend fun refreshCache() {
        val now = System.currentTimeMillis()
        if (now - lastFetch < cacheTtl && allChannels.isNotEmpty()) return
        lastFetch = now

        val hardcoded = Constants.TVRI_CATEGORIZED + Constants.INDONESIAN_CHANNELS

        val m3uChannels = mutableListOf<Constants.CategorizedChannel>()
        for (source in Constants.M3U_SOURCES) {
            try {
                val resp = app.get(source)
                val parsed = M3UParser.parse(resp.text)
                m3uChannels.addAll(parsed.mapNotNull { categorizeM3uChannel(it) })
                if (parsed.isNotEmpty()) break
            } catch (_: Exception) { }
        }

        val seen = mutableSetOf<String>()
        allChannels = (m3uChannels + hardcoded).filter {
            if (it.url in seen) false else { seen.add(it.url); true }
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

        val quality = parseQualityInt(ch.quality)

        return Constants.CategorizedChannel(
            name = ch.name,
            url = ch.streamUrl,
            category = category,
            tvgId = ch.tvgId,
            tvgLogo = ch.tvgLogo,
            headers = ch.headers,
            quality = quality
        )
    }

    private fun categorizeByName(name: String): String {
        return Constants.CATEGORY_KEYWORDS.entries.find { entry ->
            entry.value.any { keyword -> name.contains(keyword) }
        }?.key ?: "Nasional"
    }

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        refreshCache()
        val category = request.data
        val items = allChannels.filter { it.category == category }
        val pageSize = 50
        val start = (page - 1) * pageSize
        val end = minOf(start + pageSize, items.size)
        return newHomePageResponse(
            list = HomePageList(
                name = "${category} (${items.size} ch)",
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
        ) { this.posterUrl = channel.tvgLogo }
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
    ) { this.posterUrl = tvgLogo }

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
