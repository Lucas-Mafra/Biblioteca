package com.example.lol.biblioteca.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lol.biblioteca.R
import com.example.lol.biblioteca.activity.classes.Listalivros
import kotlinx.android.synthetic.main.lista_livros.view.*

class MyAdapter(var lista : MutableList<Listalivros>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.lista_livros, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.capa.setImageResource(lista[position].capa)
        holder.titulo.text = lista[position].titulo
        holder.autor.text = lista[position].autor
        holder.editora.text = lista[position].editora
        holder.ano.text = lista[position].anoPublicacao

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var capa = itemView.imgCapa
        var titulo = itemView.txtTitulo
        var autor = itemView.txtAutor
        var editora = itemView.txtEditora
        var ano = itemView.txtAnoPublicacao
        var listaView = itemView.viewLista
    }
}