package activity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lol.biblioteca.R
import kotlinx.android.synthetic.main.activity_main.*

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

            if (login.toLowerCase() == "luizmiguel" && senha == "12345678") {

                val params = Bundle()
                params.putString("usuario", login)
                val intent = Intent(this, Activity.Livros::class.java)
                intent.putExtras(params)
                startActivity(intent)

            } else {
                Toast.makeText(this, "login e/ou senha incorretos", Toast.LENGTH_LONG).show()
            }

        }

        CadastroAi.setOnClickListener{
            val nextIntent = Intent(this, Activity.Cadastro::class.java)
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
}

