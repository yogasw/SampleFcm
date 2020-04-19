package com.arioki.reactnativefcm

import android.content.Context

/**
 * Created on : 19/04/20
 * Author     : arioki
 * Name       : Yoga Setiawan
 * GitHub     : https://github.com/arioki
 */

object FcmPref {
    private val pref = App.context.getSharedPreferences("FCM_SERVICE", Context.MODE_PRIVATE)
    private val edit = pref.edit()

    fun setOpenActivity(status: Boolean) = edit.putBoolean("OpenActivity", status).commit()
    fun getOpenActivity() = pref.getBoolean("OpenActivity", false)
}