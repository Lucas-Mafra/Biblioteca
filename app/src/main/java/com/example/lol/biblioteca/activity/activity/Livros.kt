package com.example.lol.biblioteca.activity.activity

import android.content.Intent
import android.os.Bundle
import com.example.lol.biblioteca.activity.adapter.MyAdapter
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lol.biblioteca.R
import com.example.lol.biblioteca.activity.classes.Listalivros
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


/*
        Mostrar na RV
        var avatar = (R.drawable.capa)
        for(i in 1..100){
            lista.add(Listalivros( avatar , "Bom titulo $i", "Bom autor $i", "editora boa $i", "$i" ))
        }
*/
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(lista)

        rvLista.adapter = viewAdapter
        rvLista.layoutManager = viewManager

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

/*
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId==R.id.menu_Search){

        }
    }
*/
}

