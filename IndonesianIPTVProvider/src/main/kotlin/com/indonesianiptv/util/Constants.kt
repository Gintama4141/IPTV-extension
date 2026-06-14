package com.indonesianiptv.util

object Constants {
    const val TVRI_BASE = "https://ott-balancer.tvri.go.id/live/eds"
    const val EXO_UA = "ExoPlayer/2.19.1 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"
    const val TVRI_UA = "TVRIKLIK/7.0 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"
    const val DENS_UA = "DENSGO/3.00.00 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"
    const val MNC_UA = "MNCNow/6.33.3 (Linux;Android 15.0.0;) ExoPlayerLib/2.19.1"

    val M3U_SOURCES = listOf(
        "https://iptv-org.github.io/iptv/streams/id.m3u",
        "https://iptv.riotryulianto.workers.dev/",
        "https://raw.githubusercontent.com/windozalmi/Playlist-IPTV-Indonesia-online-Aktif-2025/m3u/playlist.m3u",
        "https://mgi24.github.io/tvdigital/idwork.m3u"
    )

    val TVRI_CHANNELS = listOf(
        "Nasional" to "TVRI Nasional",
        "SportHD" to "TVRI Sport",
        "TVRIWorld" to "TVRI World",
        "DKI" to "TVRI DKI",
        "Aceh" to "TVRI Aceh",
        "Bali" to "TVRI Bali",
        "Babel" to "TVRI Bangka Belitung",
        "Bengkulu" to "TVRI Bengkulu",
        "Gorontalo" to "TVRI Gorontalo",
        "Jabar" to "TVRI Jawa Barat",
        "Jambi" to "TVRI Jambi",
        "Jateng" to "TVRI Jawa Tengah",
        "Jatim" to "TVRI Jawa Timur",
        "Kalbar" to "TVRI Kalimantan Barat",
        "Kalsel" to "TVRI Kalimantan Selatan",
        "Kalteng" to "TVRI Kalimantan Tengah",
        "Kaltim" to "TVRI Kalimantan Timur",
        "Lampung" to "TVRI Lampung",
        "NTB" to "TVRI Nusa Tenggara Barat",
        "NTT" to "TVRI Nusa Tenggara Timur",
        "Papua" to "TVRI Papua",
        "PapuaBarat" to "TVRI Papua Barat",
        "Riau" to "TVRI Riau",
        "Sulbar" to "TVRI Sulawesi Barat",
        "Sulsel" to "TVRI Sulawesi Selatan",
        "Sulteng" to "TVRI Sulawesi Tengah",
        "Sultra" to "TVRI Sulawesi Tenggara",
        "Sulut" to "TVRI Sulawesi Utara",
        "Sumbar" to "TVRI Sumatera Barat",
        "Sumsel" to "TVRI Sumatera Selatan",
        "Sumut" to "TVRI Sumatera Utara",
        "Yogyakarta" to "TVRI Yogyakarta"
    )

    val REGIONAL_CHANNELS = listOf(
        Triple("Nusantara TV", "https://nusantaratv.siar.us/nusantaratv/live/playlist.m3u8", mapOf("User-Agent" to EXO_UA)),
        Triple("Jawa Pos TV", "https://jawapostv.siar.us/jawapostv/live/playlist.m3u8", mapOf("User-Agent" to EXO_UA)),
        Triple("JTV", "http://122.248.43.242:1935/JTVSURABAYA/_definst_/myStream/playlist.m3u8", emptyMap()),
        Triple("Surabaya TV", "https://e.siar.us/live/surabayatv.m3u8", emptyMap()),
        Triple("TV9 Nusantara", "https://5bf7b725107e5.streamlock.net/tv9/tv9/playlist.m3u8", emptyMap()),
        Triple("Bali TV", "http://122.248.43.242:1935/BALITV/_definst_/myStream/playlist.m3u8", emptyMap()),
        Triple("Bandung TV", "http://122.248.32.234:1935/ch1/myStream/playlist.m3u8", emptyMap()),
        Triple("Semarang TV", "http://122.248.32.234:1935/ch2/myStream/playlist.m3u8", emptyMap()),
        Triple("SBO TV", "http://122.248.32.234:1935/ch13/myStream/playlist.m3u8", emptyMap()),
        Triple("Duta TV", "https://dutatv.siar.us/dutatv/live/playlist.m3u8", mapOf("User-Agent" to EXO_UA)),
        Triple("RBTV Bengkulu", "http://122.248.32.234:1935/ch12/myStream/playlist.m3u8", emptyMap()),
        Triple("Palembang TV", "http://122.248.43.242:1935/PALEMBANGTV/_definst_/myStream/playlist.m3u8", emptyMap()),
        Triple("Surau TV", "http://103.28.22.198/surautv/live/playlist.m3u8", emptyMap()),
        Triple("Radar Tasikmalaya", "http://radartasikmalaya.onlivestreaming.net/radartasikmalaya/livestream/playlist.m3u8", emptyMap()),
        Triple("Banyumas TV", "https://5bf7b725107e5.streamlock.net/banyumastv/banyumastv/playlist.m3u8", emptyMap())
    )

