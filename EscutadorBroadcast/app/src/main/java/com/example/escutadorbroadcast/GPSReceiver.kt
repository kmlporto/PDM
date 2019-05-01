package com.example.escutadorbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.provider.ContactsContract
import android.widget.Toast
import android.R.bool
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v4.content.ContextCompat.getSystemService





class GPSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        //}
        //val manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        //val isOn = manager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
        //if (Context.LOCATION_SERVICE.toBoolean()){
        //    Toast.makeText(context, "GPS ligado", Toast.LENGTH_LONG)
        if(intent.action == Intent.ACTION_LOCALE_CHANGED){
            Toast.makeText(context, "GPS ligado", Toast.LENGTH_LONG)
        }else{
            Toast.makeText(context, "nada aconteceu", Toast.LENGTH_LONG)
        }

    }
}
