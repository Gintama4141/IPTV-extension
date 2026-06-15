package com.indonesianiptv.provider

import com.indonesianiptv.util.Constants
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class NewsChannelsProvider : MainAPI() {
    override var mainUrl = ""
    override var name = "Berita Indonesia"
    override var lang = "id"
    override var hasMainPage = true
    override var supportedTypes = setOf(TvType.Live)

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val items = Constants.NEWS_CHANNELS.map { (name, url, _) ->
            newLiveSearchResponse(name = name, url = url) { }
        }
        return newHomePageResponse(
            list = HomePageList(
                name = "\uD83D\uDCF0 News (${items.size} ch)",
                list = items
            )
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val q = query.lowercase()
        return Constants.NEWS_CHANNELS.filter {
            it.first.lowercase().contains(q)
        }.map { (name, url, _) ->
            newLiveSearchResponse(name = name, url = url) { }
        }
    }

    override suspend fun load(url: String): LoadResponse? {
        val entry = Constants.NEWS_CHANNELS.find { it.second == url } ?: return null
        return newLiveStreamLoadResponse(name = entry.first, url = url, dataUrl = url)
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        val entry = Constants.NEWS_CHANNELS.find { it.second == data } ?: return false
        callback.invoke(
            newExtractorLink(source = this.name, name = entry.first, url = data) {
                this.quality = 720
                this.headers = entry.third
            }
        )
        return true
    }
}
