package com.indonesianiptv

import android.content.Context
import com.indonesianiptv.provider.IndonesiaTVProvider
import com.indonesianiptv.provider.InternationalTVProvider
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class IndonesianIPTVPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(IndonesianIPTVProvider())
        registerMainAPI(IndonesiaTVProvider())
        registerMainAPI(InternationalTVProvider())
    }
}
