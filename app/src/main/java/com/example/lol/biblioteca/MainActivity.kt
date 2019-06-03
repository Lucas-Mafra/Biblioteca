package com.example.lol.biblioteca
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val  NEXT_ACTIVITY_REQUEST_CODE = 1
    private var Login = editTextLogin
    private var senha = editTextsenha
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var buttonLog = findViewById<Button>(R.id.buttonLogin)
        Login = findViewById<EditText>(R.id.editTextLogin)
        senha = findViewById<EditText>(R.id.editTextsenha)

        buttonLogin.setOnClickListener {

            var login = Login?.text.toString()
            var senha = senha?.text.toString()

            if (login.toLowerCase() == "Luizmiguel" && senha == "12345678") {

                val params = Bundle()
                params.putString("usuario", login)
                intent.putExtras(params)
                startActivity(intent)

            } else {
                Toast.makeText(this, "login e/ou senha incorretos", Toast.LENGTH_LONG).show()
            }

        }
        CadastroAi.setOnClickListener{
            val nextIntent = Intent(this, Cadastro::class.java)
        }
        fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {

            if (resultCode == Activity.RESULT_OK) {

                if (requestCode == 1 && intent != null) {

                    Login?.setText(intent.getStringExtra("loginCadastro"))
                    senha?.setText(intent.getStringExtra("senhaCadastro"))
    }}


