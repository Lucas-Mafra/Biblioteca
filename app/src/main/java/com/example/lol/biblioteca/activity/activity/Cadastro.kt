package com.example.lol.biblioteca.activity.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lol.biblioteca.R
import kotlinx.android.synthetic.main.cadastro_activity.*

//CLASS PARA A ACTIVITY DE CADASTRO

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_activity)
        buttonCadastro.setOnClickListener {

            if (loginCadastro.text.toString() != "" && senhaCadastro.text.toString() != "") {

                val intent = Intent()
                intent.putExtra("loginCadastro", loginCadastro.text.toString())
                intent.putExtra("senhaCadastro", senhaCadastro.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }


        }
    }
}