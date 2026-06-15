package com.indonesianiptv.provider

import com.indonesianiptv.util.Constants
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class TvriOfficialProvider : MainAPI() {
    override var mainUrl = "https://klik.tvri.go.id"
    override var name = "TVRI Official"
    override var lang = "id"
    override var hasMainPage = true
    override var supportedTypes = setOf(TvType.Live)

    private val headers = mapOf("User-Agent" to Constants.TVRI_UA)
    private val channelList = Constants.TVRI_CHANNELS

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val items = channelList.map { (slug, name) ->
            newLiveSearchResponse(name = name, url = buildUrl(slug)) {
            newLiveSearchResponse(name = name, url = buildUrl(slug)) { }
            }
        }
        return newHomePageResponse(
            list = HomePageList(
                name = "\uD83D\uDCFA TVRI (${channelList.size} ch)",
                list = items
            )
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val q = query.lowercase()
        return channelList.filter {
            it.second.lowercase().contains(q) || it.first.lowercase().contains(q)
        }.map { (slug, name) ->
            newLiveSearchResponse(name = name, url = buildUrl(slug)) {
            newLiveSearchResponse(name = name, url = buildUrl(slug)) { }
            }
        }
    }

    override suspend fun load(url: String): LoadResponse? {
        val slug = url.substringAfterLast("eds/").substringBefore("/hls")
        return newLiveStreamLoadResponse(
            name = slug,
            url = url,
            dataUrl = url
        )
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        callback.invoke(
            newExtractorLink(
                source = this.name,
                name = "TVRI",
                url = data
            ) {
                this.quality = 720
                this.headers = headers
            }
        )
        return true
    }

    private fun buildUrl(slug: String): String {
        return "${Constants.TVRI_BASE}/$slug/hls/$slug.m3u8"
    }
}
