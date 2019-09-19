package com.example.lol.biblioteca.activity.activity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lol.biblioteca.R
import com.example.lol.biblioteca.activity.classes.DataBase
import com.example.lol.biblioteca.activity.classes.Listalivros
import com.example.lol.biblioteca.activity.objects.Util
import com.example.lol.biblioteca.activity.objects.Util.showMessage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cadastrolivro_activity.*
import android.widget.Button as Button

//CLASSE PARA A ACTIVTY DE LOGIN

class MainActivity : AppCompatActivity() {

    private val  NEXT_ACTIVITY_REQUEST_CODE = 1
    private lateinit var login:EditText
    private lateinit var senha :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.editTextLogin)
        senha = findViewById(R.id.editTextsenha)

        buttonLogin.setOnClickListener {
            var login = login?.text.toString()
            var senha = senha?.text.toString()

            if (login == "login" && senha == "12345678") {

                val params = Bundle()
                params.putString("usuario", login)
                val intent = Intent(this, Livros::class.java)
                intent.putExtras(params)
                consultarLivros(intent)

            } else {
                Toast.makeText(this, "login e/ou senha incorretos", Toast.LENGTH_LONG).show()
            }
        }

        CadastroAi.setOnClickListener{
            val nextIntent = Intent(this, Cadastro::class.java)
            startActivity(nextIntent)
        }

        fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {

            if (resultCode == Activity.RESULT_OK) {

                if (requestCode == 1 && intent != null) {

                    login?.setText(intent.getStringExtra("loginCadastro"))
                    senha?.setText(intent.getStringExtra("senhaCadastro"))
                }
            }
        }
    }
    private fun consultarLivros(intent: Intent){

        val listaLivros = ArrayList<Listalivros>()

        if (Util.isDeviceConnected(this)) {

            val task = DataBase().consultar("Biblioteca")

            task?.addOnSuccessListener { result ->

                if (result != null) {
                    result.forEach {

                        val livro = Listalivros(
                            it.data["titulo"].toString(),
                            it.data["autor"].toString(),
                            it.data["editora"].toString(),
                            it.data["anoPublicacao"].toString(),
                            it.id
                        )
                        listaLivros.add(livro)

                    }

                    intent.putExtra("ListaLivro", listaLivros)
                    startActivity(intent)
                } else {
                    Util.showMessage(this, "Não há alunos para exibir!")

                }
            }?.addOnFailureListener {
                Util.showMessage(this, "Houve um erro na consulta de alunos!")
            }
        } else {
            Util.showMessage(this, "Sem conexão com a internet.")
        }

        Log.d("resultconsulta1", listaLivros.size.toString())
    }
}


