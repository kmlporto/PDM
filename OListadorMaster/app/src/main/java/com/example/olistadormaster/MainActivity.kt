package com.example.olistadormaster

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.view.ActionMode
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var btHTML: Button
    private lateinit var btDiscar: Button
    private lateinit var btLigar: Button
    private lateinit var btEmail: Button
    private lateinit var btSMS: Button
    private lateinit var btCompText:Button
    private lateinit var btPonto: Button
    private lateinit var btRota: Button
    private lateinit var btYouTube:Button
    private lateinit var btFoto: Button
    private lateinit var ivPhoto:ImageView

    val CAMERA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHTML = findViewById(R.id.btHTML)
        this.btDiscar = findViewById(R.id.btDiscar)
        this.btLigar = findViewById(R.id.btLigar)
        this.btEmail = findViewById(R.id.btEmail)
        this.btSMS = findViewById(R.id.btSMS)
        this.btCompText = findViewById(R.id.btCompText)
        this.btPonto = findViewById(R.id.btPonto)
        this.btRota = findViewById(R.id.btRota)
        this.btYouTube = findViewById(R.id.btYouTube)
        this.btFoto = findViewById(R.id.btFoto)


        this.btHTML.setOnClickListener({html(it)})
        this.btDiscar.setOnClickListener({discar(it)})
        this.btLigar.setOnClickListener({ligar(it)})
        this.btEmail.setOnClickListener({email(it)})
        this.btSMS.setOnClickListener({sms(it)})
        this.btCompText.setOnClickListener({comptexto(it)})
        this.btPonto.setOnClickListener({ponto(it)})
        this.btRota.setOnClickListener({rota(it)})
        this.btYouTube.setOnClickListener({youtube(it)})
        this.btFoto.setOnClickListener({foto(it)})
    }

    fun html(view: View){
        val uri = Uri.parse("mailto:valeria.cavalcanti@ifpb.edu.br")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun discar(view: View){
        val uri = Uri.parse("tel:999999999")
        val it = Intent(Intent.ACTION_DIAL, uri)
        startActivity(it)
    }

    fun ligar(view: View){
        val uri = Uri.parse("tel:999999999")
        val it = Intent(Intent.ACTION_CALL, uri)
        val call = android.Manifest.permission.CALL_PHONE
        val granted = PackageManager.PERMISSION_GRANTED
        if (ContextCompat.checkSelfPermission(this, call)== granted){
            startActivity(it)
        }
    }

    fun email(view: View){
        var uri = Uri.parse("mailto:milafreitasporto@hotmail.com")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra(Intent.EXTRA_TEXT, "Texto")
        it.putExtra(Intent.EXTRA_SUBJECT, "Assunto")
        startActivity(it)
    }

    fun sms(view: View){
        val uri = Uri.parse("sms:999999999")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra("sms_body", "Mensagem")
        startActivity(it)
    }

    fun comptexto(view:View){
        val it = Intent(Intent.ACTION_SEND)
        it.setType("text/plain")
        it.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar")
        startActivity(Intent.createChooser(it, "Compartilhar"))
    }

    fun rota(view:View){
        val origem = "-7.1356496, -34.8760932"
        val destino = "-7.1181836, -34.8730402"
        val url = "http://maps.google.com/maps"
        val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun ponto(view:View){
        val ponto = "-7.1356496, -34.8760932"
        val url = "http://maps.google.com/maps"
        val uri = Uri.parse("${url}?f=&saddr=${ponto}")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun youtube(view: View){
       val uri = Uri.parse("vnd.youtube://WynqjLHzUd8?list=RDEM6TKhSewB-E-xEqGKqiXwbQ")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun foto(view:View){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{
            takePictureIntent -> takePictureIntent.resolveActivity(packageManager)?.also{
                startActivityForResult(takePictureIntent, CAMERA)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA && resultCode == RESULT_OK ){
            setContentView(R.layout.photo)
            this.ivPhoto = findViewById(R.id.ivPhoto)
            val imageBitmap = data?.extras!!.get("data") as Bitmap
            this.ivPhoto.setImageBitmap(imageBitmap)
        }
    }
}