    val RELIGIOUS_CHANNELS = listOf(
        Triple("Rodja TV", "https://tv.rodja.live/aliman/ngrp:HD_all/playlist.m3u8", mapOf("User-Agent" to EXO_UA)),
        Triple("Al-Iman TV", "https://tv.aliman.id/aliman/live.m3u8", emptyMap()),
        Triple("TV MUI", "https://mui.siar.us/mui/live/playlist.m3u8", mapOf("User-Agent" to EXO_UA)),
        Triple("Madani TV", "https://madani.siar.us/madani/live/playlist.m3u8", mapOf("User-Agent" to EXO_UA)),
        Triple("TV Mu", "https://5bf7b725107e5.streamlock.net/tvmu/tvmu/playlist.m3u8", emptyMap()),
        Triple("Dhamma TV", "https://5bf7b725107e5.streamlock.net/dhamma/dhamma/playlist.m3u8", emptyMap()),
        Triple("MQTV", "https://5bf7b725107e5.streamlock.net/mqtv/mqtv/playlist.m3u8", emptyMap()),
        Triple("Salam TV", "https://5bf7b725107e5.streamlock.net/salamtv/salamtv/playlist.m3u8", emptyMap()),
        Triple("DAAI TV", "https://hgmtv.com:19360/asthatv/asthatv.m3u8", emptyMap()),
        Triple("Al Bahjah TV", "https://mq-panel.tv:5443/LiveApp/streams/al-bahjahtv.m3u8", emptyMap())
    )

    val NEWS_CHANNELS = listOf(
        Triple("Metro TV", "https://edge.medcom.id/live-edge/smil:metro.smil/playlist.m3u8",
            mapOf("Referer" to "https://www.metrotvnews.com/", "User-Agent" to EXO_UA)),
        Triple("Kompas TV", "https://live-kg.jixie.media/live/kompastv.m3u8",
            mapOf("Referer" to "https://www.kompas.tv/", "User-Agent" to EXO_UA)),
        Triple("CNBC Indonesia", "https://live.cnbcindonesia.com/livecnbc/smil:cnbctv.smil/master.m3u8",
            mapOf("Referer" to "https://www.cnbcindonesia.com/", "User-Agent" to EXO_UA)),
        Triple("iNews", "https://kmklive-lh.akamaihd.net/i/inewstv_live@94479/master.m3u8",
            mapOf("Referer" to "https://www.vidio.com/")),
        Triple("BeritaSatu", "https://kmklive-lh.akamaihd.net/i/beritasatu_live@577566/master.m3u8",
            mapOf("Referer" to "https://www.vidio.com/")),
        Triple("Jak TV", "https://kmklive-lh.akamaihd.net/i/jaktv_live@94476/master.m3u8",
            mapOf("Referer" to "https://www.vidio.com/")),
        Triple("TVOne", "https://kmklive-lh.akamaihd.net/i/tvone_live@577566/master.m3u8",
            mapOf("Referer" to "https://www.vidio.com/"))
    )

