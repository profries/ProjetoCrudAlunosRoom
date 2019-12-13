package com.example.projetocrudalunosroom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.projetocrudalunosroom.model.Aluno


class DetalheActivity : AppCompatActivity() {

    companion object {

        const val RESULT_EDIT = 1
        const val RESULT_DELETE = 2
    }

    private lateinit var textoMatriculaDetalhe: EditText
    private lateinit var textoNomeDetalhe: EditText
    private lateinit var textoTelefoneDetalhe: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)
        val intent = intent
        val aluno = intent.getSerializableExtra("aluno") as Aluno

        textoMatriculaDetalhe = findViewById<EditText>(R.id.textoMatriculaDetalhe).apply {
            setText(aluno.matricula)
        }
        textoNomeDetalhe = findViewById<EditText>(R.id.textoNomeDetalhe).apply {
            setText(aluno.nome)
        }
        textoTelefoneDetalhe = findViewById<EditText>(R.id.textoTelefoneDetalhe).apply {
            setText(aluno.telefone)
        }

    }

    fun editarAluno(v: View?) {
        val aluno = Aluno(
            textoMatriculaDetalhe.text.toString(),
            textoNomeDetalhe.text.toString(),
            textoTelefoneDetalhe.text.toString()
        )
        val data = Intent()
        data.putExtra("aluno", aluno)
        setResult(RESULT_EDIT, data)
        finish()
    }

    fun excluirAluno(v: View?) {
        setResult(RESULT_DELETE)
        finish()
    }

    fun voltar(v: View?) {
        finish()
    }
}
