package com.indonesianiptv.provider

import com.indonesianiptv.model.M3UParser
import com.indonesianiptv.util.Constants
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class InternationalTVProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io"
    override var name = "International TV"
    override var lang = "en"
    override var hasMainPage = true
    override var supportedTypes = setOf(TvType.Live)

    private var allChannels: List<Constants.CategorizedChannel> = emptyList()
    private var channelCache: Map<String, Constants.CategorizedChannel> = emptyMap()
    private var lastFetch = 0L
    private val cacheTtl = 10 * 60 * 1000L

    override val mainPage = mainPageOf(
        *Constants.COUNTRIES.map { it.code to it.name }.toTypedArray()
    )

    private suspend fun refreshCache() {
        val now = System.currentTimeMillis()
        if (now - lastFetch < cacheTtl && allChannels.isNotEmpty()) return
        lastFetch = now

        val channels = mutableListOf<Constants.CategorizedChannel>()

        for (country in Constants.COUNTRIES) {
            val hardcoded = Constants.INTERNATIONAL_CHANNELS.filter { it.category == country.code }
            channels.addAll(hardcoded)

            val m3uUrl = country.m3uUrl ?: continue
            try {
                val resp = app.get(m3uUrl)
                val parsed = M3UParser.parse(resp.text)
                for (ch in parsed) {
                    val quality = parseQualityInt(ch.quality)
                    channels.add(Constants.CategorizedChannel(
                        name = ch.name,
                        url = ch.streamUrl,
                        category = country.code,
                        tvgId = ch.tvgId,
                        tvgLogo = ch.tvgLogo,
                        headers = ch.headers,
                        quality = quality
                    ))
                }
            } catch (_: Exception) { }
        }

        val seen = mutableSetOf<String>()
        allChannels = channels.filter {
            if (it.url in seen) false else { seen.add(it.url); true }
        }
        channelCache = allChannels.associateBy { it.url }
    }

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        refreshCache()
        val countryCode = request.data
        val items = allChannels.filter { it.category == countryCode }
        val pageSize = 50
        val start = (page - 1) * pageSize
        val end = minOf(start + pageSize, items.size)
        return newHomePageResponse(
            list = HomePageList(
                name = "${countryCode} (${items.size} ch)",
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
