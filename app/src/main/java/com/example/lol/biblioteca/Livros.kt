package com.example.lol.biblioteca


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.livros_activity.*

//A RV EM SI

class Livros : AppCompatActivity() {

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.livros_activity)
        setSupportActionBar(findViewById(R.id.Toolbar_Livros))
        var lista = mutableListOf<Listalivros>()



        var avatar = (R.drawable.capa)
        for(i in 1..100){
            lista.add(Listalivros( avatar , "Bom titulo $i", "Bom autor $i", "EDITORA SHOW $i", "$i" ))
        }


        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(lista)

        rvLista.adapter = viewAdapter
        rvLista.layoutManager = viewManager

    }
}

