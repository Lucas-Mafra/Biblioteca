package com.example.lol.biblioteca.activity.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import com.example.lol.biblioteca.R
import com.example.lol.biblioteca.activity.classes.DataBase
import com.example.lol.biblioteca.activity.classes.Listalivros
import com.example.lol.biblioteca.activity.objects.Util
import com.example.lol.biblioteca.activity.objects.Util.showMessage
import kotlinx.android.synthetic.main.cadastrolivro_activity.*
import kotlinx.android.synthetic.main.lista_livros.*


class CadastrarLivro: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastrolivro_activity)
        btnCadastrarLivro.setOnClickListener {
            salvarLivro()
        }
    }

    private fun salvarLivro() {
        var avatar = (R.drawable.capa)
        var isValid: Boolean = verifyInputs()
        if (isValid) {
            val id = txtEditTituloLivro.text
                .toString()
                .trim()
                .toLowerCase()
                .substring(0, 1) + txtEditEditora.text
                .toString()
                .trim()
                .toLowerCase()
                .substring(0, txtEditEditora.text.toString().length)

            val livro = Listalivros(
                txtEditTituloLivro.text.toString(),
                txtEditAutorLivro.text.toString(),
                txtEditEditora.text.toString(),
                txtEditAnoPublicacao.text.toString(),
                id
            )

            if (Util.isDeviceConnected(this)) {
                progressBar.visibility = View.VISIBLE
                val task = DataBase().incluir("Biblioteca", id, livro)
                task.addOnCompleteListener { result ->
                    if (result.isSuccessful){
                        progressBar.visibility = View.GONE
                        showMessage(this,"Livro guardado")
                    }
                    else{
                        progressBar.visibility = View.GONE
                        showMessage(this,"Erro ao guardar o livro")
                    }

                }
            }
        }
        else{
            showMessage(this, "Erro ao conectar a internet")
        }
    }


        fun clearFields() {
            txtEditTituloLivro.text!!.clear()
            txtEditAnoPublicacao.text!!.clear()
            txtEditAutorLivro.text!!.clear()
            txtEditEditora.text!!.clear()
        }

        fun verifyInputs(): Boolean {

            var isValidInput = true

            if (txtEditTituloLivro.text.toString().trim().isEmpty()) {
                txtInputTituloLivro.error = "O campo não pode ser vazio!"
                isValidInput = false
            }

            if (txtEditAnoPublicacao.text.toString().trim().isEmpty()) {
                txtInputAnoPublicacao.error = "O campo não pode ser vazio!"
                isValidInput = false
            }

            if (txtEditAutorLivro.text.toString().trim().isEmpty()) {
                txtInputAutorLivro.error = "O campo não pode ser vazio!"
                isValidInput = false
            }
            if (txtEditEditora.text.toString().trim().isEmpty()) {
                txtInputEditora.error = "O campo não pode ser vazio!"
            }

            return isValidInput
        }
    }
