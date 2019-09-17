package com.example.lol.biblioteca.activity.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lol.biblioteca.R
import com.example.lol.biblioteca.activity.adapter.MyAdapter
import com.example.lol.biblioteca.activity.classes.Listalivros
import kotlinx.android.synthetic.main.livros_activity.*

//A RV EM SI

class Livros : AppCompatActivity() {

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var listalivros: ArrayList<Listalivros>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.livros_activity)
        setSupportActionBar(findViewById(R.id.Toolbar_Livros))
        title = "Livros da biblioteca"

        listalivros = intent.getParcelableArrayListExtra<Listalivros>("ListaLivro")
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(listalivros)

        rvLista.adapter = viewAdapter
        rvLista.layoutManager = viewManager

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId==R.id.menu_CadastrarLivro){
            val intent = Intent(this, CadastrarLivro::class.java)
            startActivity(intent)
        }
        return true
    }


}

