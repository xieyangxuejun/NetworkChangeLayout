package com.foretree.networklistenerlayout

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by silen on 01/11/2017.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}