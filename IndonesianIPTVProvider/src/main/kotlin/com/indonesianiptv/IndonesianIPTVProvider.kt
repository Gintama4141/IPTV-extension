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
        private const val ITEMS_PER_PAGE = 20
    }

    private fun getPageChannels(channels: List<ChannelData>, page: Int): List<ChannelData> {
        val startIndex = (page - 1) * ITEMS_PER_PAGE
        if (startIndex >= channels.size) return emptyList()
        val endIndex = minOf(startIndex + ITEMS_PER_PAGE, channels.size)
        return channels.subList(startIndex, endIndex)
    }

    // Logo bases
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

    // MNC Group logo bases
    private val mimipipiLogo = "https://mimipipi22.github.io/logo/nasional"

    data class ChannelData(
        val name: String,
        val streamUrl: String,
        val logoUrl: String,
        val category: String,
        val headers: Map<String, String> = emptyMap(),
        val referer: String? = null,
        val isUnstable: Boolean = false
    )

    // ==================== TVRI CHANNELS (35) ====================
    private val tvriChannels = listOf(
        ChannelData("TVRI Nasional", "$tvriBaseUrl/Nasional/hls/Nasional.m3u8", tvriIcon, "Nasional", tvriHeaders),
        ChannelData("TVRI World", "$tvriBaseUrl/TVRIWorld/hls/TVRIWorld.m3u8", tvriWorldIcon, "Nasional", tvriHeaders),
        ChannelData("TVRI Sport", "$tvriBaseUrl/SportHD/hls/SportHD.m3u8", tvriSportIcon, "Olahraga", tvriHeaders),
        ChannelData("TVRI Aceh", "$tvriBaseUrl/Aceh/hls/Aceh.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Bali", "$tvriBaseUrl/Bali/hls/Bali.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Bangka Belitung", "$tvriBaseUrl/Babel/hls/Babel.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Bengkulu", "$tvriBaseUrl/Bengkulu/hls/Bengkulu.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI DIY", "$tvriBaseUrl/DIY/hls/DIY.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Gorontalo", "$tvriBaseUrl/Gorontalo/hls/Gorontalo.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Jakarta", "$tvriBaseUrl/DKI/hls/DKI.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Jambi", "$tvriBaseUrl/Jambi/hls/Jambi.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Jawa Barat", "$tvriBaseUrl/Jabar/hls/Jabar.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Jawa Tengah", "$tvriBaseUrl/Jateng/hls/Jateng.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Jawa Timur", "$tvriBaseUrl/Jatim/hls/Jatim.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Kalimantan Barat", "$tvriBaseUrl/Kalbar/hls/Kalbar.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Kalimantan Selatan", "$tvriBaseUrl/Kalsel/hls/Kalsel.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Kalimantan Tengah", "$tvriBaseUrl/Kalteng/hls/Kalteng.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Kalimantan Timur", "$tvriBaseUrl/Kaltim/hls/Kaltim.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Lampung", "$tvriBaseUrl/Lampung/hls/Lampung.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Maluku", "$tvriBaseUrl/Maluku/hls/Maluku.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Maluku Utara", "$tvriBaseUrl/Malut/hls/Malut.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI NTT", "$tvriBaseUrl/NTT/hls/NTT.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI NTB", "$tvriBaseUrl/NTB/hls/NTB.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Papua", "$tvriBaseUrl/Papua/hls/Papua.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Papua Barat", "$tvriBaseUrl/PapuaBarat/hls/PapuaBarat.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Riau", "$tvriBaseUrl/Riau/hls/Riau.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Barat", "$tvriBaseUrl/Sulbar/hls/Sulbar.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Selatan", "$tvriBaseUrl/Sulsel/hls/Sulsel.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Tengah", "$tvriBaseUrl/Sulteng/hls/Sulteng.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Tenggara", "$tvriBaseUrl/Sultra/hls/Sultra.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Sulawesi Utara", "$tvriBaseUrl/Sulut/hls/Sulut.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Sumatera Barat", "$tvriBaseUrl/Sumbar/hls/Sumbar.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Sumatera Selatan", "$tvriBaseUrl/Sumsel/hls/Sumsel.m3u8", tvriIcon, "Daerah", tvriHeaders),
        ChannelData("TVRI Sumatera Utara", "$tvriBaseUrl/Sumut/hls/Sumut.m3u8", tvriIcon, "Daerah", tvriHeaders),
    )

    // ==================== MNC GROUP - RCTI+ FTA (4) ====================
    private val mncHeaders = mapOf(
        "User-Agent" to "MNCNow/6.33.3 (Linux;Android 15.0.0;)ExoPlayerLib/2.19.1"
    )

    private val mncChannels = listOf(
        ChannelData(
            "RCTI",
            "https://d35d0ifx19oopq.cloudfront.net/live/eds/rcti_fta/live_fta/rcti_fta.m3u8",
            "$mimipipiLogo/rcti.jpg",
            "Nasional",
            headers = mncHeaders,
            referer = "https://www.rctiplus.com/tv/rcti"
        ),
        ChannelData(
            "MNCTV",
            "https://d33j155pv2xyba.cloudfront.net/live/eds/mnctv_fta/live_fta/mnctv_fta.m3u8",
            "$mimipipiLogo/mnctv.jpg",
            "Nasional",
            headers = mncHeaders,
            referer = "https://www.rctiplus.com/tv/mnctv"
        ),
        ChannelData(
            "GTV",
            "https://d322b885qvsbxg.cloudfront.net/live/eds/gtv_fta/live_fta/gtv_fta.m3u8",
            "$mimipipiLogo/gtv.jpg",
            "Nasional",
            headers = mncHeaders,
            referer = "https://www.rctiplus.com/tv/gtv"
        ),
        ChannelData(
            "iNews",
            "https://d2hfpzcndkyscp.cloudfront.net/live/eds/INEWS_2021/live_fta/INEWS_2021.m3u8",
            "$mimipipiLogo/inews.jpg",
            "Berita",
            headers = mncHeaders,
            referer = "https://www.rctiplus.com/tv/inews"
        ),
    )

    // ==================== OTHER NATIONAL CHANNELS (12) ====================
    private val nationalChannels = listOf(
        ChannelData("Trans TV", "https://livestream.transtv.co.id/stream/live/ttv.m3u8", "$iconBase/transtv.png", "Nasional", referer = "https://www.detik.com/"),
        ChannelData("Trans7", "https://video.detik.com/trans7/smil:trans7.smil/index.m3u8", "$iconBase/trans7.png", "Nasional", referer = "https://www.detik.com/"),
        ChannelData("SCTV", "http://op-group1-swiftservehd-1.dens.tv/h/h217/02.m3u8", "https://images.useetv.com/logo_sctv_big1.png", "Nasional", headers = mapOf("User-Agent" to "DENSGO/3.00.00 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"), referer = "http://dens.tv"),
        ChannelData("Indosiar", "http://op-group1-swiftservehd-1.dens.tv/h/h207/02.m3u8", "https://images.useetv.com/logo_indosiar_big1.png", "Nasional", headers = mapOf("User-Agent" to "DENSGO/3.00.00 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"), referer = "http://dens.tv"),
        ChannelData("NET TV", "https://cdn-accedo-01.akamaized.net/Content/HLS/Live/channel(404d689d-691f-4035-9801-ae8bfd8712e9)/index.m3u8", "https://mimipipi22.github.io/logo/nasional/nettv.jpg", "Nasional"),
        ChannelData("O Channel (Moji)", "https://kmklive-lh.akamaihd.net/i/ochannel_live@577566/master.m3u8", "$iconBase/moji.png", "Nasional"),
        ChannelData("tvOne", "https://yt.urfan.web.id/stream/yNKvkPJl-tg/master.m3u8", "$iconBase/tvone.png", "Nasional", headers = mapOf("User-Agent" to "ExoPlayer/2.19.1 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1")),
        ChannelData("ANTV", "http://210.210.155.35/qwr9ew/s/s07/index1.m3u8", "$iconBase/antv.png", "Nasional", headers = mapOf("User-Agent" to "ExoPlayer/2.19.1 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"), isUnstable = true),
        ChannelData("Mentari TV", "https://app-etslive-2.vidio.com/live/8237/master.m3u8", "$iconBase/mentaritv.png", "Nasional"),
        ChannelData("Magna Channel", "https://edge.medcom.id/live-edge/smil:magna.smil/playlist.m3u8", "$iconBase/magna.png", "Nasional"),
        ChannelData("Nusantara TV", "https://nusantaratv.siar.us/nusantaratv/live/playlist.m3u8", "$iconBase/nusantaratv.png", "Nasional"),
        ChannelData("Indonesiana TV", "https://tvstreamcast.com/indonesiana.m3u8", "$iconBase/indonesiana.png", "Nasional", referer = "https://indonesiana.tv/"),
        ChannelData("Garuda TV", "https://hgmtv.com:19360/garudatvlivestreaming/garudatvlivestreaming.m3u8", "$alkhalifitvBase/garudatv.png", "Nasional"),
    )

    // ==================== NEWS CHANNELS (6) ====================
    private val newsChannels = listOf(
        ChannelData("Metro TV", "https://yt.urfan.web.id/stream/XKueVSGTk2o/master.m3u8", "$iconBase/metrotv.png", "Berita"),
        ChannelData("Kompas TV", "https://live-kg.jixie.media/live/kompastv.m3u8", "$iconBase/kompastv.png", "Berita"),
        ChannelData("CNN Indonesia", "https://live.cnnindonesia.com/livecnn/smil:cnntv.smil/playlist.m3u8", "$iconBase/cnnindonesia.png", "Berita", referer = "https://www.cnnindonesia.com/"),
        ChannelData("CNBC Indonesia", "https://live.cnbcindonesia.com/livecnbc/smil:cnbctv.smil/master.m3u8", "$iconBase/cnbcindonesia.png", "Berita", referer = "https://www.cnbcindonesia.com/"),
        ChannelData("BTV", "https://btv.secureswiftcontent.com/han/btv/btv10005/srtoutput/manifest.m3u8", "https://mimipipi22.github.io/logo/nasional/btv.jpg", "Berita", referer = "https://www.beritasatu.com/btv-live-streaming"),
        ChannelData("BN Channel", "https://flv.intechmedia.net/live/ch112.m3u8", "https://static.wikia.nocookie.net/logopedia/images/5/54/BN_Channel.png", "Berita"),
    )

    // ==================== KIDS CHANNELS (1) ====================
    private val kidsChannels = listOf(
        ChannelData("RTV", "https://rtvstream.rtv.co.id:4555/hls/rtv.m3u8", "$iconBase/rtv.png", "Anak"),
    )

    // ==================== RELIGIOUS CHANNELS (4) ====================
    private val religiousChannels = listOf(
        ChannelData("Rodja TV", "https://rodjatv.com/rodjatv/live.m3u8", "$iconBase/rodjatv.png", "Religi"),
        ChannelData("DAAI TV", "https://pull.daaiplus.com/live-DAAIPLUS/live-DAAIPLUS_HD.m3u8", "$iconBase/daaitv.png", "Religi"),
        ChannelData("TV Mu", "https://e.siar.us/live/tvmu.m3u8", "$alkhalifitvBase/tvmu.png", "Religi"),
        ChannelData("Al Iman TV", "https://tv.aliman.id/aliman/live.m3u8", "https://upload.wikimedia.org/wikipedia/id/2/28/Logo_Al-Iman_TV.png", "Religi"),
    )

    // ==================== REGIONAL CHANNELS (12) ====================
    private val regionalChannels = listOf(
        ChannelData("JTV", "http://122.248.43.242:1935/JTVSURABAYA/_definst_/myStream/playlist.m3u8", "$iconBase/jtv.png", "Daerah", isUnstable = true),
        ChannelData("JAKTV", "https://kmklive-lh.akamaihd.net/i/jaktv_live@94476/master.m3u8", "$alkhalifitvBase/jaktv.png", "Daerah"),
        ChannelData("TVKU", "https://tvku.tv/hlsstream/hls/live.m3u8", genericIptv, "Daerah"),
        ChannelData("Surabaya TV", "https://e.siar.us/live/surabayatv.m3u8", "https://static.wikia.nocookie.net/logopedia/images/f/fe/Surabaya_TV_2017.png", "Daerah"),
        ChannelData("Caruban TV", "https://stream.carubantv.id/hls/0/stream.m3u8", genericIptv, "Daerah", referer = "https://stream.carubantv.id"),
        ChannelData("Dhoho TV", "https://dhohotv.siar.us/dhohotv/live/playlist.m3u8", genericIptv, "Daerah"),
        ChannelData("Madu TV", "https://re1.siar.us/madutv/hd720/playlist.m3u8", genericIptv, "Daerah"),
        ChannelData("Jogja TV", "https://stream.jogjatv.co.id/jtvlive/stream/index.m3u8", genericIptv, "Daerah"),
        ChannelData("Bali TV", "http://210.210.155.69/s/s82/S4/mnf.m3u8", genericIptv, "Daerah", isUnstable = true),
        ChannelData("TATV", "https://tatv.siar.us/tatv/live.sdp/playlist.m3u8", genericIptv, "Daerah"),
        ChannelData("Stara TV", "https://stream.staratv.id/hls/0/stream.m3u8", genericIptv, "Daerah"),
        ChannelData("Jawa Pos TV", "http://122.248.43.242:1935/JAWAPOSTVSBY/_definst_/myStream/playlist.m3u8", genericIptv, "Daerah", isUnstable = true),
    )

    // ==================== JAPAN CHANNELS (keep existing) ====================
    private val japanBase = "https://akariko.netgenx.site/stream/jp"
    private val skyLogo = "https://www.skyperfectv.co.jp/library/common/img/channel/icon/basic"
    private val skyLogoPremium = "https://www.skyperfectv.co.jp/library/common/img/channel/icon/premium"
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
        ChannelData("NHK BS", "$japanBase/nhk_bs/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-101-400x400.png", "JEPANG"),
        ChannelData("BS NTV", "$japanBase/bs_ntv/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-141-400x400.png", "JEPANG"),
        ChannelData("BS Asahi", "$japanBase/bs_asahi/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-151-400x400.png", "JEPANG"),
        ChannelData("BS TBS", "$japanBase/bs_tbs/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-161-400x400.png", "JEPANG"),
        ChannelData("BS TV Tokyo", "$japanBase/bs_tv_tokyo/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-171-400x400.png", "JEPANG"),
        ChannelData("BS Fuji", "$japanBase/bs_fuji/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-181-400x400.png", "JEPANG"),
        ChannelData("BS 10", "$japanBase/bs_10/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-200-400x400.png", "JEPANG"),
        ChannelData("BS 11", "$japanBase/bs11/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-211-400x400.png", "JEPANG"),
        ChannelData("BS 12", "$japanBase/bs_12/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-0004-222-400x400.png", "JEPANG"),
        ChannelData("NHK BS4K", "$japanBase/nhk_bs4k/stream-output.m3u8?mode=hls", "$myjcomLogo/bsd/logo-000b-101-400x400.png", "JEPANG"),
        ChannelData("WOWOW Prime", "$japanBase/wowow_prime/stream-output.m3u8?mode=hls", "$skyLogo/bs191.gif", "JEPANG"),
        ChannelData("WOWOW Cinema", "$japanBase/wowow_cinema/stream-output.m3u8?mode=hls", "$skyLogo/bs193.gif", "JEPANG"),
        ChannelData("WOWOW Live", "$japanBase/wowow_live/stream-output.m3u8?mode=hls", "$skyLogo/bs192.gif", "JEPANG"),
        ChannelData("WOWOW Plus", "$japanBase/wowow_plus/stream-output.m3u8?mode=hls", "$skyLogo/bs252.gif", "JEPANG"),
        ChannelData("BS 10 Premium", "$japanBase/bs_10_premium/stream-output.m3u8?mode=hls", "$skyLogo/bs201.gif", "JEPANG"),
        ChannelData("JSport 1", "$japanBase/jsport_1/stream-output.m3u8?mode=hls", "$skyLogo/bs242.gif", "JEPANG"),
        ChannelData("JSport 2", "$japanBase/jsport_2/stream-output.m3u8?mode=hls", "$skyLogo/bs243.gif", "JEPANG"),
        ChannelData("JSport 3", "$japanBase/jsport_3/stream-output.m3u8?mode=hls", "$skyLogo/bs244.gif", "JEPANG"),
        ChannelData("JSport 4", "$japanBase/jsport_4/stream-output.m3u8?mode=hls", "$skyLogo/bs245.gif", "JEPANG"),
        ChannelData("Green Channel", "$japanBase/green_channel/stream-output.m3u8?mode=hls", "$skyLogo/bs234.gif", "JEPANG"),
        ChannelData("Nihon Eiga Senmon", "$japanBase/nihon_eiga_senmon/stream-output.m3u8?mode=hls", "$skyLogo/bs255.gif", "JEPANG"),
        ChannelData("Fishing Vision", "$japanBase/fishing_vision/stream-output.m3u8?mode=hls", "$skyLogo/bs251.gif", "JEPANG"),
        ChannelData("Disney Channel", "$japanBase/disney_channel/stream-output.m3u8?mode=hls", "$skyLogo/bs256.gif", "JEPANG"),
        ChannelData("GAORA", "$japanBase/gaora_sports/stream-output.m3u8?mode=hls", "$skyLogo/cs254.gif", "JEPANG"),
        ChannelData("AT-X", "$japanBase/at-x/stream-output.m3u8?mode=hls", "$skyLogo/cs333.gif", "JEPANG"),
        ChannelData("Space Shower TV", "$japanBase/space_shower_tv/stream-output.m3u8?mode=hls", "$skyLogo/cs322.gif", "JEPANG"),
        ChannelData("MTV", "$japanBase/mtv/stream-output.m3u8?mode=hls", "$skyLogo/cs323.gif", "JEPANG"),
        ChannelData("Mnet", "$japanBase/mnet/stream-output.m3u8?mode=hls", "$skyLogo/cs318.gif", "JEPANG"),
        ChannelData("Super Drama TV", "$japanBase/super_drama_tv/stream-output.m3u8?mode=hls", "$skyLogoPremium/647.gif", "JEPANG"),
        ChannelData("NTV G+", "$japanBase/nittele_g+/stream-output.m3u8?mode=hls", "$skyLogo/cs257.gif", "JEPANG"),
        ChannelData("NTV Plus", "$japanBase/nittele_plus/stream-output.m3u8?mode=hls", "$skyLogo/cs300.gif", "JEPANG"),
        ChannelData("Family Gekijo", "$japanBase/family_gekijyo/stream-output.m3u8?mode=hls", "$skyLogo/cs293.gif", "JEPANG"),
        ChannelData("TBS Channel 1", "$japanBase/tbs_channel_1/stream-output.m3u8?mode=hls", "$skyLogo/cs296.gif", "JEPANG"),
        ChannelData("TBS Channel 2", "$japanBase/tbs_channel_2/stream-output.m3u8?mode=hls", "$skyLogo/cs297.gif", "JEPANG"),
        ChannelData("TV Asahi Ch 1", "$japanBase/tv_asahi_channel_1/stream-output.m3u8?mode=hls", "$skyLogo/cs298.gif", "JEPANG"),
        ChannelData("TV Asahi Ch 2", "$japanBase/tv_asahi_channel_2/stream-output.m3u8?mode=hls", "$skyLogo/cs299.gif", "JEPANG"),
        ChannelData("Fuji TV One", "$japanBase/fuji_tv_one/stream-output.m3u8?mode=hls", "$skyLogo/cs307.gif", "JEPANG"),
        ChannelData("Fuji TV Two", "$japanBase/fuji_tv_two/stream-output.m3u8?mode=hls", "$skyLogo/cs308.gif", "JEPANG"),
        ChannelData("Fuji TV Next", "$japanBase/fuji_tv_next/stream-output.m3u8?mode=hls", "$skyLogo/cs309.gif", "JEPANG"),
        ChannelData("NTV News24", "$japanBase/ntv_news24/stream-output.m3u8?mode=hls", "$skyLogo/cs349.gif", "JEPANG"),
        ChannelData("National Geographic", "$japanBase/national_geographic_japan/stream-output.m3u8?mode=hls", "$skyLogo/cs343.gif", "JEPANG"),
        ChannelData("Discovery", "$japanBase/discovery_channel/stream-output.m3u8?mode=hls", "$skyLogo/cs340.gif", "JEPANG"),
        ChannelData("Animal Planet", "$japanBase/animal_planet/stream-output.m3u8?mode=hls", "$skyLogo/cs341.gif", "JEPANG"),
        ChannelData("History", "$japanBase/history/stream-output.m3u8?mode=hls", "$skyLogo/cs342.gif", "JEPANG"),
        ChannelData("BBC News", "$japanBase/bbc_news/stream-output.m3u8?mode=hls", "$skyLogo/cs353.gif", "JEPANG"),
        ChannelData("TBS News", "$japanBase/tbs_news/stream-output.m3u8?mode=hls", "$skyLogo/cs351.gif", "JEPANG"),
        ChannelData("NHK World Japan", "https://media-tyo.hls.nhkworld.jp/hls/w/live/master.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUuAlkE08b3RI79ZRo0e4oe0nZm3NxnuYOIw&s", "JEPANG"),
    )

    // ==================== KOREA CHANNELS ====================
    private val koreaChannels = listOf(
        ChannelData("Arirang TV", "https://amdlive-ch01-ctnd-com.akamaized.net/arirang_1ch/smil:arirang_1ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0cqd-JrliSDG0kvFFKk8IDV7UBJDgP9KDjg&s", "KOREA"),
        ChannelData("Arirang TV UN", "https://amdlive-ch02-ctnd-com.akamaized.net/arirang_2ch/smil:arirang_2ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSwzZZcfmWhFjkbw4ljeVBALeIvi4zqZ94_w&s", "KOREA"),
        ChannelData("Arirang Radio", "https://amdlive-ch02-ctnd-com.akamaized.net/arirang_3ch/smil:arirang_3ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyPS2HfHVb4Sr1DIRtyxyvQlkYVTj4ZMG4ow&s", "KOREA"),
        ChannelData("ABN TV", "https://vod2.abn.co.kr/IPHONE/abn.m3u8", genericIptv, "KOREA"),
        ChannelData("BTN", "https://btn.nowcdn.co.kr/btn/btnlive2m/playlist.m3u8", genericIptv, "KOREA"),
        ChannelData("CJ OnStyle", "https://live-ch1.cjonstyle.net/cjmalllive/stream2/playlist.m3u8", genericIptv, "KOREA"),
        ChannelData("TVN", "https://op-group1-swiftservehd-1.dens.tv/h/h20/01.m3u8", genericIptv, "KOREA"),
        ChannelData("SBS", "http://1.222.207.80:1935/live/cjbtv/playlist.m3u8", genericIptv, "KOREA"),
    )

    // ==================== THAILAND CHANNELS ====================
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

    // ==================== MALAYSIA CHANNELS ====================
    private val malaysiaChannels = listOf(
        ChannelData("Astro Awani", "https://d2idp3hzkhjpih.cloudfront.net/out/v1/4b85d9c2bf97413eb0c9fd875599b837/index.m3u8?c", genericIptv, "MALAYSIA"),
        ChannelData("RTM Asean", "https://d25tgymtnqzu8s.cloudfront.net/event/smil:event1/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
        ChannelData("APETITO", "https://d1sq2slp9afh7o.cloudfront.net/smil:apetito/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
        ChannelData("AURA", "https://d1sq2slp9afh7o.cloudfront.net/smil:aura/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
        ChannelData("FITRAH", "https://d1sq2slp9afh7o.cloudfront.net/smil:fitrah/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
        ChannelData("JR.", "https://d1sq2slp9afh7o.cloudfront.net/smil:jr/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
        ChannelData("LEAD", "https://d1sq2slp9afh7o.cloudfront.net/smil:lead/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
        ChannelData("ROLL", "https://d1sq2slp9afh7o.cloudfront.net/smil:roll/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
        ChannelData("SNAP", "https://d1sq2slp9afh7o.cloudfront.net/smil:snap/chunklist_b2596000_slENG.m3u8", genericIptv, "MALAYSIA"),
    )

    // ==================== BRUNEI CHANNELS ====================
    private val bruneiChannels = listOf(
        ChannelData("RTB Sukmaindera", "https://d1211whpimeups.cloudfront.net/smil:rtb1/chunklist.m3u8", genericIptv, "BRUNEI"),
        ChannelData("RTB Aneka", "https://d1211whpimeups.cloudfront.net/smil:rtb2/chunklist.m3u8", genericIptv, "BRUNEI"),
        ChannelData("RTB Go Live", "https://d1211whpimeups.cloudfront.net/smil:rtbgo/chunklist.m3u8", genericIptv, "BRUNEI"),
    )

    // ==================== SINGAPORE CHANNELS ====================
    private val singaporeChannels = listOf(
        ChannelData("Channel 5", "https://app.viloud.tv/hls/channel/dcbf7a54c89ba12d98cc7c401c37f565.m3u8", genericIptv, "SINGAPORE"),
        ChannelData("Channel 8", "https://app.viloud.tv/hls/channel/57148804a268f59e0c1af0c1b67a2f7e.m3u8", genericIptv, "SINGAPORE"),
        ChannelData("Channel U", "https://app.viloud.tv/hls/channel/aaf404bee904cff424bb5d1f6fdf9333.m3u8", genericIptv, "SINGAPORE"),
    )

    // ==================== PHILIPPINES CHANNELS ====================
    private val philippinesChannels = listOf(
        ChannelData("GMA 7", "https://catty.wtf/kapuso/stream/index.m3u8", genericIptv, "FILIPINA"),
        ChannelData("Hope Channel PH", "https://jstre.am/live/jsl:7A1swL7Fhlh.m3u8", genericIptv, "FILIPINA"),
        ChannelData("UNTV", "https://cdn.untvweb.com/live-stream/untvweb.m3u8", genericIptv, "FILIPINA"),
    )

    // ==================== HELPER FUNCTIONS ====================
    private fun createHeaders(userAgent: String, referer: String? = null): Map<String, String> {
        val headers = mutableMapOf<String, String>()
        headers["User-Agent"] = userAgent
        if (referer != null) {
            headers["Referer"] = referer
        }
        return headers
    }

    private fun getChannelByName(name: String): ChannelData? {
        return allChannels.find { it.name.equals(name, ignoreCase = true) }
    }

    private fun getChannelsByCategory(category: String): List<ChannelData> {
        return if (category == "Semua") allChannels
        else allChannels.filter { it.category.equals(category, ignoreCase = true) }
    }

    // ==================== ALL CHANNELS ====================
    private val allChannels = tvriChannels + mncChannels + nationalChannels + newsChannels + kidsChannels + religiousChannels + regionalChannels + japanChannels + koreaChannels + thailandChannels + malaysiaChannels + bruneiChannels + singaporeChannels + philippinesChannels

    override val mainPage = mainPageOf(
        "Semua" to "Semua Channel",
        "Nasional" to "TV Nasional",
        "Berita" to "TV Berita",
        "Olahraga" to "TV Olahraga",
        "Anak" to "TV Anak",
        "Religi" to "TV Religi",
        "Daerah" to "TV Daerah",
        "JEPANG" to "TV Jepang",
        "KOREA" to "TV Korea",
        "THAILAND" to "TV Thailand",
        "MALAYSIA" to "TV Malaysia",
        "BRUNEI" to "TV Brunei",
        "SINGAPORE" to "TV Singapura",
        "FILIPINA" to "TV Filipina"
    )

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val filteredChannels = when (request.data) {
            "Semua" -> allChannels
            else -> allChannels.filter { it.category == request.data }
        }

        val pageChannels = getPageChannels(filteredChannels, page)
        val globalIndex = if (request.data == "Semua") {
            allChannels.indexOf(pageChannels.firstOrNull() ?: return newHomePageResponse(listOf(), false)) + 1
        } else 0

        val home = pageChannels.mapIndexed { i, channel ->
            val channelNumber = if (request.data == "Semua") globalIndex + i
            else filteredChannels.indexOf(channel) + 1
            val unstableTag = if (channel.isUnstable) " [Unstable]" else ""
            newLiveSearchResponse(
                name = "#${channelNumber} ${channel.name}$unstableTag",
                url = channel.streamUrl,
                type = TvType.Live
            ) {
                this.posterUrl = channel.logoUrl
            }
        }

        val hasNext = (page * ITEMS_PER_PAGE) < filteredChannels.size

        return newHomePageResponse(
            list = HomePageList(
                name = request.name,
                list = home,
                isHorizontalImages = false
            ),
            hasNext = hasNext
        )
    }

    override suspend fun search(query: String): List<SearchResponse> {
        return allChannels.filter {
            it.name.contains(query, ignoreCase = true) ||
            it.category.contains(query, ignoreCase = true)
        }.map { channel ->
            val channelNumber = allChannels.indexOf(channel) + 1
            val unstableTag = if (channel.isUnstable) " [Unstable]" else ""
            newLiveSearchResponse(
                name = "#${channelNumber} ${channel.name}$unstableTag",
                url = channel.streamUrl,
                type = TvType.Live
            ) {
                this.posterUrl = channel.logoUrl
            }
        }
    }

    override suspend fun load(url: String): LoadResponse {
        val channel = allChannels.find { it.streamUrl == url } ?: allChannels.first()
        val channelNumber = allChannels.indexOf(channel) + 1
        val orderedChannels = listOf(channel) + allChannels.filter { it.streamUrl != url }
        val episodes = orderedChannels.mapIndexed { i, ch ->
            newEpisode(ch.streamUrl) {
                name = ch.name
                episode = i
                posterUrl = ch.logoUrl
                description = ch.category
            }
        }

        return newTvSeriesLoadResponse(
            name = "#${channelNumber} ${channel.name}",
            url = url,
            type = TvType.TvSeries,
            episodes = episodes
        ) {
            this.posterUrl = channel.logoUrl
            this.plot = "Channel: ${channel.name} (#${channelNumber})\nCategory: ${channel.category}"
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
                headers = finalHeaders
            ) {
                this.quality = Qualities.P1080.value
            }
        )
        return true
    }
}
