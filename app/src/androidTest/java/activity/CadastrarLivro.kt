package activity

import objects.Util
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import classes.Listalivros
import com.example.lol.biblioteca.R
import kotlinx.android.synthetic.main.cadastrolivro_activity.*
import kotlinx.android.synthetic.main.lista_livros.*


class CadastrarLivro: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastrolivro_activity)
        btnCadastrarLivro.setOnClickListener{
        }
    }

    private fun salverLivro() {

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
                txtAnoPublicacao.text.toString(),
                id
            )
        }

        if (Util.isDeviceConnected(this)){
            progressBar.visibility = View.VISIBLE


        }




    }






    private fun clearFields() {
        txtEditTituloLivro.text!!.clear()
        txtEditAnoPublicacao.text!!.clear()
        txtEditAutorLivro.text!!.clear()
        txtEditEditora.text!!.clear()
    }

    private fun verifyInputs(): Boolean {

        var isValidInput = true

        if (txtEditTituloLivro.text.toString().trim().isEmpty()) {
            txtInputTituloLivro.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        if (txtEditAnoPublicacao.text.toString().trim().isEmpty()){
            txtInputAnoPublicacao.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        if(txtEditAutorLivro.text.toString().trim().isEmpty()){
            txtInputAutorLivro.error = "O campo não pode ser vazio!"
            isValidInput = false
        }
        if(txtEditEditora.text.toString().trim().isEmpty()){
            txtInputEditora.error = "O campo não pode ser vazio!"
        }

        return isValidInput
    }
}