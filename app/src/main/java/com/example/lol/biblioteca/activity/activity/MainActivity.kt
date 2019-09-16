package com.example.lol.biblioteca.activity.activity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lol.biblioteca.R
import com.example.lol.biblioteca.activity.classes.DataBase
import com.example.lol.biblioteca.activity.classes.Listalivros
import com.example.lol.biblioteca.activity.objects.Util
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnCadastrarLivro
import kotlinx.android.synthetic.main.cadastrolivro_activity.*

//CLASSE PARA A ACTIVTY DE LOGIN

class MainActivity : AppCompatActivity() {

    private val  NEXT_ACTIVITY_REQUEST_CODE = 1
    private lateinit var login:EditText
    private lateinit var senha :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var buttonLog = findViewById<Button>(R.id.buttonLogin)
        login = findViewById<EditText>(R.id.editTextLogin)
        senha = findViewById<EditText>(R.id.editTextsenha)

        buttonLogin.setOnClickListener {
            var login = login?.text.toString()
            var senha = senha?.text.toString()
            consultarLivros()

            if (login.toLowerCase() == "login" && senha == "12345678") {

                val params = Bundle()
                params.putString("usuario", login)
                val intent = Intent(this, Livros::class.java)
                intent.putExtras(params)
                startActivity(intent)

            } else {
                Toast.makeText(this, "login e/ou senha incorretos", Toast.LENGTH_LONG).show()
            }

        }

        btnCadastrarLivro.setOnClickListener{
            val nextIntent = Intent(this, CadastrarLivro::class.java)
            startActivity(nextIntent)
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
    private fun consultarLivros() {
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
                    Util.showMessage(this, "Não há alunos para exibir!")

                }
            }?.addOnFailureListener {
                progressBar.visibility = View.GONE
                Util.showMessage(this, "Houve um erro na consulta de alunos!")
            }
        } else {
            Util.showMessage(this, "Sem conexão com a internet.")
        }
    }
}


