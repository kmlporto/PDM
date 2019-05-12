package com.example.osalvador

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class UpdateActivity : AppCompatActivity() {
    private lateinit var dao: PessoaDAO
    private lateinit var id: String
    private lateinit var nome: String
    private lateinit var idade:String

    private lateinit var tvId: TextView
    private lateinit var etUpdateNome: EditText
    private lateinit var etUpdadeIdade: EditText
    private lateinit var btAtualizar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        dao = PessoaDAO(this@UpdateActivity)

        this.id = intent.getStringExtra("id")
        this.tvId = findViewById(R.id.tvId)
        this.tvId.text = this.id

        this.nome = intent.getStringExtra("nome")
        this.etUpdateNome = findViewById(R.id.etUpdateNome)
        this.etUpdateNome.setText(this.nome)

        this.idade = intent.getStringExtra("idade")
        this.etUpdadeIdade = findViewById(R.id.etUpdateIdade)
        this.etUpdadeIdade.setText(this.idade)

        this.btAtualizar = findViewById(R.id.btAtualizar)
        this.btAtualizar.setOnClickListener({atualizar(it)})
    }

    private fun atualizar(view: View){
        val id = tvId.text.toString().toInt()
        val nome = etUpdateNome.text.toString()
        val idade = etUpdadeIdade.text.toString().toInt()
        val p = Pessoa(id, nome, idade)
        dao.update(p)
        setResult(Activity.RESULT_OK, this@UpdateActivity.intent)
        finish()
    }
}
