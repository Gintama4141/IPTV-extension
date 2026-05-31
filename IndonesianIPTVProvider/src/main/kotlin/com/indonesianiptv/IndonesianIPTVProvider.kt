package com.indonesianiptv

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class IndonesianIPTVProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io/iptv"
    override var name = "Indonesian IPTV"
    override val hasMainPage = true
    override var lang = "id"
    override val hasDownloadSupport = false
    override val supportedTypes = setOf(TvType.Live)

    private val indonesianChannels = listOf(
        ChannelData("TVRI Nasional", "https://live.tvri.go.id/live/tvrinasional/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/0/0e/TVRI_Nasional_logo_2019.svg/1200px-TVRI_Nasional_logo_2019.svg.png", "Nasional"),
        ChannelData("TVRI World", "https://live.tvri.go.id/live/tvriworld/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/9/9d/TVRI_World_logo_2019.svg/1200px-TVRI_World_logo_2019.svg.png", "Nasional"),
        ChannelData("TVRI Sport", "https://live.tvri.go.id/live/tvrivosport/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/8/8e/TVRI_Sport_logo_2019.svg/1200px-TVRI_Sport_logo_2019.svg.png", "Nasional"),
        ChannelData("RCTI", "https://rctiplus.akamaized.net/live/rcti/rcti/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/b/ba/RCTI_logo_2021.svg/1200px-RCTI_logo_2021.svg.png", "Nasional"),
        ChannelData("MNC TV", "https://rctiplus.akamaized.net/live/mnctv/mnctv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/d/d5/MNC_TV_logo_2022.svg/1200px-MNC_TV_logo_2022.svg.png", "Nasional"),
        ChannelData("GTV", "https://rctiplus.akamaized.net/live/gtv/gtv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/c/c0/GTV_2022.svg/1200px-GTV_2022.svg.png", "Nasional"),
        ChannelData("iNews", "https://rctiplus.akamaized.net/live/inews/inews/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/1/1e/INews_2022.svg/1200px-INews_2022.svg.png", "Nasional"),
        ChannelData("SCTV", "https://video.sctv.co.id/sctv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/SCTV_logo_2021.svg/1200px-SCTV_logo_2021.svg.png", "Nasional"),
        ChannelData("Indosiar", "https://video.indosiar.co.id/indosiar/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/8/84/Indosiar_2015.svg/1200px-Indosiar_2015.svg.png", "Nasional"),
        ChannelData("ANTV", "https://antvpremium.akamaized.net/antv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Antv_logo_2022.svg/1200px-Antv_logo_2022.svg.png", "Nasional"),
        ChannelData("Trans TV", "https://transvideo.akamaized.net/tv/trans/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Trans_Tv_logo_2022.svg/1200px-Trans_Tv_logo_2022.svg.png", "Nasional"),
        ChannelData("Trans7", "https://transvideo.akamaized.net/tv/trans7/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Trans7_logo_2022.svg/1200px-Trans7_logo_2022.svg.png", "Nasional"),
        ChannelData("Metro TV", "https://live.metrotvnews.com/live/metrotv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Metro_TV_logo_2022.svg/1200px-Metro_TV_logo_2022.svg.png", "Nasional"),
        ChannelData("tvOne", "https://avtvone.akamaized.net/tv/antv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/TvOne_logo_2022.svg/1200px-TvOne_logo_2022.svg.png", "Nasional"),
        ChannelData("BTV", "https://b1news.beritasatumedia.com/Beritasatu/B1News_manifest.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/BTV_logo_2023.svg/1200px-BTV_logo_2023.svg.png", "Nasional"),
        ChannelData("Kompas TV", "https://live.kompastv.com/live/kompastv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Kompas_TV_logo_2022.svg/1200px-Kompas_TV_logo_2022.svg.png", "Berita"),
        ChannelData("CNN Indonesia", "https://live.cnnindonesia.com/live/cnn/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/CNN_Indonesia_logo_2022.svg/1200px-CNN_Indonesia_logo_2022.svg.png", "Berita"),
        ChannelData("CNBC Indonesia", "https://live.cnbcindonesia.com/live/cnbc/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/CNBC_Indonesia_logo_2022.svg/1200px-CNBC_Indonesia_logo_2022.svg.png", "Berita"),
        ChannelData("TVRI Sport", "https://live.tvri.go.id/live/tvrivosport/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/8/8e/TVRI_Sport_logo_2019.svg/1200px-TVRI_Sport_logo_2019.svg.png", "Olahraga"),
        ChannelData("RTV", "https://live.vidio.com/live/rtv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/RTV_logo_2022.svg/1200px-RTV_logo_2022.svg.png", "Anak"),
        ChannelData("Rodja TV", "https://rojadutv.com/live/rodjatv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Rodja_TV_logo_2022.svg/1200px-Rodja_TV_logo_2022.svg.png", "Religi"),
        ChannelData("JTV", "https://live.jtvonline.net/jtv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/JTV_logo_2022.svg/1200px-JTV_logo_2022.svg.png", "Daerah"),
        ChannelData("Bali TV", "https://live.balitv.co.id/balitv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Bali_TV_logo_2022.svg/1200px-Bali_TV_logo_2022.svg.png", "Daerah"),
        ChannelData("BBC World News", "https://live.bbc.co.uk/bbcwsworld/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/BBC_World_News_2019.svg/1200px-BBC_World_News_2019.svg.png", "Internasional"),
        ChannelData("CNN International", "https://live.cnn.com/cnn/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/CNN_International_logo_2022.svg/1200px-CNN_International_logo_2022.svg.png", "Internasional"),
        ChannelData("Al Jazeera", "https://live.aljazeera.com/aljazeera/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Al_Jazeera_logo_2022.svg/1200px-Al_Jazeera_logo_2022.svg.png", "Internasional"),
        ChannelData("DW", "https://live.dw.com/dw/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/DW_logo_2022.svg/1200px-DW_logo_2022.svg.png", "Internasional"),
        ChannelData("France 24", "https://live.france24.com/france24/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/France_24_logo_2022.svg/1200px-France_24_logo_2022.svg.png", "Internasional"),
    )

    data class ChannelData(
        val name: String,
        val streamUrl: String,
        val logoUrl: String,
        val category: String
    )

    override val mainPage = mainPageOf(
        "Semua" to "Semua Channel",
        "Nasional" to "TV Nasional",
        "Berita" to "TV Berita",
        "Olahraga" to "TV Olahraga",
        "Anak" to "TV Anak",
        "Religi" to "TV Religi",
        "Daerah" to "TV Daerah",
        "Internasional" to "TV Internasional"
    )

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val filteredChannels = when (request.data) {
            "Semua" -> indonesianChannels
            else -> indonesianChannels.filter { it.category == request.data }
        }

        val home = filteredChannels.map { channel ->
            newLiveSearchResponse(
                name = channel.name,
                url = channel.streamUrl,
                type = TvType.Live
            ) {
                this.posterUrl = channel.logoUrl
            }
        }

        return newHomePageResponse(
            list = HomePageList(
                name = request.name,
                list = home,
                isHorizontalImages = false
            ),
            hasNext = false
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        return indonesianChannels.filter {
            it.name.contains(query, ignoreCase = true) ||
            it.category.contains(query, ignoreCase = true)
        }.map { channel ->
            newLiveSearchResponse(
                name = channel.name,
                url = channel.streamUrl,
                type = TvType.Live
            ) {
                this.posterUrl = channel.logoUrl
            }
        }
    }

    override suspend fun load(url: String): LoadResponse {
        val channel = indonesianChannels.find { it.streamUrl == url }

        return newLiveStreamLoadResponse(
            name = channel?.name ?: "Unknown Channel",
            url = url,
            dataUrl = url
        ) {
            this.posterUrl = channel?.logoUrl
            this.plot = "Channel: ${channel?.name}\nCategory: ${channel?.category}"
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        if (data.isNotEmpty()) {
            callback.invoke(
                newExtractorLink(this.name, this.name, data) {
                    this.quality = Qualities.P1080.value
                }
            )
        }
        return true
    }
}
