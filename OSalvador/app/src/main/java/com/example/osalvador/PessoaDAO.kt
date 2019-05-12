package com.example.osalvador

import android.content.ContentValues
import android.content.Context

class PessoaDAO{
    private lateinit var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(p: Pessoa){
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("idade", p.idade)
        this.banco.writableDatabase.insert("pessoa", null, cv)
    }

    fun get(): List<Pessoa>{
        val colunas = arrayOf("id", "nome", "idade")
        val lista = arrayListOf<Pessoa>()

        val c = this.banco.readableDatabase.query("pessoa", colunas, null, null, null, null, "nome")

        c.moveToFirst()

        if(c.count > 0){
            do{
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val idade = c.getInt(c.getColumnIndex("idade"))
                lista.add(Pessoa(id, nome, idade))
            }while(c.moveToNext())
        }

        return lista
    }

    fun get(index: Int): Pessoa?{
        val colunas = arrayOf("id", "nome", "idade")

        val where = "id = ?"
        val pwhere = arrayOf(index.toString())

        val c = this.banco.readableDatabase.query("pessoa", colunas, where, pwhere, null, null, null)

        c.moveToFirst()

        if(c.count > 0){
            val id = c.getInt(c.getColumnIndex("id"))
            val nome = c.getString(c.getColumnIndex("nome"))
            val idade = c.getInt(c.getColumnIndex("idade"))
          return (Pessoa(id, nome, idade))
        }
        return null
    }

    fun update(p:Pessoa){
        val where = "id = ?"
        val pwhere = arrayOf(p.id.toString())
        val cv = ContentValues()
        cv.put("id", p.id)
        cv.put("nome", p.nome)
        cv.put("idade", p.idade)
        this.banco.writableDatabase.update("pessoa", cv, where, pwhere)
    }

    fun delete(id: Int){
        val where = "id = ?"
        val pwhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("pessoa", where, pwhere)
    }
}