package com.indonesianiptv.provider

import com.indonesianiptv.model.M3UChannel
import com.indonesianiptv.model.M3UParser
import com.indonesianiptv.util.Constants
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class M3UAggregatorProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io"
    override var name = "IPTV Indonesia"
    override var lang = "id"
    override var hasMainPage = true
    override var supportedTypes = setOf(TvType.Live)

    private var allChannels: List<M3UChannel> = emptyList()
    private var channelCache: Map<String, M3UChannel> = emptyMap()
    private var lastFetch = 0L
    private val cacheTtl = 10 * 60 * 1000L

    private suspend fun refreshCache() {
        val now = System.currentTimeMillis()
        if (now - lastFetch < cacheTtl && allChannels.isNotEmpty()) return
        lastFetch = now
        for (source in Constants.M3U_SOURCES) {
            try {
                val resp = app.get(source)
                val parsed = M3UParser.parse(resp.text)
                if (parsed.isNotEmpty()) {
                    allChannels = parsed
                    channelCache = parsed.associateBy { it.streamUrl }
                    return
                }
            } catch (_: Exception) { }
        }
    }

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        refreshCache()
        val items = allChannels.map { it.toSearchResponse() }
        val pageSize = 50
        val start = (page - 1) * pageSize
        val end = minOf(start + pageSize, items.size)
        val hasNext = end < items.size
        return newHomePageResponse(
            list = HomePageList(
                name = "\uD83C\uDF0D Indonesia (${allChannels.size} ch)",
                list = items.subList(start, end)
            ),
            hasNext = hasNext
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        refreshCache()
        val q = query.lowercase()
        return allChannels.filter {
            it.name.lowercase().contains(q) ||
            it.group?.lowercase()?.contains(q) == true
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
                this.quality = parseQualityInt(channel.quality)
                this.headers = channel.headers
            }
        )
        return true
    }

    private fun M3UChannel.toSearchResponse() = newLiveSearchResponse(
        name = name,
        url = streamUrl
    ) {
        this.posterUrl = tvgLogo
    }

    private fun parseQualityString(q: String?): String? {
        if (q == null) return null
        val digits = q.filter { it.isDigit() }
        val num = digits.toIntOrNull() ?: return null
        return when {
            num >= 4000 -> "2160p"
            num >= 1000 -> "1080p"
            num >= 720 -> "720p"
            num >= 576 -> "576p"
            num >= 480 -> "480p"
            num >= 360 -> "360p"
            num >= 240 -> "240p"
            else -> null
        }
    }

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