    val CATEGORY_ICONS = mapOf(
        "Nasional" to "https://cdn-icons-png.flaticon.com/512/619/619153.png",
        "TV Nasional" to "https://cdn-icons-png.flaticon.com/512/619/619153.png",
        "Berita" to "https://cdn-icons-png.flaticon.com/512/1256/1256641.png",
        "News" to "https://cdn-icons-png.flaticon.com/512/1256/1256641.png",
        "Daerah" to "https://cdn-icons-png.flaticon.com/512/854/854878.png",
        "Region" to "https://cdn-icons-png.flaticon.com/512/854/854878.png",
        "Religi" to "https://cdn-icons-png.flaticon.com/512/3097/3097013.png",
        "Religious" to "https://cdn-icons-png.flaticon.com/512/3097/3097013.png",
        "Olahraga" to "https://cdn-icons-png.flaticon.com/512/2965/2965601.png",
        "Sports" to "https://cdn-icons-png.flaticon.com/512/2965/2965601.png",
        "Anak" to "https://cdn-icons-png.flaticon.com/512/2192/2192972.png",
        "Kids" to "https://cdn-icons-png.flaticon.com/512/2192/2192972.png",
        "Musik" to "https://cdn-icons-png.flaticon.com/512/3659/3659903.png",
        "Music" to "https://cdn-icons-png.flaticon.com/512/3659/3659903.png",
        "Hiburan" to "https://cdn-icons-png.flaticon.com/512/3176/3176383.png",
        "Entertainment" to "https://cdn-icons-png.flaticon.com/512/3176/3176383.png",
        "Internasional" to "https://cdn-icons-png.flaticon.com/512/814/814513.png",
        "International" to "https://cdn-icons-png.flaticon.com/512/814/814513.png",
        "Edukasi" to "https://cdn-icons-png.flaticon.com/512/3496/3496425.png",
        "Pemerintah" to "https://cdn-icons-png.flaticon.com/512/916/916805.png"
    )

    // Category system for IndonesiaTVProvider
    data class CategorizedChannel(
        val name: String,
        val url: String,
        val category: String,
        val tvgId: String? = null,
        val tvgLogo: String? = null,
        val headers: Map<String, String> = emptyMap(),
        val quality: Int = -1
    )

    val CATEGORIES = listOf(
        "Nasional", "Berita", "Edukasi", "Religi", "Daerah",
        "Hiburan", "Musik", "Anak", "Olahraga", "Pemerintah"
    )

    val CATEGORY_LABELS = mapOf(
        "Nasional" to "Nasional",
        "Berita" to "Berita",
        "Edukasi" to "Edukasi",
        "Religi" to "Religi",
        "Daerah" to "Daerah",
        "Hiburan" to "Hiburan",
        "Musik" to "Musik",
        "Anak" to "Anak",
        "Olahraga" to "Olahraga",
        "Pemerintah" to "Pemerintah"
    )

    val CATEGORY_KEYWORDS = mapOf(
        "Nasional" to listOf("nasional", "national", "indonesian", "fta indonesia", "free to air", "tv nasional", "general", "umum"),
        "Berita" to listOf("berita", "news", "berita indonesia", "indonesian news", "current affairs", "siaran berita"),
        "Edukasi" to listOf("edukasi", "education", "edukasi indonesia", "belajar", "learning", "documentary", "dokumenter", "pendidikan", "knowledge"),
        "Religi" to listOf("religi", "religious", "islam", "religi indonesia", "dakwah", "muslim", "spiritual", "religion", "agama"),
        "Daerah" to listOf("daerah", "regional", "lokal", "local", "daerah indonesia", "tv daerah", "regional indonesia", "provinsi"),
        "Hiburan" to listOf("hiburan", "entertainment", "hiburan indonesia", "lifestyle", "variety", "infotainment", "film", "sinetron"),
        "Musik" to listOf("musik", "music", "musik indonesia", "video klip", "music video", "lagu"),
        "Anak" to listOf("anak", "kids", "anak-anak", "children", "anak indonesia", "kartun", "cartoon", "kids & family"),
        "Olahraga" to listOf("olahraga", "sports", "olahraga indonesia", "sport", "indonesian sport"),
        "Pemerintah" to listOf("pemerintah", "government", "pemerintah indonesia", "tv pemerintah", "publik", "public", "parliament")
    )

