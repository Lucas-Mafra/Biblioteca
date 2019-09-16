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

    /* private fun consultarLivros() {
        if (Util.isDeviceConnected(this)) {
            val task = DataBase().consultar("Biblioteca")
            val listaLivros = ArrayList<Listalivros>()
            progressBar.visibility = View.VISIBLE
            task?.addOnSuccessListener { result ->
                progressBar.visibility = View.GONE
                if (result != null) {
                    result.forEach() {
                        var aluno = Listalivros(
                            it.data["avatar"].toString().toInt(),
                            it.data["TituloLivro"].toString(),
                            it.data["AutorLivro"].toString(),
                            it.data["txtEditora"].toString(),
                            it.data["txtAnoPublicaca"].toString(),
                            it.id
                        )
                        listaLivros.add(aluno)
                    }
                    val intent = Intent(this, Livros::class.java)
                    intent.putExtra("Biblioteca", listaLivros)
                    startActivity(intent)
                } else {
                    showMessage(this, "Não há alunos para exibir!")

                }
            }?.addOnFailureListener {
                progressBar.visibility = View.GONE
                showMessage(this, "Houve um erro na consulta de alunos!")
            }
        } else {
            showMessage(this, "Sem conexão com a internet.")
        }
    }
*/
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
                avatar,
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
