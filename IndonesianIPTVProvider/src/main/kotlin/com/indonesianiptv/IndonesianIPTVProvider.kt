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

    private val iconBase = "https://raw.githubusercontent.com/riotryulianto/iptv-playlists/main/icons"
    private val alkhalifitvBase = "https://raw.githubusercontent.com/alkhalifitv/TV/master/big"

    private val indonesianChannels = listOf(
        ChannelData("TVRI Nasional", "https://ott-balancer.tvri.go.id/live/eds/Nasional/hls/Nasional.m3u8", "$iconBase/tvri.png", "Nasional"),
        ChannelData("TVRI World", "https://ott-balancer.tvri.go.id/live/eds/TVRIWorld/hls/TVRIWorld.m3u8", "$iconBase/tvriworld.png", "Nasional"),
        ChannelData("SCTV", "https://op-group1-swiftservehd-1.dens.tv/h/h217/index.m3u8", "$iconBase/sctv.png", "Nasional"),
        ChannelData("Indosiar", "https://op-group1-swiftservehd-1.dens.tv/h/h235/index.m3u8", "$iconBase/indosiar.png", "Nasional"),
        ChannelData("ANTV", "http://103.58.160.157:8278/720-ANTV/playlist.m3u8", "$iconBase/antv.png", "Nasional"),
        ChannelData("Trans TV", "https://video.detik.com/transtv/smil:transtv.smil/index.m3u8", "$iconBase/transtv.png", "Nasional"),
        ChannelData("Trans7", "https://video.detik.com/trans7/smil:trans7.smil/index.m3u8", "$iconBase/trans7.png", "Nasional"),
        ChannelData("Metro TV", "https://edge.medcom.id/live-edge/smil:metro.smil/playlist.m3u8", "$iconBase/metrotv.png", "Nasional"),
        ChannelData("tvOne", "https://op-group1-swiftservehd-1.dens.tv/h/h40/01.m3u8", "$iconBase/tvone.png", "Nasional"),
        ChannelData("MDTV", "https://wahyu1ptv.pages.dev/MDTV-HD.m3u8", "$alkhalifitvBase/mdtv.png", "Nasional"),
        ChannelData("MOJI", "http://op-group1-swiftservehd-1.dens.tv/h/h207/02.m3u8", "$iconBase/moji.png", "Nasional"),
        ChannelData("Magna Channel", "https://edge.medcom.id/live-edge/smil:magna.smil/playlist.m3u8", "$iconBase/magna.png", "Nasional"),
        ChannelData("Nusantara TV", "https://nusantaratv.siar.us/nusantaratv/live/playlist.m3u8", "$iconBase/nusantaratv.png", "Nasional"),
        ChannelData("Garuda TV", "https://hgmtv.com:19360/garudatvlivestreaming/garudatvlivestreaming.m3u8", "$alkhalifitvBase/garudatv.png", "Nasional"),

        ChannelData("Kompas TV", "https://op-group1-swiftservehd-1.dens.tv/h/h234/index.m3u8", "$iconBase/kompastv.png", "Berita"),
        ChannelData("CNN Indonesia", "https://live.cnnindonesia.com/livecnn/smil:cnntv.smil/playlist.m3u8", "$iconBase/cnnindonesia.png", "Berita"),
        ChannelData("CNBC Indonesia", "https://live.cnbcindonesia.com/livecnbc/smil:cnbctv.smil/master.m3u8", "$iconBase/cnbcindonesia.png", "Berita"),


        ChannelData("Metro Globe Network", "https://edge.medcom.id/live-edge/smil:mgnch.smil/playlist.m3u8", "$iconBase/mgn.png", "Berita"),


        ChannelData("BN Channel", "http://op-group1-swiftservehd-1.dens.tv/h/h39/01.m3u8", "https://static.wikia.nocookie.net/logopedia/images/5/54/BN_Channel.png", "Berita"),
        ChannelData("TVRI Sport", "https://ott-balancer.tvri.go.id/live/eds/SportHD/hls/SportHD.m3u8", "$iconBase/tvrisport.png", "Olahraga"),
        ChannelData("SPOTV", "http://primestreams.tv:826/live/mookie22/49aV7nBsK4/119515.m3u8", "$alkhalifitvBase/spotv.png", "Olahraga"),
        ChannelData("SPOTV2", "http://primestreams.tv:826/live/mookie22/49aV7nBsK4/119516.m3u8", "$alkhalifitvBase/spotv2.png", "Olahraga"),
        ChannelData("Motorvision TV", "http://op-group1-swiftservehd-1.dens.tv/h/h09/01.m3u8", "$alkhalifitvBase/motorvision.png", "Olahraga"),
        ChannelData("RTV", "https://rtvstream.rtv.co.id:4555/hls/rtv.m3u8", "$iconBase/rtv.png", "Anak"),
        ChannelData("Biznet Kids", "http://livestream.biznetvideo.net/biznet_kids/smil:kids.smil/index.m3u8", "$alkhalifitvBase/kidstv.png", "Anak"),

        ChannelData("Animax", "https://akariko.netgenx.site/stream/jp/animax/stream-output.m3u8?mode=hls", "$alkhalifitvBase/animax.png", "Anak"),
        ChannelData("Rodja TV", "https://rodjatv.com/rodjatv/live.m3u8", "$iconBase/rodjatv.png", "Religi"),
        ChannelData("DAAI TV", "https://pull.daaiplus.com/live-DAAIPLUS/live-DAAIPLUS_HD.m3u8", "$iconBase/daaitv.png", "Religi"),
        ChannelData("RRI Net", "https://private-streaming.rri.go.id/memfs/6f77c7b5-feb2-4935-9f89-e7e9fca0a54a_output_0.m3u8", "$iconBase/rrinet.png", "Religi"),
        ChannelData("TV Mu", "https://e.siar.us/live/tvmu.m3u8", "$alkhalifitvBase/tvmu.png", "Religi"),

        ChannelData("Al Iman TV", "https://tv.aliman.id/aliman/live.m3u8", "https://upload.wikimedia.org/wikipedia/id/2/28/Logo_Al-Iman_TV.png", "Religi"),
        ChannelData("Salam TV", "https://salamtv.siar.us/live/salamtv.m3u8", "https://static.wikia.nocookie.net/logopedia/images/2/20/Salam_TV.png", "Religi"),
        ChannelData("MQTV", "https://wahyu1ptv.pages.dev/MQTV-HD.m3u8", "https://static.wikia.nocookie.net/logopedia/images/d/d5/MQTV_%282005%29.png", "Religi"),
        ChannelData("WesalTV", "https://wahyu1ptv.pages.dev/WesalTV-HD.m3u8", "https://upload.wikimedia.org/wikipedia/commons/9/9f/Logo_Wesal_TV.png", "Religi"),
        ChannelData("AshillTV", "https://wahyu1ptv.pages.dev/AshiilTV-HD.m3u8", "https://upload.wikimedia.org/wikipedia/id/9/98/Logo_Ashiil_TV.png", "Religi"),

        ChannelData("JTV", "http://122.248.43.242:1935/JTVSURABAYA/_definst_/myStream/playlist.m3u8", "$iconBase/jtv.png", "Daerah"),
        ChannelData("JAKTV", "http://op-group1-swiftservesd-1.dens.tv/s/s123/S4/mnf.m3u8", "$alkhalifitvBase/jaktv.png", "Daerah"),
        ChannelData("Jowo Channel", "http://khano.nng.cloudns.us/live/m3u8/id/1de333734b1b7e0.m3u8", "$alkhalifitvBase/jowo.png", "Daerah"),

        ChannelData("TVKU", "https://tvku.tv/hlsstream/hls/live.m3u8", "$iconBase/iptv.png", "Daerah"),
        ChannelData("Surabaya TV", "https://e.siar.us/live/surabayatv.m3u8", "https://static.wikia.nocookie.net/logopedia/images/f/fe/Surabaya_TV_2017.png", "Daerah"),
        ChannelData("Stara TV", "https://stream.staratv.id/hls/0/stream.m3u8", "$iconBase/iptv.png", "Daerah"),
        ChannelData("Jawa Pos TV", "http://122.248.43.242:1935/JAWAPOSTVSBY/_definst_/myStream/playlist.m3u8", "$iconBase/iptv.png", "Daerah"),
        ChannelData("Jogja Istimewa TV", "http://103.255.15.222:1935/tv/jitv_720p/playlist.m3u8", "$iconBase/iptv.png", "Daerah"),


        ChannelData("Caruban TV", "https://stream.carubantv.id/hls/0/stream.m3u8", "$iconBase/iptv.png", "Daerah"),
        ChannelData("Dhoho TV", "https://dhohotv.siar.us/dhohotv/live/playlist.m3u8", "$iconBase/iptv.png", "Daerah"),

        ChannelData("Madu TV", "https://re1.siar.us/madutv/hd720/playlist.m3u8", "$iconBase/iptv.png", "Daerah"),
        ChannelData("Jogja TV", "https://stream.jogjatv.co.id/jtvlive/stream/index.m3u8", "$iconBase/iptv.png", "Daerah"),
        ChannelData("Banjar TV", "https://banjartv.siar.us/banjartv/live/playlist.m3u8", "$iconBase/iptv.png", "Daerah"),
        ChannelData("RCTV", "https://v10.siar.us/rctv/live/playlist.m3u8", "$iconBase/iptv.png", "Daerah"),



        ChannelData("TATV", "https://tatv.siar.us/tatv/live.sdp/playlist.m3u8", "$iconBase/iptv.png", "Daerah"),
        ChannelData("Dhamma TV", "https://b.webcache.maxindo.net.id/dhamma/dhamma.m3u8", "$iconBase/iptv.png", "Daerah"),
    )

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

    private val koreaChannels = listOf(
        ChannelData("Arirang TV", "https://amdlive-ch01-ctnd-com.akamaized.net/arirang_1ch/smil:arirang_1ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0cqd-JrliSDG0kvFFKk8IDV7UBJDgP9KDjg&s", "KOREA"),
        ChannelData("Arirang TV UN", "https://amdlive-ch02-ctnd-com.akamaized.net/arirang_2ch/smil:arirang_2ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSwzZZcfmWhFjkbw4ljeVBALeIvi4zqZ94_w&s", "KOREA"),
        ChannelData("Arirang Radio", "https://amdlive-ch02-ctnd-com.akamaized.net/arirang_3ch/smil:arirang_3ch.smil/playlist.m3u8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyPS2HfHVb4Sr1DIRtyxyvQlkYVTj4ZMG4ow&s", "KOREA"),
        ChannelData("ABN TV", "https://vod2.abn.co.kr/IPHONE/abn.m3u8", "$iconBase/iptv.png", "KOREA"),
        ChannelData("BTN", "https://btn.nowcdn.co.kr/btn/btnlive2m/playlist.m3u8", "$iconBase/iptv.png", "KOREA"),
        ChannelData("CJ OnStyle", "https://live-ch1.cjonstyle.net/cjmalllive/stream2/playlist.m3u8", "$iconBase/iptv.png", "KOREA"),

        ChannelData("TVN", "https://op-group1-swiftservehd-1.dens.tv/h/h20/01.m3u8", "$iconBase/iptv.png", "KOREA"),
        ChannelData("SBS", "http://1.222.207.80:1935/live/cjbtv/playlist.m3u8", "$iconBase/iptv.png", "KOREA"),
    )

    private val thailandChannels = listOf(
        ChannelData("Channel 8", "http://vip.login.in.th:1935/ch8/ch8/playlist.m3u8", "$iconBase/iptv.png", "THAILAND"),

        ChannelData("DLTV 1", "https://cdn-live.dltv.ac.th/dltv01.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 2", "https://cdn-live.dltv.ac.th/dltv02.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 3", "https://cdn-live.dltv.ac.th/dltv03.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 4", "https://cdn-live.dltv.ac.th/dltv04.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 5", "https://cdn-live.dltv.ac.th/dltv05.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 6", "https://cdn-live.dltv.ac.th/dltv06.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 7", "https://cdn-live.dltv.ac.th/dltv07.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 8", "https://cdn-live.dltv.ac.th/dltv08.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 9", "https://cdn-live.dltv.ac.th/dltv09.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 10", "https://cdn-live.dltv.ac.th/dltv10.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 11", "https://cdn-live.dltv.ac.th/dltv11.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 12", "https://cdn-live.dltv.ac.th/dltv12.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 13", "https://cdn-live.dltv.ac.th/dltv13.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 14", "https://cdn-live.dltv.ac.th/dltv14.m3u8", "$iconBase/iptv.png", "THAILAND"),
        ChannelData("DLTV 15", "https://cdn-live.dltv.ac.th/dltv15.m3u8", "$iconBase/iptv.png", "THAILAND"),
    )

    private val malaysiaChannels = listOf(

        ChannelData("Astro Awani", "https://d2idp3hzkhjpih.cloudfront.net/out/v1/4b85d9c2bf97413eb0c9fd875599b837/index.m3u8?c", "$iconBase/iptv.png", "MALAYSIA"),
        ChannelData("RTM Asean", "https://d25tgymtnqzu8s.cloudfront.net/event/smil:event1/chunklist_b2596000_slENG.m3u8", "$iconBase/iptv.png", "MALAYSIA"),
        ChannelData("APETITO", "https://d1sq2slp9afh7o.cloudfront.net/smil:apetito/chunklist_b2596000_slENG.m3u8", "$iconBase/iptv.png", "MALAYSIA"),
        ChannelData("AURA", "https://d1sq2slp9afh7o.cloudfront.net/smil:aura/chunklist_b2596000_slENG.m3u8", "$iconBase/iptv.png", "MALAYSIA"),
        ChannelData("FITRAH", "https://d1sq2slp9afh7o.cloudfront.net/smil:fitrah/chunklist_b2596000_slENG.m3u8", "$iconBase/iptv.png", "MALAYSIA"),
        ChannelData("JR.", "https://d1sq2slp9afh7o.cloudfront.net/smil:jr/chunklist_b2596000_slENG.m3u8", "$iconBase/iptv.png", "MALAYSIA"),
        ChannelData("LEAD", "https://d1sq2slp9afh7o.cloudfront.net/smil:lead/chunklist_b2596000_slENG.m3u8", "$iconBase/iptv.png", "MALAYSIA"),
        ChannelData("ROLL", "https://d1sq2slp9afh7o.cloudfront.net/smil:roll/chunklist_b2596000_slENG.m3u8", "$iconBase/iptv.png", "MALAYSIA"),
        ChannelData("SNAP", "https://d1sq2slp9afh7o.cloudfront.net/smil:snap/chunklist_b2596000_slENG.m3u8", "$iconBase/iptv.png", "MALAYSIA"),
    )

    private val bruneiChannels = listOf(
        ChannelData("RTB Sukmaindera", "https://d1211whpimeups.cloudfront.net/smil:rtb1/chunklist.m3u8", "$iconBase/iptv.png", "BRUNEI"),
        ChannelData("RTB Aneka", "https://d1211whpimeups.cloudfront.net/smil:rtb2/chunklist.m3u8", "$iconBase/iptv.png", "BRUNEI"),
        ChannelData("RTB Go Live", "https://d1211whpimeups.cloudfront.net/smil:rtbgo/chunklist.m3u8", "$iconBase/iptv.png", "BRUNEI"),
    )

    private val allChannels = indonesianChannels + japanChannels + koreaChannels + thailandChannels + malaysiaChannels + bruneiChannels

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
        "JEPANG" to "Jepang",
        "KOREA" to "Korea Selatan",
        "THAILAND" to "Thailand",
        "MALAYSIA" to "Malaysia",
        "BRUNEI" to "Brunei"
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
            newLiveSearchResponse(
                name = "#${channelNumber} ${channel.name}",
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
            newLiveSearchResponse(
                name = "#${channelNumber} ${channel.name}",
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
