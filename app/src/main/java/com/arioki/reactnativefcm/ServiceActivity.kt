package com.arioki.reactnativefcm

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log

/**
 * Created on : 19/04/20
 * Author     : arioki
 * Name       : Yoga Setiawan
 * GitHub     : https://github.com/arioki
 */
class ServiceActivity : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val ha = Handler()
        ha.postDelayed(object : Runnable {
            override fun run() {
                Log.d("LOG_APP", "start activity ${FcmPref.getOpenActivity()}")
                if (FcmPref.getOpenActivity()) {
                    FcmPref.setOpenActivity(false)
             /*       val intent = Intent(App.context, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)*/

                }
                ha.postDelayed(this, 1000)
            }
        }, 10000)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}