    // Country system for InternationalTVProvider
    data class CountryData(
        val code: String,
        val name: String,
        val m3uUrl: String?
    )

    val COUNTRIES = listOf(
        CountryData("JP", "Jepang", "https://iptv-org.github.io/iptv/streams/jp.m3u8"),
        CountryData("KR", "Korea", null),
        CountryData("TH", "Thailand", null),
        CountryData("MY", "Malaysia", null),
        CountryData("BN", "Brunei", null),
        CountryData("SG", "Singapura", null),
        CountryData("PH", "Filipina", null),
        CountryData("US", "Amerika Serikat", "https://iptv-org.github.io/iptv/streams/us.m3u8"),
        CountryData("GB", "Inggris", "https://iptv-org.github.io/iptv/streams/gb.m3u8"),
        CountryData("DE", "Jerman", "https://iptv-org.github.io/iptv/streams/de.m3u8"),
        CountryData("FR", "Perancis", "https://iptv-org.github.io/iptv/streams/fr.m3u8"),
        CountryData("AU", "Australia", "https://iptv-org.github.io/iptv/streams/au.m3u8"),
        CountryData("IN", "India", "https://iptv-org.github.io/iptv/streams/in.m3u8"),
        CountryData("CN", "China", "https://iptv-org.github.io/iptv/streams/cn.m3u8"),
        CountryData("TW", "Taiwan", "https://iptv-org.github.io/iptv/streams/tw.m3u8"),
        CountryData("HK", "Hong Kong", "https://iptv-org.github.io/iptv/streams/hk.m3u8"),
        CountryData("NL", "Belanda", "https://iptv-org.github.io/iptv/streams/nl.m3u8"),
        CountryData("SA", "Arab Saudi", "https://iptv-org.github.io/iptv/streams/sa.m3u8"),
        CountryData("TR", "Turki", "https://iptv-org.github.io/iptv/streams/tr.m3u8"),
        CountryData("RU", "Rusia", "https://iptv-org.github.io/iptv/streams/ru.m3u8")
    )

