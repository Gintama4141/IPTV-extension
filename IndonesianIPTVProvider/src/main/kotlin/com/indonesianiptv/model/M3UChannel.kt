package com.indonesianiptv.model

data class M3UChannel(
    val name: String,
    val streamUrl: String,
    val tvgId: String? = null,
    val tvgName: String? = null,
    val tvgLogo: String? = null,
    val group: String? = null,
    val quality: String? = null,
    val headers: Map<String, String> = emptyMap()
)
