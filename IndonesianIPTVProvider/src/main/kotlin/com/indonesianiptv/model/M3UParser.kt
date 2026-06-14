package com.indonesianiptv.model

object M3UParser {
    fun parse(content: String): List<M3UChannel> {
        val channels = mutableListOf<M3UChannel>()
        val lines = content.lines()
        var i = 0

        while (i < lines.size) {
            val line = lines[i].trim()

            if (line.startsWith("#EXTINF:")) {
                val tvgId = extractAttr(line, "tvg-id")
                val tvgLogo = extractAttr(line, "tvg-logo")
                val group = extractAttr(line, "group-title")
                val quality = extractQuality(line)
                val channelName = extractName(line)

                val headers = mutableMapOf<String, String>()
                i++
                var streamUrl = ""

                while (i < lines.size) {
                    val l = lines[i].trim()
                    when {
                        l.startsWith("#EXTVLCOPT:http-referrer") ->
                            headers["Referer"] = l.substringAfter("=").trim()
                        l.startsWith("#EXTVLCOPT:http-user-agent") ->
                            headers["User-Agent"] = l.substringAfter("=").trim()
                        l.startsWith("#EXTVLCOPT:") -> { /* skip other options */ }
                        l.startsWith("#KODIPROP:") -> { /* skip DRM props */ }
                        l.startsWith("#") || l.isEmpty() -> { /* skip */ }
                        else -> {
                            streamUrl = l
                            break
                        }
                    }
                    i++
                }

                if (streamUrl.isNotEmpty() &&
                    !streamUrl.startsWith("#") &&
                    (streamUrl.startsWith("http://") || streamUrl.startsWith("https://") || streamUrl.startsWith("rtmp://"))
                ) {
                    channels.add(M3UChannel(
                        name = channelName,
                        streamUrl = streamUrl,
                        tvgId = tvgId,
                        tvgLogo = tvgLogo,
                        group = group,
                        quality = quality,
                        headers = headers
                    ))
                }
            }
            i++
        }

        return channels
    }

    private fun extractAttr(line: String, attr: String): String? {
        val match = Regex("""$attr="([^"]*)"""").find(line)
        return match?.groupValues?.getOrNull(1)?.takeIf { it.isNotEmpty() }
    }

    private fun extractQuality(line: String): String? {
        val match = Regex("""\((\d+p)\)""").find(line)
        return match?.groupValues?.getOrNull(1)
    }

    private fun extractName(line: String): String {
        val raw = line.substringAfterLast(",").trim()
        return raw.replace(Regex("""\s*\(\d+p\)"""), "")
            .replace(Regex("""\s*\[.*?]"""), "")
            .replace(Regex("""\s*-\s*\d+p"""), "")
            .trim()
    }
}
