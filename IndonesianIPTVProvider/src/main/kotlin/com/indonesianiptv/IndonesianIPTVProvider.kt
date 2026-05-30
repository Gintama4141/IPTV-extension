package com.indonesianiptv

import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.SearchResponse
import com.lagradost.cloudstream3.TvType
import com.lagradost.cloudstream3.newLiveSearchResponse
import com.lagradost.cloudstream3.MainPageRequest
import com.lagradost.cloudstream3.HomePageResponse
import com.lagradost.cloudstream3.newHomePageResponse
import com.lagradost.cloudstream3.HomePageList
import com.lagradost.cloudstream3.LoadResponse
import com.lagradost.cloudstream3.newLiveStreamLoadResponse
import com.lagradost.cloudstream3.LiveStreamLoadResponse
import com.lagradost.cloudstream3.SubtitleFile
import com.lagradost.cloudstream3.utils.ExtractorLink
import com.lagradost.cloudstream3.app
import com.lagradost.cloudstream3.fixUrl
import com.lagradost.cloudstream3.fixUrlNull
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class IndonesianIPTVProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io/iptv"
    override var name = "Indonesian IPTV"
    override val hasMainPage = true
    override var lang = "id"
    override val hasDownloadSupport = false
    override val supportedTypes = setOf(TvType.Live)

    // Indonesian TV Channels Data
    private val indonesianChannels = listOf(
        // TV Nasional
        ChannelData("TVRI Nasional", "https://live.tvri.go.id/live/tvrinasional/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/0/0e/TVRI_Nasional_logo_2019.svg/1200px-TVRI_Nasional_logo_2019.svg.png", "Nasional", "TVRI"),
        ChannelData("TVRI World", "https://live.tvri.go.id/live/tvriworld/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/9/9d/TVRI_World_logo_2019.svg/1200px-TVRI_World_logo_2019.svg.png", "Nasional", "TVRI"),
        ChannelData("TVRI Sport", "https://live.tvri.go.id/live/tvrivosport/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/8/8e/TVRI_Sport_logo_2019.svg/1200px-TVRI_Sport_logo_2019.svg.png", "Nasional", "TVRI"),
        
        // Stasiun TV Swasta Nasional
        ChannelData("RCTI", "https://rctiplus.akamaized.net/live/rcti/rcti/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/b/ba/RCTI_logo_2021.svg/1200px-RCTI_logo_2021.svg.png", "Nasional", "MNC Group"),
        ChannelData("MNC TV", "https://rctiplus.akamaized.net/live/mnctv/mnctv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/d/d5/MNC_TV_logo_2022.svg/1200px-MNC_TV_logo_2022.svg.png", "Nasional", "MNC Group"),
        ChannelData("GTV", "https://rctiplus.akamaized.net/live/gtv/gtv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/c/c0/GTV_2022.svg/1200px-GTV_2022.svg.png", "Nasional", "MNC Group"),
        ChannelData("iNews", "https://rctiplus.akamaized.net/live/inews/inews/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/1/1e/INews_2022.svg/1200px-INews_2022.svg.png", "Nasional", "MNC Group"),
        
        ChannelData("SCTV", "https://video.sctv.co.id/sctv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/SCTV_logo_2021.svg/1200px-SCTV_logo_2021.svg.png", "Nasional", "Surya Citra Media"),
        ChannelData("Indosiar", "https://video.indosiar.co.id/indosiar/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/8/84/Indosiar_2015.svg/1200px-Indosiar_2015.svg.png", "Nasional", "Surya Citra Media"),
        ChannelData("ANTV", "https://antvpremium.akamaized.net/antv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Antv_logo_2022.svg/1200px-Antv_logo_2022.svg.png", "Nasional", "Viva Group"),
        
        ChannelData("Trans TV", "https://transvideo.akamaized.net/tv/trans/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Trans_Tv_logo_2022.svg/1200px-Trans_Tv_logo_2022.svg.png", "Nasional", "Trans Media"),
        ChannelData("Trans7", "https://transvideo.akamaized.net/tv/trans7/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Trans7_logo_2022.svg/1200px-Trans7_logo_2022.svg.png", "Nasional", "Trans Media"),
        
        ChannelData("Metro TV", "https://live.metrotvnews.com/live/metrotv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Metro_TV_logo_2022.svg/1200px-Metro_TV_logo_2022.svg.png", "Nasional", "Media Group"),
        ChannelData("tvOne", "https://avtvone.akamaized.net/tv/antv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/TvOne_logo_2022.svg/1200px-TvOne_logo_2022.svg.png", "Nasional", "Viva Group"),
        ChannelData("BTV", "https://b1news.beritasatumedia.com/Beritasatu/B1News_manifest.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/BTV_logo_2023.svg/1200px-BTV_logo_2023.svg.png", "Nasional", "Bakrie Group"),
        
        // TV Berita
        ChannelData("Kompas TV", "https://live.kompastv.com/live/kompastv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Kompas_TV_logo_2022.svg/1200px-Kompas_TV_logo_2022.svg.png", "Berita", "Kompas Gramedia"),
        ChannelData("CNN Indonesia", "https://live.cnnindonesia.com/live/cnn/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/CNN_Indonesia_logo_2022.svg/1200px-CNN_Indonesia_logo_2022.svg.png", "Berita", "Trans Media"),
        ChannelData("CNBC Indonesia", "https://live.cnbcindonesia.com/live/cnbc/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/CNBC_Indonesia_logo_2022.svg/1200px-CNBC_Indonesia_logo_2022.svg.png", "Berita", "Trans Media"),
        
        // TV Olahraga
        ChannelData("TVRI Sport", "https://live.tvri.go.id/live/tvrivosport/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/id/thumb/8/8e/TVRI_Sport_logo_2019.svg/1200px-TVRI_Sport_logo_2019.svg.png", "Olahraga", "TVRI"),
        ChannelData("Sportstars", "https://live.vidio.com/live/sportstars/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Sportstars_logo_2022.svg/1200px-Sportstars_logo_2022.svg.png", "Olahraga", "Emtek Group"),
        
        // TV Anak
        ChannelData("RTV", "https://live.vidio.com/live/rtv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/RTV_logo_2022.svg/1200px-RTV_logo_2022.svg.png", "Anak", "Rajawali Corpora"),
        ChannelData("TV Edukasi", "https://live.tvri.go.id/live/tvedukasi/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/TV_Edukasi_logo_2022.svg/1200px-TV_Edukasi_logo_2022.svg.png", "Anak", "TVRI"),
        
        // TV Religi
        ChannelData("Rodja TV", "https://rojadutv.com/live/rodjatv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Rodja_TV_logo_2022.svg/1200px-Rodja_TV_logo_2022.svg.png", "Religi", "Rodja TV"),
        ChannelData("TV Al-Quran", "https://live.tvri.go.id/live/tvraqi/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/TV_Al-Quran_logo_2022.svg/1200px-TV_Al-Quran_logo_2022.svg.png", "Religi", "TVRI"),
        
        // TV Daerah
        ChannelData("JTV", "https://live.jtvonline.net/jtv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/JTV_logo_2022.svg/1200px-JTV_logo_2022.svg.png", "Daerah", "JTV"),
        ChannelData("Bali TV", "https://live.balitv.co.id/balitv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Bali_TV_logo_2022.svg/1200px-Bali_TV_logo_2022.svg.png", "Daerah", "Bali TV"),
        ChannelData("Surabaya TV", "https://live.surabayatv.co.id/surabayatv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Surabaya_TV_logo_2022.svg/1200px-Surabaya_TV_logo_2022.svg.png", "Daerah", "Surabaya TV"),
        ChannelData("Padang TV", "https://live.padangtv.co.id/padangtv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Padang_TV_logo_2022.svg/1200px-Padang_TV_logo_2022.svg.png", "Daerah", "Padang TV"),
        ChannelData("Banjarmasin TV", "https://live.banjarmasintv.co.id/banjarmasintv/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Banjarmasin_TV_logo_2022.svg/1200px-Banjarmasin_TV_logo_2022.svg.png", "Daerah", "Banjarmasin TV"),
        
        // TV Internasional ( tersedia di Indonesia)
        ChannelData("BBC World News", "https://live.bbc.co.uk/bbcwsworld/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/BBC_World_News_2019.svg/1200px-BBC_World_News_2019.svg.png", "Internasional", "BBC"),
        ChannelData("CNN International", "https://live.cnn.com/cnn/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/CNN_International_logo_2022.svg/1200px-CNN_International_logo_2022.svg.png", "Internasional", "Warner Bros. Discovery"),
        ChannelData("Al Jazeera", "https://live.aljazeera.com/aljazeera/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Al_Jazeera_logo_2022.svg/1200px-Al_Jazeera_logo_2022.svg.png", "Internasional", "Al Jazeera"),
        ChannelData("NHK World", "https://live3.nhk.or.jp/nhkworld/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/NHK_World_logo_2022.svg/1200px-NHK_World_logo_2022.svg.png", "Internasional", "NHK"),
        ChannelData("DW", "https://live.dw.com/dw/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/DW_logo_2022.svg/1200px-DW_logo_2022.svg.png", "Internasional", "DW"),
        ChannelData("France 24", "https://live.france24.com/france24/playlist.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/France_24_logo_2022.svg/1200px-France_24_logo_2022.svg.png", "Internasional", "France Médias Monde"),
    )

    data class ChannelData(
        val name: String,
        val streamUrl: String,
        val logoUrl: String,
        val category: String,
        val provider: String
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
            it.category.contains(query, ignoreCase = true) ||
            it.provider.contains(query, ignoreCase = true)
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
            this.plot = "Channel: ${channel?.name}\nProvider: ${channel?.provider}\nCategory: ${channel?.category}"
            this.tags = listOf(channel?.category ?: "Unknown")
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        // For IPTV, the data is the direct stream URL
        if (data.isNotEmpty()) {
            callback.invoke(
                ExtractorLink(
                    source = this.name,
                    name = this.name,
                    url = data,
                    referer = "",
                    quality = com.lagradost.cloudstream3.utils.Qualities.P1080.value,
                    isM3u8 = data.contains(".m3u8")
                )
            )
        }
        return true
    }
}
