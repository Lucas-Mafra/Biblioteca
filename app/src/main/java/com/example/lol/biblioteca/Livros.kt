package com.example.lol.biblioteca

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.livros_activity.*

//A RV EM SI

class Livros : AppCompatActivity() {

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.livros_activity)

        var lista = mutableListOf<Listalivros>()

        //adicionar dados na lsita
        /*
        var avatar = (R.drawable.avatar_android)
        for(i in 1..100){
            lista.add(Listalivros())
        }
        */

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(lista)

        rvLista.adapter = viewAdapter
        rvLista.layoutManager = viewManager

    }
}

