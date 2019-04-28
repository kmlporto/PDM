package com.example.ochamadordologador

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvChamador: TextView
    val LOGADOR = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent("LOGADOR")
        startActivityForResult(intent, LOGADOR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == LOGADOR){
            //só irá iniciar a view chamanda na intent caso a condição seja atendida
            setContentView(R.layout.activity_main)
            this.tvChamador = findViewById(R.id.tvChamador)

            val st = data?.getStringExtra("LOGIN")
            this.tvChamador.text = st
        }else{
            finish()
        }
    }
}
