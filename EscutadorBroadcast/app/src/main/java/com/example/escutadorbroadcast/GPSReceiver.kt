package com.example.escutadorbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.util.Log
import android.widget.Toast

class GPSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        var manager: LocationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGPSEnabled = manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (isGPSEnabled) {
            Toast.makeText(context, "GPS ligado", Toast.LENGTH_LONG)
            Log.i("APP_GPS", "foi")
        } else {
            Toast.makeText(context, "nada aconteceu", Toast.LENGTH_LONG)
            Log.i("APP_GPS", "nada")
        }
    }
}
