package com.example.osalvador

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var dao: PessoaDAO
    private lateinit var btChamarAdd: ImageButton
    private lateinit var lvContatos: ListView
    val ADICIONAR = 1
    val UPDATE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = PessoaDAO(this)

        this.btChamarAdd = findViewById(R.id.btChamarAdd)
        this.btChamarAdd.setOnClickListener({chamarAdd(it)})

        this.lvContatos = findViewById(R.id.lvContatos)
        this.lvContatos.adapter = ArrayAdapter<Pessoa>(
            this@MainActivity, android.R.layout.simple_list_item_1, dao.get())
        this.lvContatos.setOnItemClickListener(atualizarPessoa())

    }

    private fun chamarAdd(view: View){
        //primeiro parametro é activity que chama, a segunda é a que é chamada
        val intent = Intent(this@MainActivity, AdicionarActivity::class.java)
        startActivityForResult(intent, ADICIONAR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == ADICIONAR && resultCode == RESULT_OK) {
            var nome = intent.getStringExtra("nome")
            var numero = intent.getStringExtra("numero").toInt()
            dao.insert(Pessoa(nome, numero))
            Toast.makeText(this@MainActivity, "Pessoa ${nome} criada", Toast.LENGTH_SHORT).show()
            Log.i("App_Pessoa", dao.get().toString())
        }else if(resultCode == UPDATE && resultCode == RESULT_OK) {
            Toast.makeText(this@MainActivity, "Pessoa atualizada!", Toast.LENGTH_SHORT).show()
        }
    }

    inner class atualizarPessoa: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val pessoa = dao.get(position+1)

            Log.i("App_Pessoa", "Id: ${pessoa!!.id} - Nome: ${pessoa.nome} - Idade: ${pessoa.idade}")
            Toast.makeText(this@MainActivity, "Id: ${pessoa!!.id} - Nome: ${pessoa.nome} - Idade: ${pessoa.idade}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, UpdateActivity::class.java)
            intent.putExtra("id", pessoa.id.toString())
            intent.putExtra("nome", pessoa.nome)
            intent.putExtra("idade", pessoa.idade)
            startActivityForResult(intent, UPDATE)
        }
    }
}
