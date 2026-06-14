package com.indonesianiptv

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class IndonesianIPTVProvider : MainAPI() {
    override var mainUrl = "https://iptv-org.github.io/api"
    override var name = "Indonesian IPTV"
    override val hasMainPage = true
    override var lang = "id"
    override val hasDownloadSupport = false
    override val supportedTypes = setOf(TvType.Live, TvType.TvSeries)

    companion object {
        private const val ITEMS_PER_PAGE = 10
    }

    private fun getPageChannels(channels: List<ChannelData>, page: Int): List<ChannelData> {
        val startIndex = (page - 1) * ITEMS_PER_PAGE
        if (startIndex >= channels.size) return emptyList()
        val endIndex = minOf(startIndex + ITEMS_PER_PAGE, channels.size)
        return channels.subList(startIndex, endIndex)
    }

    private val iconBase = "https://raw.githubusercontent.com/riotryulianto/iptv-playlists/main/icons"
    private val alkhalifitvBase = "https://raw.githubusercontent.com/alkhalifitv/TV/master/big"
    private val genericIptv = "$iconBase/iptv.png"

    // TVRI configuration
    private val tvriBaseUrl = "https://ott-balancer.tvri.go.id/live/eds"
    private val tvriIcon = "$iconBase/tvri.png"
    private val tvriWorldIcon = "$iconBase/tvriworld.png"
    private val tvriSportIcon = "$iconBase/tvrisport.png"
    private val tvriHeaders = mapOf(
        "User-Agent" to "TVRIKLIK/7.0 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"
    )

    // MNC logo base
    private val mimipipiLogo = "https://mimipipi22.github.io/logo/nasional"

    data class ChannelData(
        val name: String,
        val streamUrl: String,
        val logoUrl: String,
        val group: String,
        val subCategory: String? = null,
        val headers: Map<String, String> = emptyMap(),
        val referer: String? = null,
        val isUnstable: Boolean = false
    )

    // ==================== TVRI CHANNELS (34) ====================
    private val tvriChannels = listOf(
        ChannelData("TVRI Nasional", "$tvriBaseUrl/Nasional/hls/Nasional.m3u8", tvriIcon, "TVRI", "Nasional", tvriHeaders),
        ChannelData("TVRI World", "$tvriBaseUrl/TVRIWorld/hls/TVRIWorld.m3u8", tvriWorldIcon, "TVRI", "Nasional", tvriHeaders),
        ChannelData("TVRI Sport", "$tvriBaseUrl/SportHD/hls/SportHD.m3u8", tvriSportIcon, "TVRI", "Olahraga", tvriHeaders),
        ChannelData("TVRI Aceh", "$tvriBaseUrl/Aceh/hls/Aceh.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Bali", "$tvriBaseUrl/Bali/hls/Bali.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Bangka Belitung", "$tvriBaseUrl/Babel/hls/Babel.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Bengkulu", "$tvriBaseUrl/Bengkulu/hls/Bengkulu.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI DIY", "$tvriBaseUrl/DIY/hls/DIY.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Gorontalo", "$tvriBaseUrl/Gorontalo/hls/Gorontalo.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Jakarta", "$tvriBaseUrl/DKI/hls/DKI.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Jambi", "$tvriBaseUrl/Jambi/hls/Jambi.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Jawa Barat", "$tvriBaseUrl/Jabar/hls/Jabar.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Jawa Tengah", "$tvriBaseUrl/Jateng/hls/Jateng.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Jawa Timur", "$tvriBaseUrl/Jatim/hls/Jatim.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Kalimantan Barat", "$tvriBaseUrl/Kalbar/hls/Kalbar.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Kalimantan Selatan", "$tvriBaseUrl/Kalsel/hls/Kalsel.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Kalimantan Tengah", "$tvriBaseUrl/Kalteng/hls/Kalteng.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Kalimantan Timur", "$tvriBaseUrl/Kaltim/hls/Kaltim.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Lampung", "$tvriBaseUrl/Lampung/hls/Lampung.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Maluku", "$tvriBaseUrl/Maluku/hls/Maluku.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Maluku Utara", "$tvriBaseUrl/Malut/hls/Malut.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI NTT", "$tvriBaseUrl/NTT/hls/NTT.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI NTB", "$tvriBaseUrl/NTB/hls/NTB.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Papua", "$tvriBaseUrl/Papua/hls/Papua.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Papua Barat", "$tvriBaseUrl/PapuaBarat/hls/PapuaBarat.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Riau", "$tvriBaseUrl/Riau/hls/Riau.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Barat", "$tvriBaseUrl/Sulbar/hls/Sulbar.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Selatan", "$tvriBaseUrl/Sulsel/hls/Sulsel.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Tengah", "$tvriBaseUrl/Sulteng/hls/Sulteng.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Tenggara", "$tvriBaseUrl/Sultra/hls/Sultra.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Utara", "$tvriBaseUrl/Sulut/hls/Sulut.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Sumatera Barat", "$tvriBaseUrl/Sumbar/hls/Sumbar.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Sumatera Selatan", "$tvriBaseUrl/Sumsel/hls/Sumsel.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
        ChannelData("TVRI Sumatera Utara", "$tvriBaseUrl/Sumut/hls/Sumut.m3u8", tvriIcon, "TVRI", "Daerah", tvriHeaders),
    )

    // ==================== MNC GROUP - RCTI+ FTA (4) ====================
    private val mncHeaders = mapOf(
        "User-Agent" to "MNCNow/6.33.3 (Linux;Android 15.0.0;)ExoPlayerLib/2.19.1"
    )

    private val mncChannels = listOf(
        ChannelData("RCTI", "https://d35d0ifx19oopq.cloudfront.net/live/eds/rcti_fta/live_fta/rcti_fta.m3u8", "$mimipipiLogo/rcti.jpg", "MNC", headers = mncHeaders, referer = "https://www.rctiplus.com/tv/rcti"),
        ChannelData("MNCTV", "https://d33j155pv2xyba.cloudfront.net/live/eds/mnctv_fta/live_fta/mnctv_fta.m3u8", "$mimipipiLogo/mnctv.jpg", "MNC", headers = mncHeaders, referer = "https://www.rctiplus.com/tv/mnctv"),
        ChannelData("GTV", "https://d322b885qvsbxg.cloudfront.net/live/eds/gtv_fta/live_fta/gtv_fta.m3u8", "$mimipipiLogo/gtv.jpg", "MNC", headers = mncHeaders, referer = "https://www.rctiplus.com/tv/gtv"),
        ChannelData("iNews", "https://d2hfpzcndkyscp.cloudfront.net/live/eds/INEWS_2021/live_fta/INEWS_2021.m3u8", "$mimipipiLogo/inews.jpg", "MNC", headers = mncHeaders, referer = "https://www.rctiplus.com/tv/inews"),
    )

    // ==================== NASIONAL CHANNELS (12) ====================
    private val nationalChannels = listOf(
        ChannelData("Trans TV", "https://livestream.transtv.co.id/stream/live/ttv.m3u8", "$iconBase/transtv.png", "NASIONAL", referer = "https://www.detik.com/"),
        ChannelData("Trans7", "https://video.detik.com/trans7/smil:trans7.smil/index.m3u8", "$iconBase/trans7.png", "NASIONAL", referer = "https://www.detik.com/"),
        ChannelData("SCTV", "http://op-group1-swiftservehd-1.dens.tv/h/h217/02.m3u8", "https://images.useetv.com/logo_sctv_big1.png", "NASIONAL", headers = mapOf("User-Agent" to "DENSGO/3.00.00 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"), referer = "http://dens.tv"),
        ChannelData("Indosiar", "http://op-group1-swiftservehd-1.dens.tv/h/h207/02.m3u8", "https://images.useetv.com/logo_indosiar_big1.png", "NASIONAL", headers = mapOf("User-Agent" to "DENSGO/3.00.00 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"), referer = "http://dens.tv"),
        ChannelData("NET TV", "https://cdn-accedo-01.akamaized.net/Content/HLS/Live/channel(404d689d-691f-4035-9801-ae8bfd8712e9)/index.m3u8", "https://mimipipi22.github.io/logo/nasional/nettv.jpg", "NASIONAL"),
        ChannelData("O Channel (Moji)", "https://kmklive-lh.akamaihd.net/i/ochannel_live@577566/master.m3u8", "$iconBase/moji.png", "NASIONAL"),
        ChannelData("tvOne", "https://yt.urfan.web.id/stream/yNKvkPJl-tg/master.m3u8", "$iconBase/tvone.png", "NASIONAL", headers = mapOf("User-Agent" to "ExoPlayer/2.19.1 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1")),
        ChannelData("ANTV", "http://210.210.155.35/qwr9ew/s/s07/index1.m3u8", "$iconBase/antv.png", "NASIONAL", headers = mapOf("User-Agent" to "ExoPlayer/2.19.1 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"), isUnstable = true),
        ChannelData("Mentari TV", "https://app-etslive-2.vidio.com/live/8237/master.m3u8", "$iconBase/mentaritv.png", "NASIONAL"),
        ChannelData("Magna Channel", "https://edge.medcom.id/live-edge/smil:magna.smil/playlist.m3u8", "$iconBase/magna.png", "NASIONAL"),
        ChannelData("Nusantara TV", "https://nusantaratv.siar.us/nusantaratv/live/playlist.m3u8", "$iconBase/nusantaratv.png", "NASIONAL"),
        ChannelData("Indonesiana TV", "https://tvstreamcast.com/indonesiana.m3u8", "$iconBase/indonesiana.png", "NASIONAL", referer = "https://indonesiana.tv/"),
        ChannelData("Garuda TV", "https://hgmtv.com:19360/garudatvlivestreaming/garudatvlivestreaming.m3u8", "$alkhalifitvBase/garudatv.png", "NASIONAL"),
    )

    // ==================== BERITA CHANNELS (6) ====================
    private val newsChannels = listOf(
        ChannelData("Metro TV", "https://yt.urfan.web.id/stream/XKueVSGTk2o/master.m3u8", "$iconBase/metrotv.png", "BERITA"),
        ChannelData("Kompas TV", "https://live-kg.jixie.media/live/kompastv.m3u8", "$iconBase/kompastv.png", "BERITA"),
        ChannelData("CNN Indonesia", "https://live.cnnindonesia.com/livecnn/smil:cnntv.smil/playlist.m3u8", "$iconBase/cnnindonesia.png", "BERITA", referer = "https://www.cnnindonesia.com/"),
        ChannelData("CNBC Indonesia", "https://live.cnbcindonesia.com/livecnbc/smil:cnbctv.smil/master.m3u8", "$iconBase/cnbcindonesia.png", "BERITA", referer = "https://www.cnbcindonesia.com/"),
        ChannelData("BTV", "https://btv.secureswiftcontent.com/han/btv/btv10005/srtoutput/manifest.m3u8", "https://mimipipi22.github.io/logo/nasional/btv.jpg", "BERITA", referer = "https://www.beritasatu.com/btv-live-streaming"),
        ChannelData("BN Channel", "https://flv.intechmedia.net/live/ch112.m3u8", "https://static.wikia.nocookie.net/logopedia/images/5/54/BN_Channel.png", "BERITA"),
    )

    // ==================== ANAK & RELIGI CHANNELS (5) ====================
    private val kidsReligiousChannels = listOf(
        ChannelData("RTV", "https://rtvstream.rtv.co.id:4555/hls/rtv.m3u8", "$iconBase/rtv.png", "ANAK_RELIGI"),
        ChannelData("Rodja TV", "https://rodjatv.com/rodjatv/live.m3u8", "$iconBase/rodjatv.png", "ANAK_RELIGI"),
        ChannelData("DAAI TV", "https://pull.daaiplus.com/live-DAAIPLUS/live-DAAIPLUS_HD.m3u8", "$iconBase/daaitv.png", "ANAK_RELIGI"),
        ChannelData("TV Mu", "https://e.siar.us/live/tvmu.m3u8", "$alkhalifitvBase/tvmu.png", "ANAK_RELIGI"),
        ChannelData("Al Iman TV", "https://tv.aliman.id/aliman/live.m3u8", "https://upload.wikimedia.org/wikipedia/id/2/28/Logo_Al-Iman_TV.png", "ANAK_RELIGI"),
    )

    // ==================== DAERAH / REGIONAL CHANNELS (12) ====================
    private val regionalChannels = listOf(
        ChannelData("JTV", "http://122.248.43.242:1935/JTVSURABAYA/_definst_/myStream/playlist.m3u8", "$iconBase/jtv.png", "DAERAH", isUnstable = true),
        ChannelData("JAKTV", "https://kmklive-lh.akamaihd.net/i/jaktv_live@94476/master.m3u8", "$alkhalifitvBase/jaktv.png", "DAERAH"),
        ChannelData("TVKU", "https://tvku.tv/hlsstream/hls/live.m3u8", genericIptv, "DAERAH"),
        ChannelData("Surabaya TV", "https://e.siar.us/live/surabayatv.m3u8", "https://static.wikia.nocookie.net/logopedia/images/f/fe/Surabaya_TV_2017.png", "DAERAH"),
        ChannelData("Caruban TV", "https://stream.carubantv.id/hls/0/stream.m3u8", genericIptv, "DAERAH", referer = "https://stream.carubantv.id"),
        ChannelData("Dhoho TV", "https://dhohotv.siar.us/dhohotv/live/playlist.m3u8", genericIptv, "DAERAH"),
        ChannelData("Madu TV", "https://re1.siar.us/madutv/hd720/playlist.m3u8", genericIptv, "DAERAH"),
        ChannelData("Jogja TV", "https://stream.jogjatv.co.id/jtvlive/stream/index.m3u8", genericIptv, "DAERAH"),
        ChannelData("Bali TV", "http://210.210.155.69/s/s82/S4/mnf.m3u8", genericIptv, "DAERAH", isUnstable = true),
        ChannelData("TATV", "https://tatv.siar.us/tatv/live.sdp/playlist.m3u8", genericIptv, "DAERAH"),
        ChannelData("Stara TV", "https://stream.staratv.id/hls/0/stream.m3u8", genericIptv, "DAERAH"),
        ChannelData("Jawa Pos TV", "http://122.248.43.242:1935/JAWAPOSTVSBY/_definst_/myStream/playlist.m3u8", genericIptv, "DAERAH", isUnstable = true),
    )

    // ==================== JEPANG FTA (10) ====================
    private val japanBase = "https://akariko.netgenx.site/stream/jp"
    private val myjcomLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo"

    private val japanChannels = listOf(
        ChannelData("NHK G", "$japanBase/nhk_g/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7fe0-011-400x400.png", "JEPANG"),
        ChannelData("NHK E", "$japanBase/nhk_e/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7fe1-021-400x400.png", "JEPANG"),
        ChannelData("NTV", "$japanBase/ntv/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7fe2-041-400x400.png", "JEPANG"),
        ChannelData("TV Asahi", "$japanBase/tv_asahi/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7fe5-051-400x400.png", "JEPANG"),
        ChannelData("TBS", "$japanBase/tbs/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7fe3-061-400x400.png", "JEPANG"),
        ChannelData("TV Tokyo", "$japanBase/tv_tokyo/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7fe6-071-400x400.png", "JEPANG"),
        ChannelData("Fuji TV", "$japanBase/fuji_tv/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7fe4-081-400x400.png", "JEPANG"),
        ChannelData("Tokyo MX1", "$japanBase/tokyo_mx1/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7e87-091-400x400.png", "JEPANG"),
        ChannelData("Tokyo MX2", "$japanBase/tokyo_mx2/stream-output.m3u8?mode=hls", "$myjcomLogo/otd/logo-7e87-093-400x400.png", "JEPANG"),
        ChannelData("NHK World Japan", "https://media-tyo.hls.nhkworld.jp/hls/w/live/master.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUuAlkE08b3RI79ZRo0e4oe0nZm3NxnuYOIw&s", "JEPANG"),
    )

    // ==================== KOREA FTA (3) ====================
    private val koreaChannels = listOf(
        ChannelData("Arirang TV", "https://amdlive-ch01-ctnd-com.akamaized.net/arirang_1ch/smil:arirang_1ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0cqd-JrliSDG0kvFFKk8IDV7UBJDgP9KDjg&s", "KOREA"),
        ChannelData("Arirang TV UN", "https://amdlive-ch02-ctnd-com.akamaized.net/arirang_2ch/smil:arirang_2ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSwzZZcfmWhFjkbw4ljeVBALeIvi4zqZ94_w&s", "KOREA"),
        ChannelData("Arirang Radio", "https://amdlive-ch02-ctnd-com.akamaized.net/arirang_3ch/smil:arirang_3ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyPS2HfHVb4Sr1DIRtyxyvQlkYVTj4ZMG4ow&s", "KOREA"),
    )

    // ==================== THAILAND FTA (16) ====================
    private val thailandChannels = listOf(
        ChannelData("Channel 8", "http://vip.login.in.th:1935/ch8/ch8/playlist.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 1", "https://cdn-live.dltv.ac.th/dltv01.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 2", "https://cdn-live.dltv.ac.th/dltv02.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 3", "https://cdn-live.dltv.ac.th/dltv03.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 4", "https://cdn-live.dltv.ac.th/dltv04.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 5", "https://cdn-live.dltv.ac.th/dltv05.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 6", "https://cdn-live.dltv.ac.th/dltv06.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 7", "https://cdn-live.dltv.ac.th/dltv07.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 8", "https://cdn-live.dltv.ac.th/dltv08.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 9", "https://cdn-live.dltv.ac.th/dltv09.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 10", "https://cdn-live.dltv.ac.th/dltv10.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 11", "https://cdn-live.dltv.ac.th/dltv11.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 12", "https://cdn-live.dltv.ac.th/dltv12.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 13", "https://cdn-live.dltv.ac.th/dltv13.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 14", "https://cdn-live.dltv.ac.th/dltv14.m3u8", genericIptv, "THAILAND"),
        ChannelData("DLTV 15", "https://cdn-live.dltv.ac.th/dltv15.m3u8", genericIptv, "THAILAND"),
    )

    // ==================== MALAYSIA FTA (2) ====================
    private val malaysiaChannels = listOf(
        ChannelData("Astro Awani", "https://d2idp3hzkhjpih.cloudfront.net/out/v1/4b85d9c2bf97413eb0c9fd875599b837/index.m3u8?c", genericIptv, "MALAYSIA"),
        ChannelData("RTM Asean", "https://d25tgymtnqzu8s.cloudfront.net/event/smil:event1/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
    )

    // ==================== BRUNEI FTA (3) ====================
    private val bruneiChannels = listOf(
        ChannelData("RTB Sukmaindera", "https://d1211whpimeups.cloudfront.net/smil:rtb1/chunklist.m3u8", genericIptv, "BRUNEI"),
        ChannelData("RTB Aneka", "https://d1211whpimeups.cloudfront.net/smil:rtb2/chunklist.m3u8", genericIptv, "BRUNEI"),
        ChannelData("RTB Go Live", "https://d1211whpimeups.cloudfront.net/smil:rtbgo/chunklist.m3u8", genericIptv, "BRUNEI"),
    )

    // ==================== SINGAPURA FTA (3) ====================
    private val singaporeChannels = listOf(
        ChannelData("Channel 5", "https://app.viloud.tv/hls/channel/dcbf7a54c89ba12d98cc7c401c37f565.m3u8", genericIptv, "SINGAPURA"),
        ChannelData("Channel 8", "https://app.viloud.tv/hls/channel/57148804a268f59e0c1af0c1b67a2f7e.m3u8", genericIptv, "SINGAPURA"),
        ChannelData("Channel U", "https://app.viloud.tv/hls/channel/aaf404bee904cff424bb5d1f6fdf9333.m3u8", genericIptv, "SINGAPURA"),
    )

    // ==================== FILIPINA FTA (3) ====================
    private val philippinesChannels = listOf(
        ChannelData("GMA 7", "https://catty.wtf/kapuso/stream/index.m3u8", genericIptv, "FILIPINA"),
        ChannelData("Hope Channel PH", "https://jstre.am/live/jsl:7A1swL7Fhlh.m3u8", genericIptv, "FILIPINA"),
        ChannelData("UNTV", "https://cdn.untvweb.com/live-stream/untvweb.m3u8", genericIptv, "FILIPINA"),
    )

    // ==================== HELPER FUNCTIONS ====================
    private fun createHeaders(userAgent: String, referer: String? = null): Map<String, String> {
        val headers = mutableMapOf<String, String>()
        headers["User-Agent"] = userAgent
        if (referer != null) headers["Referer"] = referer
        return headers
    }

    private fun getChannelByName(name: String): ChannelData? {
        return allChannels.find { it.name.equals(name, ignoreCase = true) }
    }

    private fun getChannelsByGroup(group: String): List<ChannelData> {
        return allChannels.filter { it.group == group }
    }

    // ==================== ALL CHANNELS ====================
    private val allChannels = tvriChannels + mncChannels + nationalChannels + newsChannels + kidsReligiousChannels + regionalChannels + japanChannels + koreaChannels + thailandChannels + malaysiaChannels + bruneiChannels + singaporeChannels + philippinesChannels

    override val mainPage = mainPageOf(
        "TVRI" to "Indonesia - TVRI",
        "MNC" to "Indonesia - MNC",
        "NASIONAL" to "Indonesia - Nasional",
        "BERITA" to "Indonesia - Berita",
        "ANAK_RELIGI" to "Indonesia - Anak & Religi",
        "DAERAH" to "Indonesia - Daerah",
        "JEPANG" to "Jepang",
        "KOREA" to "Korea",
        "THAILAND" to "Thailand",
        "MALAYSIA" to "Malaysia",
        "BRUNEI" to "Brunei",
        "SINGAPURA" to "Singapura",
        "FILIPINA" to "Filipina"
    )

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val channels = getChannelsByGroup(request.data)
        val pageChannels = getPageChannels(channels, page)
        val home = pageChannels.mapIndexed { i, channel ->
            val channelNumber = channels.indexOf(channel) + 1
            val unstableTag = if (channel.isUnstable) " [Unstable]" else ""
            newLiveSearchResponse(
                name = "#${channelNumber} ${channel.name}$unstableTag",
                url = channel.streamUrl,
                type = TvType.Live
            ) { this.posterUrl = channel.logoUrl }
        }

        val hasNext = (page * ITEMS_PER_PAGE) < channels.size

        return newHomePageResponse(
            list = HomePageList(name = request.name, list = home, isHorizontalImages = false),
            hasNext = hasNext
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        return allChannels.filter {
            it.name.contains(query, ignoreCase = true) ||
            it.group.contains(query, ignoreCase = true) ||
            it.subCategory?.contains(query, ignoreCase = true) == true
        }.map { channel ->
            val channelNumber = allChannels.indexOf(channel) + 1
            val unstableTag = if (channel.isUnstable) " [Unstable]" else ""
            newLiveSearchResponse(
                name = "#${channelNumber} ${channel.name}$unstableTag",
                url = channel.streamUrl,
                type = TvType.Live
            ) { this.posterUrl = channel.logoUrl }
        }
    }

    override suspend fun load(url: String): LoadResponse {
        val channel = allChannels.find { it.streamUrl == url } ?: allChannels.first()
        val sameGroupChannels = allChannels.filter { it.group == channel.group }
        val orderedChannels = listOf(channel) + sameGroupChannels.filter { it.streamUrl != url }
        val episodes = orderedChannels.mapIndexed { i, ch ->
            newEpisode(ch.streamUrl) {
                name = ch.name
                episode = i
                posterUrl = ch.logoUrl
                description = ch.subCategory ?: ch.group
            }
        }

        val channelNumber = allChannels.indexOf(channel) + 1

        return newTvSeriesLoadResponse(
            name = "#${channelNumber} ${channel.name}",
            url = url,
            type = TvType.TvSeries,
            episodes = episodes
        ) {
            this.posterUrl = channel.logoUrl
            this.plot = "Channel: ${channel.name} (#${channelNumber})\nGroup: ${channel.group}"
            this.uniqueUrl = url
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        if (data.isEmpty()) return true

        val channel = allChannels.find { it.streamUrl == data }
        val finalHeaders = buildMap {
            putAll(channel?.headers ?: emptyMap())
            channel?.referer?.let { put("Referer", it) }
        }

        callback.invoke(
            newExtractorLink(
                source = this.name,
                name = channel?.name ?: this.name,
                url = data,
            ) {
                this.quality = Qualities.P1080.value
                this.headers = finalHeaders
            }
        )
        return true
    }
}
