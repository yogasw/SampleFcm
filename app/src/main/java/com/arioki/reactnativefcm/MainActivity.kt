package com.arioki.reactnativefcm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startService()
        FcmPref.setOpenActivity(false)
    }

    private fun startService() {
        val intent = Intent(this, ServiceActivity::class.java)
        ContextCompat.startForegroundService(this, intent)
    }
}
