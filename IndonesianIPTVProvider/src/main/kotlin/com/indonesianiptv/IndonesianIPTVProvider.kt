package com.indonesianiptv

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class IndonesianIPTVProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io/api"
    override var name = "Indonesian IPTV"
    override val hasMainPage = true
    override var lang = "id"
    override val hasDownloadSupport = false
    override val supportedTypes = setOf(TvType.Live)

    private val iconBase = "https://raw.githubusercontent.com/riotryulianto/iptv-playlists/main/icons"

    private val indonesianChannels = listOf(
        ChannelData("TVRI Nasional", "https://ott-balancer.tvri.go.id/live/eds/Nasional/hls/Nasional.m3u8", "$iconBase/tvri.png", "Nasional"),
        ChannelData("TVRI World", "https://ott-balancer.tvri.go.id/live/eds/TVRIWorld/hls/TVRIWorld.m3u8", "$iconBase/tvriworld.png", "Nasional"),
        ChannelData("RCTI", "http://103.66.62.83:8000/play/a00v/index.m3u8", "$iconBase/rcti.png", "Nasional"),
        ChannelData("SCTV", "https://op-group1-swiftservehd-1.dens.tv/h/h217/index.m3u8", "$iconBase/sctv.png", "Nasional"),
        ChannelData("Indosiar", "https://op-group1-swiftservehd-1.dens.tv/h/h235/index.m3u8", "$iconBase/indosiar.png", "Nasional"),
        ChannelData("ANTV", "http://103.58.160.157:8278/720-ANTV/playlist.m3u8", "$iconBase/antv.png", "Nasional"),
        ChannelData("Trans TV", "https://video.detik.com/transtv/smil:transtv.smil/index.m3u8", "$iconBase/transtv.png", "Nasional"),
        ChannelData("Trans7", "https://video.detik.com/trans7/smil:trans7.smil/index.m3u8", "$iconBase/trans7.png", "Nasional"),
        ChannelData("Metro TV", "https://edge.medcom.id/live-edge/smil:metro.smil/playlist.m3u8", "$iconBase/metrotv.png", "Nasional"),
        ChannelData("tvOne", "http://202.80.222.20/cdn/iptv/Tvod/001/channel2000018/1024.m3u8", "$iconBase/tvone.png", "Nasional"),
        ChannelData("BTV", "https://btv.secureswiftcontent.com/han/btv/btv10005r/srtoutput/manifest.m3u8", "$iconBase/btv.png", "Nasional"),
        ChannelData("MDTV", "https://wahyu1ptv.pages.dev/MDTV-HD.m3u8", "$iconBase/net.png", "Nasional"),
        ChannelData("Magna Channel", "https://edge.medcom.id/live-edge/smil:magna.smil/playlist.m3u8", "$iconBase/magna.png", "Nasional"),
        ChannelData("Nusantara TV", "https://nusantaratv.siar.us/nusantaratv/live/playlist.m3u8", "$iconBase/nusantaratv.png", "Nasional"),
        ChannelData("Garuda TV", "https://hgmtv.com:19360/garudatvlivestreaming/garudatvlivestreaming.m3u8", "$iconBase/antv.png", "Nasional"),
        ChannelData("VTV", "http://103.66.62.83:8000/play/a00c/index.m3u8", "$iconBase/vtv.png", "Nasional"),
        ChannelData("Kompas TV", "https://op-group1-swiftservehd-1.dens.tv/h/h234/index.m3u8", "$iconBase/kompastv.png", "Berita"),
        ChannelData("CNN Indonesia", "https://live.cnnindonesia.com/livecnn/smil:cnntv.smil/playlist.m3u8", "$iconBase/cnnindonesia.png", "Berita"),
        ChannelData("CNBC Indonesia", "https://live.cnbcindonesia.com/livecnbc/smil:cnbctv.smil/master.m3u8", "$iconBase/cnbcindonesia.png", "Berita"),
        ChannelData("IDTV", "https://b1world.beritasatumedia.com/Beritasatu/B1World_manifest.m3u8", "$iconBase/idtv.png", "Berita"),
        ChannelData("Metro Globe Network", "https://edge.medcom.id/live-edge/smil:mgnch.smil/playlist.m3u8", "$iconBase/mgn.png", "Berita"),
        ChannelData("BeritaSatu", "https://beritasatu.secureswiftcontent.com/han/beritasatu/bsatu10008r/srtoutput/manifest.m3u8", "$iconBase/btv.png", "Berita"),
        ChannelData("Jakarta Globe News", "https://jktglobe.secureswiftcontent.com/han/jktglobe/jktglober/srtoutput/manifest.m3u8", "$iconBase/idtv.png", "Berita"),
        ChannelData("TVRI Sport", "https://ott-balancer.tvri.go.id/live/eds/SportHD/hls/SportHD.m3u8", "$iconBase/tvrisport.png", "Olahraga"),
        ChannelData("SPOTV", "http://primestreams.tv:826/live/mookie22/49aV7nBsK4/119515.m3u8", "$iconBase/tvrisport.png", "Olahraga"),
        ChannelData("SPOTV2", "http://primestreams.tv:826/live/mookie22/49aV7nBsK4/119516.m3u8", "$iconBase/tvrisport.png", "Olahraga"),
        ChannelData("RTV", "https://rtvstream.rtv.co.id:4555/hls/rtv.m3u8", "$iconBase/rtv.png", "Anak"),
        ChannelData("Biznet Kids", "http://livestream.biznetvideo.net/biznet_kids/smil:kids.smil/index.m3u8", "$iconBase/mykidz.png", "Anak"),
        ChannelData("Rodja TV", "https://rodjatv.com/rodjatv/live.m3u8", "$iconBase/rodjatv.png", "Religi"),
        ChannelData("DAAI TV", "https://pull.daaiplus.com/live-DAAIPLUS/live-DAAIPLUS_HD.m3u8", "$iconBase/daaitv.png", "Religi"),
        ChannelData("RRI Net", "https://private-streaming.rri.go.id/memfs/6f77c7b5-feb2-4935-9f89-e7e9fca0a54a_output_0.m3u8", "$iconBase/rrinet.png", "Religi"),
        ChannelData("TV Mu", "https://e.siar.us/live/tvmu.m3u8", "$iconBase/tvri.png", "Religi"),
        ChannelData("Surau TV", "https://surautv.siar.us/live/surautv.m3u8", "$iconBase/rcti.png", "Religi"),
        ChannelData("Al Iman TV", "https://tv.aliman.id/aliman/live.m3u8", "$iconBase/rodjatv.png", "Religi"),
        ChannelData("Salam TV", "https://salamtv.siar.us/live/salamtv.m3u8", "$iconBase/rodjatv.png", "Religi"),
        ChannelData("JTV", "http://122.248.43.242:1935/JTVSURABAYA/_definst_/myStream/playlist.m3u8", "$iconBase/jtv.png", "Daerah"),
        ChannelData("Elshinta TV", "https://ams.juraganstreaming.com:5443/LiveApp/streams/elshintatv.m3u8", "$iconBase/rcti.png", "Daerah"),
        ChannelData("TVKU", "https://tvku.tv/hlsstream/hls/live.m3u8", "$iconBase/vtv.png", "Daerah"),
        ChannelData("Surabaya TV", "https://e.siar.us/live/surabayatv.m3u8", "$iconBase/mnctv.png", "Daerah"),
        ChannelData("Stara TV", "https://stream.staratv.id/hls/0/stream.m3u8", "$iconBase/jtv.png", "Daerah"),
        ChannelData("Jawa Pos TV", "http://122.248.43.242:1935/JAWAPOSTVSBY/_definst_/myStream/playlist.m3u8", "$iconBase/jtv.png", "Daerah"),
        ChannelData("Jogja Istimewa TV", "http://103.255.15.222:1935/tv/jitv_720p/playlist.m3u8", "$iconBase/jtv.png", "Daerah"),
        ChannelData("Semarang TV", "http://116.254.112.74/hls/cakralive.m3u8", "$iconBase/jtv.png", "Daerah"),
        ChannelData("PJTV", "https://pjtv28uhf.siar.us/live/pjtv28uhf.m3u8", "$iconBase/rcti.png", "Daerah"),
        ChannelData("Caruban TV", "https://stream.carubantv.id/hls/0/stream.m3u8", "$iconBase/jtv.png", "Daerah"),
        ChannelData("Dhoho TV", "https://dhohotv.siar.us/dhohotv/live/playlist.m3u8", "$iconBase/jtv.png", "Daerah"),
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
        "Daerah" to "TV Daerah"
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
