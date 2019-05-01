package com.example.escutadorbroadcast

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var status: TextView
    private lateinit var receiver: GPSReceiver
    private lateinit var itf: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.status = findViewById(R.id.tvStatus)

        this.receiver = GPSReceiver()
        this.itf = IntentFilter()
        this.itf.addAction(Intent.ACTION_USER_PRESENT)

    }

    override fun onResume() {
        super.onResume()
        registerReceiver(this.receiver, this.itf)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(this.receiver)
    }

}
