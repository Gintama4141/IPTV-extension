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
        "Hiburan", "Musik", "Anak", "Olahraga", "International", "Pemerintah"
    )

    val MUSIC_CATEGORY = "Music"

    val CATEGORY_FLAGS = mapOf(
        "Nasional" to "\uD83C\uDDE6\uD83C\uDDEA",
        "Berita" to "\uD83D\uDCF0",
        "Edukasi" to "\uD83C\uDF93",
        "Religi" to "\uD83D\uDD4C",
        "Daerah" to "\uD83C\uDFD8\uFE0F",
        "Hiburan" to "\uD83C\uDFAC",
        "Musik" to "\uD83C\uDFB5",
        "Anak" to "\uD83E\uDDD2",
        "Musik" to "\uD83C\uDFB5",
        "Olahraga" to "\u26BD",
        "International" to "\uD83C\uDF0D",
        "Pemerintah" to "\uD83C\uDFDB\uFE0F"
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
        "International" to listOf("international", "international tv", "world", "global"),
        "Pemerintah" to listOf("pemerintah", "government", "pemerintah indonesia", "tv pemerintah", "publik", "public", "parliament")
    )

    // Country system
    data class CountryData(
        val code: String,
        val name: String,
        val flag: String,
        val m3uUrl: String?
    )

    val COUNTRIES = listOf(
        CountryData("US", "Amerika Serikat", "\uD83C\uDDFA\uD83C\uDDF8", "https://iptv-org.github.io/iptv/streams/us.m3u8"),
        CountryData("GB", "Inggris", "\uD83C\uDDEC\uD83C\uDDE7", "https://iptv-org.github.io/iptv/streams/gb.m3u8"),
        CountryData("DE", "Jerman", "\uD83C\uDDE9\uD83C\uDDEA", "https://iptv-org.github.io/iptv/streams/de.m3u8"),
        CountryData("FR", "Perancis", "\uD83C\uDDEB\uD83C\uDDF7", "https://iptv-org.github.io/iptv/streams/fr.m3u8"),
        CountryData("AU", "Australia", "\uD83C\uDDE6\uD83C\uDDFA", "https://iptv-org.github.io/iptv/streams/au.m3u8"),
        CountryData("IN", "India", "\uD83C\uDDEE\uD83C\uDDF3", "https://iptv-org.github.io/iptv/streams/in.m3u8"),
        CountryData("CN", "China", "\uD83C\uDDE8\uD83C\uDDF3", "https://iptv-org.github.io/iptv/streams/cn.m3u8"),
        CountryData("TW", "Taiwan", "\uD83C\uDDF9\uD83C\uDDFC", "https://iptv-org.github.io/iptv/streams/tw.m3u8"),
        CountryData("HK", "Hong Kong", "\uD83C\uDDED\uD83C\uDDF0", "https://iptv-org.github.io/iptv/streams/hk.m3u8"),
        CountryData("NL", "Belanda", "\uD83C\uDDF3\uD83C\uDDF1", "https://iptv-org.github.io/iptv/streams/nl.m3u8"),
        CountryData("SA", "Arab Saudi", "\uD83C\uDDF8\uD83C\uDDE6", "https://iptv-org.github.io/iptv/streams/sa.m3u8"),
        CountryData("TR", "Turki", "\uD83C\uDDF9\uD83C\uDDF7", "https://iptv-org.github.io/iptv/streams/tr.m3u8"),
        CountryData("RU", "Rusia", "\uD83C\uDDF7\uD83C\uDDFA", "https://iptv-org.github.io/iptv/streams/ru.m3u8")
    )

    // Hardcoded international channels (fallback when M3U unavailable)
    val INTERNATIONAL_CHANNELS = listOf<CategorizedChannel>()

    val TVRI_CATEGORIZED = listOf(
        CategorizedChannel("TVRI World", "$TVRI_BASE/TVRIWorld/hls/TVRIWorld.m3u8", "Nasional", tvgId = "TVRIWorld.id", tvgLogo = "https://raw.githubusercontent.com/iptv-org/iptv/master/assets/channels/TVRIWorld.id.png", quality = 720, headers = mapOf("User-Agent" to TVRI_UA))
    )

    // Hardcoded Indonesian channels (beyond TVRI) categorized
    // Indonesian FTA channel logos (mimipipi22 directory)
    private val MIMIPIPI_MAP = mapOf(
        "rcti" to "rcti.png",
        "mnctv" to "mnctv.png",
        "gtv" to "gtv.png",
        "inews" to "inews.png",
        "trans tv" to "transtv.png",
        "trans7" to "trans7.png",
        "sctv" to "sctv.png",
        "indosiar" to "indosiar.png",
        "net tv" to "nettv.png",
        "tvone" to "tvone.png",
        "metro tv" to "metrotv.png",
        "kompas tv" to "kompastv.png",
        "cnn indonesia" to "cnnindonesia.png",
        "cnbc indonesia" to "cnbcindonesia.png",
        "rodja tv" to "rodjatv.png",
        "daai tv" to "daaitv.png",
        "beritasatu" to "beritasatu.png",
        "jawa pos tv" to "jawapostv.png",
        "jtv" to "jtv.png",
        "surabaya tv" to "surabayatv.png",
        "bali tv" to "balitv.png",
        "bandung tv" to "bandungtv.png",
        "duta tv" to "dutatv.png",
        "tv mui" to "tvmui.png"
    )

    // Wikimedia Commons logo filenames (from Commons category "Logos of television channels in Indonesia")
    private val COMMONS_LOGO_MAP = mapOf(
        // TVRI Nasional & Flagship
        "TVRI Nasional" to "TVRILogo2019.svg",
        "TVRI World" to "TVRIWorld.png",
        "TVRI Sport" to "TVRISportHD.png",

        // TVRI Regional (30 stations)
        "TVRI Aceh" to "TVRI Aceh.png",
        "TVRI Bali" to "TVRI Bali.png",
        "TVRI Bangka Belitung" to "TVRI Bangka Belitung.png",
        "TVRI Bengkulu" to "TVRI Bengkulu.png",
        "TVRI DKI Jakarta" to "TVRI Jakarta.png",
        "TVRI Gorontalo" to "TVRI Gorontalo.png",
        "TVRI Jambi" to "TVRI Jambi.png",
        "TVRI Jawa Barat" to "TVRI Jawa Barat.png",
        "TVRI Jawa Tengah" to "TVRI Jawa Tengah.png",
        "TVRI Jawa Timur" to "TVRI Jawa Timur.png",
        "TVRI Kalimantan Barat" to "TVRI Kalimantan Barat.png",
        "TVRI Kalimantan Selatan" to "TVRI Kalimantan Selatan.png",
        "TVRI Kalimantan Tengah" to "TVRI Kalimantan Tengah.png",
        "TVRI Kalimantan Timur" to "TVRI Kalimantan Timur.png",
        "TVRI Kalimantan Utara" to "TVRI Kalimantan Utara.png",
        "TVRI Lampung" to "TVRI Lampung.png",
        "TVRI NTB" to "TVRI Nusa Tenggara Barat.png",
        "TVRI NTT" to "TVRI Nusa Tenggara Timur.png",
        "TVRI Papua" to "TVRI Papua.png",
        "TVRI Papua Barat" to "TVRI Papua Barat.png",
        "TVRI Riau" to "TVRI Riau.png",
        "TVRI Sulawesi Barat" to "TVRI Sulawesi Barat.png",
        "TVRI Sulawesi Selatan" to "TVRI Sulawesi Selatan.png",
        "TVRI Sulawesi Tengah" to "TVRI Sulawesi Tengah.png",
        "TVRI Sulawesi Tenggara" to "TVRI Sulawesi Tenggara.png",
        "TVRI Sulawesi Utara" to "TVRI Sulawesi Utara.png",
        "TVRI Sumatera Barat" to "TVRI Sumatera Barat.png",
        "TVRI Sumatera Selatan" to "TVRI Sumatera Selatan.png",
        "TVRI Sumatera Utara" to "TVRI Sumatera Utara.png",
        "TVRI Yogyakarta" to "TVRI Yogyakarta.png",

        // National FTA
        "RCTI" to "RCTI logo 2015.svg",
        "MNCTV" to "MNCTV logo 2015.svg",
        "GTV" to "GTV logo (2017).png",
        "iNews" to "INews.svg",
        "Trans TV" to "Logo Trans TV.png",
        "Trans7" to "Logo Trans7.png",
        "SCTV" to "SCTV Logo.svg",
        "Indosiar" to "INDOSIAR Logo.png",
        "NET TV" to "Logo NET Kuning.png",
        "Moji (O Channel)" to "Moji blue.svg",
        "tvOne" to "TvOne 2023.svg",
        "Mentari TV" to "Mentari TV Logo.svg",
        "Magna Channel" to "MagnaChannel.png",
        "Nusantara TV" to "Logo nusantaratv.png",
        "Indonesiana TV" to "IndonesianaTV.png",
        "Garuda TV" to "Logo GarudaTV 3D Putih Silver Merah.png",
        "MDTV" to "MDTV logo.svg",
        "VTV" to "VTV Indonesia 2023.svg",

        // News
        "Kompas TV" to "Kompas TV (2016) logo.svg",
        "CNN Indonesia" to "CNN Indonesia logo.svg",
        "CNBC Indonesia" to "Logo of CNBC Indonesia.svg",
        "BTV" to "LogoBTV.png",
        "BN Channel" to "BN Channel.png",
        "BeritaSatu" to "Beritasatu.png",

        // Religious
        "DAAI TV" to "DAAI TV Jakarta.png",

        // Regional
        "Jawa Pos TV" to "Jawa Pos TV 2024.svg",
        "JTV" to "JTV (Indonesian TV channel) 2022.svg",
        "Jogja TV" to "Jogjatvnew.png",
        "Caruban TV" to "CarubanTV(Low-res).png",
        "Digdaya TV" to "Logo-digdaya-tv.png",
        "E Channel" to "Echannel 2024.png",
        "Sin Po TV" to "Sin Po TV.svg"
    )

    private const val LOCAL_LOGOS_BASE = "https://raw.githubusercontent.com/Gintama4141/IPTV-extension/master/IndonesianIPTVProvider/logos/"

    private val LOCAL_LOGOS_MAP = mapOf(
        "rcti" to "rcti.png",
        "mnctv" to "mnctv.png",
        "gtv" to "gtv.png",
        "sctv" to "sctv.png",
        "indosiar" to "indosiar.png",
        "net tv" to "net_tv.png",
        "trans tv" to "transtv.png",
        "trans7" to "trans7.png",
        "tvone" to "tvone.png",
        "moji tv" to "moji.png",
        "nusantara tv" to "nusantara_tv.png",
        "inews" to "inews.png",
        "kompas tv" to "kompas_tv.png",
        "cnn indonesia" to "cnn_indonesia.png",
        "daai tv" to "daai_tv.png",
        "tvri nasional" to "tvri_nasional.png",
        "tvri world" to "tvri_world.png",
        "tvri sport" to "tvri_sport.png",
        "tvri aceh" to "tvri_aceh.png",
        "tvri bali" to "tvri_bali.png",
        "tvri jawa barat" to "tvri_jabar.png",
        "tvri jawa tengah" to "tvri_jateng.png",
        "tvri kalimantan barat" to "tvri_kalbar.png",
        "tvri lampung" to "tvri_lampung.png",
        "tvri ntb" to "tvri_ntb.png",
        "prambors" to "prambors.png",
        "sakti tv" to "sakti_tv.png",
        "salam tv" to "salam_tv.png",
        "semarang tv" to "semarang_tv.png",
        "surabaya tv" to "surabaya_tv.png",
        "surau tv" to "surau_tv.png",
        "tatv" to "tatv.png",
        "vtv" to "vtv.png",
        "salira tv" to "salira_tv.png",
        "garuda tv" to "garuda_tv.png"
    )

    private fun resolveCommonsLogo(name: String): String? {
        val filename = COMMONS_LOGO_MAP[name] ?: return null
        val encodedFilename = filename.replace(" ", "_")
        return if (encodedFilename.endsWith(".svg", ignoreCase = true)) {
            "https://commons.wikimedia.org/wiki/Special:Redirect/file/$encodedFilename?width=300"
        } else {
            "https://commons.wikimedia.org/wiki/Special:FilePath/$encodedFilename"
        }
    }

    fun resolveLogo(name: String, tvgId: String? = null, tvgLogo: String? = null): String {
        tvgLogo?.let { return it }
        // Check local repo logos first
        LOCAL_LOGOS_MAP[name.lowercase()]?.let { return "$LOCAL_LOGOS_BASE$it" }
        resolveCommonsLogo(name)?.let { return it }
        if (tvgId != null) return "https://raw.githubusercontent.com/iptv-org/iptv/master/assets/channels/$tvgId.png"
        val file = MIMIPIPI_MAP[name.lowercase()] ?: return generateLogo(name)
        return "https://mimipipi22.github.io/logo/nasional/$file"
    }

    private fun generateLogo(name: String): String {
        return "https://ui-avatars.com/api/?name=${java.net.URLEncoder.encode(name, "UTF-8")}&background=random&color=fff&size=200"
    }

    val INDONESIAN_CHANNELS = listOf(
        // MNC Group → Nasional
        // Trans Media → Nasional
        CategorizedChannel("Trans TV", "https://livestream.transtv.co.id/stream/live/ttv.m3u8", "Nasional", tvgId = "TransTV.id", quality = 720, headers = mapOf("Referer" to "https://www.detik.com/")),

        // Other Nasional
        CategorizedChannel("Oxygen TV", "https://cdn4-reg2.mm.oxygen.id:8080/hls/oxygentv-web/index.m3u8", "Nasional", quality = 720),
        CategorizedChannel("PBS Kids", "https://2-fss-2.streamhoster.com/pl_140/amlst:200914-1298290/playlist.m3u8", "Anak", quality = 720),
        CategorizedChannel("Duck TV", "https://stream.ads.ottera.tv/playlist.m3u8?network_id=7617", "Anak", quality = 720),
        CategorizedChannel("Magna Channel", "https://edge.medcom.id/live-edge/smil:magna.smil/playlist.m3u8", "Nasional", quality = 720, headers = mapOf("Referer" to "https://www.metrotvnews.com/", "User-Agent" to EXO_UA)),
        CategorizedChannel("Nusantara TV", "https://nusantaratv.siar.us/nusantaratv/live/playlist.m3u8", "Nasional", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("Indonesiana TV", "https://tvstreamcast.com/indonesiana.m3u8", "Edukasi", quality = 720, headers = mapOf("Referer" to "https://indonesiana.tv/")),

        CategorizedChannel("Garuda TV", "https://hgmtv.com:19360/garudatvlivestreaming/garudatvlivestreaming.m3u8", "Nasional", quality = 720),
        CategorizedChannel("Dens Food", "https://op-group1-densxvisionhd-1.dens.tv/h/h248/04.m3u8", "Hiburan", quality = 720),
        CategorizedChannel("Allegro", "https://vodcdn.bamboo-cloud.com/livehls/68c525e1063044539b09c253/master.m3u8", "Anak", quality = 720),
        CategorizedChannel("Ananda", "https://vodcdn.bamboo-cloud.com/livehls/68ef86320630444b1f796875/master.m3u8", "Anak", quality = 720),
        CategorizedChannel("RTV", "https://rtvstream.rtv.co.id:4555/hls/rtv.m3u8", "Hiburan", quality = 720),
        CategorizedChannel("Elshinta TV", "https://rbmn-live.akamaized.net/hls/live/590964/BoRB-AT/master.m3u8", "Hiburan", quality = 720),
        CategorizedChannel("BMS TV", "https://5bf7b725107e5.streamlock.net/bmstv/bmstv/playlist.m3u8", "Hiburan", quality = 720),

        CategorizedChannel("Stara TV Majalengka", "https://stream.staratv.id/hls/0/stream.m3u8", "Hiburan", quality = 720),
        CategorizedChannel("Stara TV Yogyakarta", "https://stream.matrixtv.id/hls/0/stream.m3u8", "Hiburan", quality = 720),
        CategorizedChannel("Lingkar TV", "https://lingkartv.my.id/hls/lingkartv.m3u8", "Hiburan", quality = 720),
        // News channels → Berita
        CategorizedChannel("CNN Indonesia", "https://live.cnnindonesia.com/livecnn/smil:cnntv.smil/playlist.m3u8", "Berita", tvgId = "CNNIndonesia.id", quality = 720, headers = mapOf("Referer" to "https://www.cnnindonesia.com/")),
        CategorizedChannel("BN Channel", "https://flv.intechmedia.net/live/ch112.m3u8", "Berita", quality = 720),
        CategorizedChannel("BeritaSatu", "https://op-group1-swiftservehd-1.dens.tv/h/h209/index.m3u8", "Berita", quality = 720, headers = mapOf("User-Agent" to DENS_UA, "Referer" to "http://dens.tv")),
        CategorizedChannel("Astro Blitar TV", "https://5bf7b725107e5.streamlock.net/abtv/abtv/playlist.m3u8", "Berita", quality = 720),
        // Sports → Olahraga
        CategorizedChannel("FIFA World Cup 1", "https://1nyaler.streamhostingcdn.top/stream/23/index.m3u8", "Olahraga", quality = 720),
        CategorizedChannel("FIFA World Cup 4", "https://1nyaler.streamhostingcdn.top/stream/32/index.m3u8", "Olahraga", quality = 720),
        CategorizedChannel("FIFA World Cup 5", "https://dfr80qz435crc.cloudfront.net/MNOP/Amagi/Caze/Caze_TV_BR/Caze_TV.m3u8", "Olahraga", quality = 720),
        CategorizedChannel("BEIN Sports", "https://amg01334-beinsportsllc-beinxtra-localnow-kcy6r.amagi.tv/playlist.m3u8", "Olahraga", quality = 720),
        CategorizedChannel("Real Madrid TV", "https://rmtv.akamaized.net/hls/live/2043153/rmtv-es-web/master.m3u8?hdnea=exp=1653452799~acl=*~hmac=6fa983776826e1224ab4c19996ce92f00a1ad234617b07fd8a398160d72c19e0", "Olahraga", quality = 720),
        CategorizedChannel("Redbull TV", "https://rbmn-live.akamaized.net/hls/live/590964/BoRB-AT/master.m3u8", "Olahraga", quality = 720),
        CategorizedChannel("MLB", "https://d1yqxv6gx128ca.cloudfront.net/v1/master/3722c60a815c199d9c0ef36c5b73da68a62b09d1/cc-mmpgjr4zitcp0/playlist.m3u8", "Olahraga", quality = 720),
        CategorizedChannel("UFC TV", "https://aegis-cloudfront-1.tubi.video/a78ea283-8666-44a1-a0f6-fde5d229ac21/playlist_1920x1080.m3u8", "Olahraga", quality = 720),
        // Religious → Religi
        CategorizedChannel("Rodja TV", "https://wahyu1ptv.pages.dev/RodjaTV-HD.m3u8", "Religi", tvgId = "RodjaTV.id", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("TV Mu", "https://e.siar.us/live/tvmu.m3u8", "Religi", quality = 720),
        CategorizedChannel("DAAI TV", "https://op-group1-swiftservesd-1.dens.tv/s/s182/S4/mnf.m3u8", "Religi", quality = 720),
        CategorizedChannel("Astha TV", "https://hgmtv.com:19360/asthatv/asthatv.m3u8", "Religi", quality = 720),
        CategorizedChannel("Dhamma TV", "https://b.webcache.maxindo.net.id/dhamma/dhamma.m3u8", "Religi", quality = 720),
        CategorizedChannel("MQ TV", "https://wahyu1ptv.pages.dev/MQTV-HD.m3u8", "Religi", quality = 720),
        CategorizedChannel("Sakti TV", "https://saktitv.siar.us/saktitv/live/playlist.m3u8", "Religi", quality = 720),
        CategorizedChannel("Al Wafa Tarim", "https://ammedia.siar.us/ammedia/live/playlist.m3u8", "Religi", quality = 720),
        CategorizedChannel("BRTV", "https://5bf7b725107e5.streamlock.net/brtv/brtv/playlist.m3u8", "Religi", quality = 720),
        CategorizedChannel("DMI TV", "https://tvstreamcast.com/tawaftv.m3u8", "Religi", quality = 720),
        CategorizedChannel("I Am Channel", "https://61146e7ab7a66.streamlock.net:8089/tes/1/chunklist.m3u8", "Religi", quality = 720),
        // Music → Musik
        CategorizedChannel("Ibiza TV", "https://wahyu1ptv.pages.dev/Ibiza.m3u8", "Musik", quality = 720),
        CategorizedChannel("Deluxe Music", "https://sdn-global-live-streaming-packager-cache.3qsdn.com/13456/13456_264_live.m3u8", "Musik", quality = 720),
        CategorizedChannel("Vevo Music", "https://d1s6jz7jeei17.cloudfront.net/playlist/amg00056-vevotv-vevo2kau-samsungau/playlist.m3u8", "Musik", quality = 720),
        CategorizedChannel("Music Information Channel", "https://mic.siar.us/mic/live/mic.m3u8", "Musik", quality = 720),
        // Regional → Daerah
        CategorizedChannel("Kilisuci TV", "https://5bf7b725107e5.streamlock.net/kstv/kstv/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("TV9 Nusantara", "https://5bf7b725107e5.streamlock.net/tv9/tv9/playlist.m3u8", "Daerah", quality = 480),
        CategorizedChannel("Duta TV", "https://dutatv.siar.us/dutatv/live/playlist.m3u8", "Daerah", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("Banjar TV", "https://banjartv.siar.us/banjartv/live/playlist.m3u8", "Daerah", quality = 720, headers = mapOf("User-Agent" to EXO_UA)),
        CategorizedChannel("Banten TV", "https://5bf7b725107e5.streamlock.net/bantentv/bantentv/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Bungo TV", "https://5bf7b725107e5.streamlock.net/bungotv/bungotv/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("TVKU", "https://tvku.tv/hlsstream/hls/live.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Caruban TV", "https://stream.carubantv.id/hls/0/stream.m3u8", "Daerah", quality = 720, headers = mapOf("Referer" to "https://stream.carubantv.id")),
        CategorizedChannel("Dhoho TV", "https://dhohotv.siar.us/dhohotv/live/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Efarina TV", "https://live.efarinatv.com/hls/bgtaufikganteng.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Madu TV", "https://re1.siar.us/madutv/hd720/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("TATV", "https://tatv.siar.us/tatv/live.sdp/playlist.m3u8", "Daerah", quality = 720),
        CategorizedChannel("Persiana Jr", "https://junhls.persiana.live/hls/stream.m3u8", "International", quality = 720),
        CategorizedChannel("Persiana Cinema", "https://cinehls.persiana.live/hls/stream.m3u8", "International", quality = 720),
        CategorizedChannel("Moviesphere", "https://moviesphereuk-samsunguk.amagi.tv/playlist.m3u8", "International", quality = 720),
        CategorizedChannel("Moviedome", "https://cdn-ue1-prod.tsv2.amagi.tv/linear/amg00771-kochfilmsgerman-moviedomefamily-tcl/playlist.m3u8", "International", quality = 720),
        CategorizedChannel("Brat TV", "https://brat-samsung-us.amagi.tv/playlist.m3u8", "International", quality = 720)
    )
}
