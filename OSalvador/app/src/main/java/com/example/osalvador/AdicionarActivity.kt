package com.example.osalvador

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class AdicionarActivity : AppCompatActivity() {
    private lateinit var btConfirmar: Button
    private lateinit var etNome: EditText
    private lateinit var etNumero: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)

        this.etNome = findViewById(R.id.etNome)
        this.etNumero = findViewById(R.id.etIdade)
        this.btConfirmar = findViewById(R.id.btConfirmar)

        this.btConfirmar.setOnClickListener({adicionar(it)})

    }

    private fun adicionar(view: View){
        val nome = this.etNome.text.toString()
        val idade = this.etNumero.text.toString()
        intent.putExtra("nome", nome)
        intent.putExtra("idade", idade)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
