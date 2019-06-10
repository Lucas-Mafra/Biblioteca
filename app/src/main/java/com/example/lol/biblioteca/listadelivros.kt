package com.example.lol.biblioteca

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.cadastro_activity.*

class listadelivros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listadelivros_activity)

        val lista = arrayOf<String>(
            "Livro de Português",
            "Livro de Português2",
            "Livro de Português3",
            "Livro de Português4",
            "Livro de Português5",
            "Livro de Português6",
            "Livro de Português7",
            "Livro de Português8",
            "Livro de Português9",
            "Livro de Português10",
            "Livro de Português11"
        )
        val itemsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista)
        val lv: ListView = findViewById(R.id.lista)
        lv.adapter = itemsAdapter
        lv.onItemClickListener = (AdapterView.OnItemClickListener { parent, view, position, id ->

            when (position) {
                0 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                1 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                2 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                3 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                4 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                5 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                6 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                7 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                8 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                9 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)
                10 -> mostrarDados(" - Livro exemplo de dado :)", lista, position)

            }
        })

    }

    fun mostrarDados(texto: String, lista: Array<String>, position: Int) {
        Toast.makeText(this, lista.get(position) + texto, Toast.LENGTH_LONG).show()
    }
}


