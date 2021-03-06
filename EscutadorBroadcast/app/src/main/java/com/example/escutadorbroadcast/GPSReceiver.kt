package com.example.escutadorbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.util.Log
import android.widget.Toast

class GPSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action == LocationManager.PROVIDERS_CHANGED_ACTION) {
            Toast.makeText(context, "GPS ligado", Toast.LENGTH_SHORT).show()
            Log.i("APP_GPS", "foi")
        } else {
            Toast.makeText(context, "nada aconteceu", Toast.LENGTH_SHORT).show()
            Log.i("APP_GPS", "nada")
        }

    }

}