    // Hardcoded international channels (fallback when M3U unavailable)
    val INTERNATIONAL_CHANNELS = listOf(
        CategorizedChannel("NHK G", "https://akariko.netgenx.site/stream/jp/nhk_g/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7fe0-011-400x400.png", quality = 720),
        CategorizedChannel("NHK E", "https://akariko.netgenx.site/stream/jp/nhk_e/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7fe1-021-400x400.png", quality = 720),
        CategorizedChannel("NTV", "https://akariko.netgenx.site/stream/jp/ntv/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7fe2-041-400x400.png", quality = 720),
        CategorizedChannel("TV Asahi", "https://akariko.netgenx.site/stream/jp/tv_asahi/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7fe5-051-400x400.png", quality = 720),
        CategorizedChannel("TBS", "https://akariko.netgenx.site/stream/jp/tbs/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7fe3-061-400x400.png", quality = 720),
        CategorizedChannel("TV Tokyo", "https://akariko.netgenx.site/stream/jp/tv_tokyo/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7fe6-071-400x400.png", quality = 720),
        CategorizedChannel("Fuji TV", "https://akariko.netgenx.site/stream/jp/fuji_tv/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7fe4-081-400x400.png", quality = 720),
        CategorizedChannel("Tokyo MX1", "https://akariko.netgenx.site/stream/jp/tokyo_mx1/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7e87-091-400x400.png", quality = 720),
        CategorizedChannel("Tokyo MX2", "https://akariko.netgenx.site/stream/jp/tokyo_mx2/stream-output.m3u8?mode=hls", "JP", tvgLogo = "https://tvguide.myjcom.jp/monomedia/ch_logo/otd/logo-7e87-093-400x400.png", quality = 720),
        CategorizedChannel("NHK World Japan", "https://media-tyo.hls.nhkworld.jp/hls/w/live/master.m3u8", "JP", tvgLogo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUuAlkE08b3RI79ZRo0e4oe0nZm3NxnuYOIw&s", quality = 720),
        CategorizedChannel("Arirang TV", "https://amdlive-ch01-ctnd-com.akamaized.net/arirang_1ch/smil:arirang_1ch.smil/playlist.m3u8", "KR", quality = 720),
        CategorizedChannel("Arirang TV UN", "https://amdlive-ch02-ctnd-com.akamaized.net/arirang_2ch/smil:arirang_2ch.smil/playlist.m3u8", "KR", quality = 720),
        CategorizedChannel("Arirang Radio", "https://amdlive-ch02-ctnd-com.akamaized.net/arirang_3ch/smil:arirang_3ch.smil/playlist.m3u8", "KR", quality = 720),
        CategorizedChannel("Channel 8 (TH)", "http://vip.login.in.th:1935/ch8/ch8/playlist.m3u8", "TH", quality = 480),
        CategorizedChannel("Astro Awani", "https://d2idp3hzkhjpih.cloudfront.net/out/v1/4b85d9c2bf97413eb0c9fd875599b837/index.m3u8", "MY", quality = 720),
        CategorizedChannel("RTM Asean", "https://d25tgymtnqzu8s.cloudfront.net/event/smil:event1/chunklist_b2596000_slENG.m3u8", "MY", quality = 720, headers = mapOf("Referer" to "https://rtmklik.rtm.gov.my/")),
        CategorizedChannel("RTB Sukmaindera", "https://d1211whpimeups.cloudfront.net/smil:rtb1/chunklist.m3u8", "BN", quality = 720),
        CategorizedChannel("RTB Aneka", "https://d1211whpimeups.cloudfront.net/smil:rtb2/chunklist.m3u8", "BN", quality = 720),
        CategorizedChannel("RTB Go Live", "https://d1211whpimeups.cloudfront.net/smil:rtbgo/chunklist.m3u8", "BN", quality = 720),
        CategorizedChannel("Channel 5 (SG)", "https://app.viloud.tv/hls/channel/dcbf7a54c89ba12d98cc7c401c37f565.m3u8", "SG", quality = 720),
        CategorizedChannel("Channel 8 (SG)", "https://app.viloud.tv/hls/channel/57148804a268f59e0c1af0c1b67a2f7e.m3u8", "SG", quality = 720),
        CategorizedChannel("Channel U", "https://app.viloud.tv/hls/channel/aaf404bee904cff424bb5d1f6fdf9333.m3u8", "SG", quality = 720),
        CategorizedChannel("GMA 7", "https://catty.wtf/kapuso/stream/index.m3u8", "PH", quality = 720),
        CategorizedChannel("Hope Channel PH", "https://jstre.am/live/jsl:7A1swL7Fhlh.m3u8", "PH", quality = 720),
        CategorizedChannel("UNTV", "https://cdn.untvweb.com/live-stream/untvweb.m3u8", "PH", quality = 720)
    )

    // TVRI channels categorized for IndonesiaTVProvider
    val TVRI_CATEGORIZED = listOf(
        CategorizedChannel("TVRI Nasional", "$TVRI_BASE/Nasional/hls/Nasional.m3u8", "Nasional", tvgId = "TVRI.id", tvgLogo = CATEGORY_ICONS["Nasional"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI World", "$TVRI_BASE/TVRIWorld/hls/TVRIWorld.m3u8", "Nasional", tvgId = "TVRIWorld.id", tvgLogo = CATEGORY_ICONS["Nasional"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sport", "$TVRI_BASE/SportHD/hls/SportHD.m3u8", "Olahraga", tvgId = "TVRISport.id", tvgLogo = CATEGORY_ICONS["Olahraga"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Aceh", "$TVRI_BASE/Aceh/hls/Aceh.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Bali", "$TVRI_BASE/Bali/hls/Bali.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Bangka Belitung", "$TVRI_BASE/Babel/hls/Babel.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Bengkulu", "$TVRI_BASE/Bengkulu/hls/Bengkulu.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI DKI Jakarta", "$TVRI_BASE/DKI/hls/DKI.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Gorontalo", "$TVRI_BASE/Gorontalo/hls/Gorontalo.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Jambi", "$TVRI_BASE/Jambi/hls/Jambi.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Jawa Barat", "$TVRI_BASE/Jabar/hls/Jabar.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Jawa Tengah", "$TVRI_BASE/Jateng/hls/Jateng.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Jawa Timur", "$TVRI_BASE/Jatim/hls/Jatim.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Kalimantan Barat", "$TVRI_BASE/Kalbar/hls/Kalbar.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Kalimantan Selatan", "$TVRI_BASE/Kalsel/hls/Kalsel.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Kalimantan Tengah", "$TVRI_BASE/Kalteng/hls/Kalteng.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Kalimantan Timur", "$TVRI_BASE/Kaltim/hls/Kaltim.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Lampung", "$TVRI_BASE/Lampung/hls/Lampung.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI NTB", "$TVRI_BASE/NTB/hls/NTB.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI NTT", "$TVRI_BASE/NTT/hls/NTT.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Papua", "$TVRI_BASE/Papua/hls/Papua.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Papua Barat", "$TVRI_BASE/PapuaBarat/hls/PapuaBarat.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Riau", "$TVRI_BASE/Riau/hls/Riau.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sulawesi Barat", "$TVRI_BASE/Sulbar/hls/Sulbar.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sulawesi Selatan", "$TVRI_BASE/Sulsel/hls/Sulsel.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sulawesi Tengah", "$TVRI_BASE/Sulteng/hls/Sulteng.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sulawesi Tenggara", "$TVRI_BASE/Sultra/hls/Sultra.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sulawesi Utara", "$TVRI_BASE/Sulut/hls/Sulut.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sumatera Barat", "$TVRI_BASE/Sumbar/hls/Sumbar.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sumatera Selatan", "$TVRI_BASE/Sumsel/hls/Sumsel.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Sumatera Utara", "$TVRI_BASE/Sumut/hls/Sumut.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA)),
        CategorizedChannel("TVRI Yogyakarta", "$TVRI_BASE/Yogyakarta/hls/Yogyakarta.m3u8", "Daerah", tvgLogo = CATEGORY_ICONS["Daerah"], quality = 720, headers = mapOf("User-Agent" to TVRI_UA))
    )

    // Hardcoded Indonesian channels (beyond TVRI) categorized
    val INDONESIAN_CHANNELS = listOf(
        // MNC Group → Nasional
        CategorizedChannel("RCTI", "https://d35d0ifx19oopq.cloudfront.net/live/eds/rcti_fta/live_fta/rcti_fta.m3u8", "Nasional", tvgId = "RCTI.id", quality = 720, headers = mapOf("User-Agent" to MNC_UA, "Referer" to "https://www.rctiplus.com/tv/rcti")),
        CategorizedChannel("MNCTV", "https://d33j155pv2xyba.cloudfront.net/live/eds/mnctv_fta/live_fta/mnctv_fta.m3u8", "Nasional", tvgId = "MNCTV.id", quality = 720, headers = mapOf("User-Agent" to MNC_UA, "Referer" to "https://www.rctiplus.com/tv/mnctv")),
        CategorizedChannel("GTV", "https://d322b885qvsbxg.cloudfront.net/live/eds/gtv_fta/live_fta/gtv_fta.m3u8", "Nasional", tvgId = "GTV.id", quality = 720, headers = mapOf("User-Agent" to MNC_UA, "Referer" to "https://www.rctiplus.com/tv/gtv")),
        CategorizedChannel("iNews", "https://d2hfpzcndkyscp.cloudfront.net/live/eds/INEWS_2021/live_fta/INEWS_2021.m3u8", "Berita", tvgId = "iNews.id", quality = 720, headers = mapOf("User-Agent" to MNC_UA, "Referer" to "https://www.rctiplus.com/tv/inews")),
        // Trans Media → Nasional
        CategorizedChannel("Trans TV", "https://livestream.transtv.co.id/stream/live/ttv.m3u8", "Nasional", tvgId = "TransTV.id", quality = 720, headers = mapOf("Referer" to "https://www.detik.com/")),
        CategorizedChannel("Trans7", "https://video.detik.com/trans7/smil:trans7.smil/index.m3u8", "Nasional", tvgId = "Trans7.id", quality = 720, headers = mapOf("Referer" to "https://www.detik.com/")),
        // SCM Group → Nasional
        CategorizedChannel("SCTV", "http://op-group1-swiftservehd-1.dens.tv/h/h217/02.m3u8", "Nasional", tvgId = "SCTV.id", quality = 720, headers = mapOf("User-Agent" to DENS_UA, "Referer" to "http://dens.tv")),
        CategorizedChannel("Indosiar", "http://op-group1-swiftservehd-1.dens.tv/h/h207/02.m3u8", "Nasional", tvgId = "Indosiar.id", quality = 720, headers = mapOf("User-Agent" to DENS_UA, "Referer" to "http://dens.tv")),
        // Other Nasional
        CategorizedChannel("NET TV", "https://cdn-accedo-01.akamaized.net/Content/HLS/Live/channel(404d689d-691f-4035-9801-ae8bfd8712e9)/index.m3u8", "Nasional", tvgId = "NET.id", quality = 720),
        CategorizedChannel("Moji (O Channel)", "https://kmklive-lh.akamaihd.net/i/ochannel_live@577566/master.m3u8", "Nasional", quality = 720),
        CategorizedChannel("tvOne", "https://yt.urfan.web.id/stream/yNKvkPJl-tg/master.m3u8", "Berita", tvgId = "tvOne.id", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("ANTV", "http://210.210.155.35/qwr9ew/s/s07/index1.m3u8", "Nasional", tvgId = "ANTV.id", quality = 480, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("Mentari TV", "https://app-etslive-2.vidio.com/live/8237/master.m3u8", "Anak", quality = 720),
        CategorizedChannel("Magna Channel", "https://edge.medcom.id/live-edge/smil:magna.smil/playlist.m3u8", "Nasional", quality = 720, headers = mapOf("Referer" to "https://www.metrotvnews.com/", "User-Agent" to EXO_UA)),
        CategorizedChannel("Nusantara TV", "https://nusantaratv.siar.us/nusantaratv/live/playlist.m3u8", "Nasional", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("Indonesiana TV", "https://tvstreamcast.com/indonesiana.m3u8", "Edukasi", quality = 720, headers = mapOf("Referer" to "https://indonesiana.tv/")),
        CategorizedChannel("Garuda TV", "https://hgmtv.com:19360/garudatvlivestreaming/garudatvlivestreaming.m3u8", "Nasional", quality = 720),
        CategorizedChannel("RTV", "https://rtvstream.rtv.co.id:4555/hls/rtv.m3u8", "Hiburan", quality = 720),
        // News channels → Berita
        CategorizedChannel("Metro TV", "https://yt.urfan.web.id/stream/XKueVSGTk2o/master.m3u8", "Berita", tvgId = "MetroTV.id", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("Kompas TV", "https://live-kg.jixie.media/live/kompastv.m3u8", "Berita", tvgId = "KompasTV.id", quality = 720, headers = mapOf("Referer" to "https://www.kompas.tv/", "User-Agent" to EXO_UA)),
        CategorizedChannel("CNN Indonesia", "https://live.cnnindonesia.com/livecnn/smil:cnntv.smil/playlist.m3u8", "Berita", tvgId = "CNNIndonesia.id", quality = 720, headers = mapOf("Referer" to "https://www.cnnindonesia.com/")),
        CategorizedChannel("CNBC Indonesia", "https://live.cnbcindonesia.com/livecnbc/smil:cnbctv.smil/master.m3u8", "Berita", tvgId = "CNBCIndonesia.id", quality = 720, headers = mapOf("Referer" to "https://www.cnbcindonesia.com/")),
        CategorizedChannel("BTV", "https://btv.secureswiftcontent.com/han/btv/btv10005/srtoutput/manifest.m3u8", "Berita", quality = 720, headers = mapOf("Referer" to "https://www.beritasatu.com/btv-live-streaming")),
        CategorizedChannel("BN Channel", "https://flv.intechmedia.net/live/ch112.m3u8", "Berita", quality = 720),
        CategorizedChannel("Jak TV", "https://kmklive-lh.akamaihd.net/i/jaktv_live@94476/master.m3u8", "Berita", quality = 720),
        CategorizedChannel("BeritaSatu", "https://kmklive-lh.akamaihd.net/i/beritasatu_live@577566/master.m3u8", "Berita", quality = 720),
        // Religious → Religi
        CategorizedChannel("Rodja TV", "https://tv.rodja.live/aliman/ngrp:HD_all/playlist.m3u8", "Religi", tvgId = "RodjaTV.id", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("Al-Iman TV", "https://tv.aliman.id/aliman/live.m3u8", "Religi", quality = 720),
        CategorizedChannel("TV MUI", "https://mui.siar.us/mui/live/playlist.m3u8", "Religi", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("Madani TV", "https://madani.siar.us/madani/live/playlist.m3u8", "Religi", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("TV Mu", "https://5bf7b725107e5.streamlock.net/tvmu/tvmu/playlist.m3u8", "Religi", quality = 720),
        CategorizedChannel("DAAI TV", "https://hgmtv.com:19360/asthatv/asthatv.m3u8", "Religi", quality = 720),
        CategorizedChannel("MQTV", "https://5bf7b725107e5.streamlock.net/mqtv/mqtv/playlist.m3u8", "Religi", quality = 720),
        CategorizedChannel("Salam TV", "https://5bf7b725107e5.streamlock.net/salamtv/salamtv/playlist.m3u8", "Religi", quality = 720),
        CategorizedChannel("Al Bahjah TV", "https://mq-panel.tv:5443/LiveApp/streams/al-bahjahtv.m3u8", "Religi", quality = 720),
        CategorizedChannel("Dhamma TV", "https://5bf7b725107e5.streamlock.net/dhamma/dhamma/playlist.m3u8", "Religi", quality = 720),
        // Regional → Daerah
        CategorizedChannel("Jawa Pos TV", "https://jawapostv.siar.us/jawapostv/live/playlist.m3u8", "Daerah", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("JTV", "http://122.248.43.242:1935/JTVSURABAYA/_definst_/myStream/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Surabaya TV", "https://e.siar.us/live/surabayatv.m3u8", "Daerah", quality = 720),
        CategorizedChannel("TV9 Nusantara", "https://5bf7b725107e5.streamlock.net/tv9/tv9/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Bali TV", "http://122.248.43.242:1935/BALITV/_definst_/myStream/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Bandung TV", "http://122.248.32.234:1935/ch1/myStream/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Semarang TV", "http://122.248.32.234:1935/ch2/myStream/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("SBO TV", "http://122.248.32.234:1935/ch13/myStream/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Duta TV", "https://dutatv.siar.us/dutatv/live/playlist.m3u8", "Daerah", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("RBTV Bengkulu", "http://122.248.32.234:1935/ch12/myStream/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Palembang TV", "http://122.248.43.242:1935/PALEMBANGTV/_definst_/myStream/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Surau TV", "http://103.28.22.198/surautv/live/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Banyumas TV", "https://5bf7b725107e5.streamlock.net/banyumastv/banyumastv/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Radar Tasikmalaya", "http://radartasikmalaya.onlivestreaming.net/radartasikmalaya/livestream/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("TVKU", "https://tvku.tv/hlsstream/hls/live.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Caruban TV", "https://stream.carubantv.id/hls/0/stream.m3u8", "Daerah", quality = 720, headers = mapOf("Referer" to "https://stream.carubantv.id")),
        CategorizedChannel("Dhoho TV", "https://dhohotv.siar.us/dhohotv/live/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Madu TV", "https://re1.siar.us/madutv/hd720/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Jogja TV", "https://stream.jogjatv.co.id/jtvlive/stream/index.m3u8", "Daerah", quality = 720),
        CategorizedChannel("TATV", "https://tatv.siar.us/tatv/live.sdp/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Stara TV", "https://stream.staratv.id/hls/0/stream.m3u8", "Daerah", quality = 720)
    )
}
