package com.example.lol.biblioteca.activity.classes

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


//DATA CLASS PARA O RV DOS LIVROS
@Parcelize
data class Listalivros( var titulo :String = "", var autor: String = "", var editora: String = "", var anoPublicacao: String = "", var id: String = ""): Parcelable {
}