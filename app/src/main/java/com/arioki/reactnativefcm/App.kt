package com.arioki.reactnativefcm

import android.app.Application
import android.content.Context

/**
 * Created on : 19/04/20
 * Author     : arioki
 * Name       : Yoga Setiawan
 * GitHub     : https://github.com/arioki
 */
class App : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}