package com.example.projetocrudalunosroom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.projetocrudalunosroom.model.Aluno


class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    fun cadastrarAluno(view: View?) {
        val textoMatriculaCadastro = findViewById(R.id.textoMatriculaCadastro) as EditText
        val textoNomeCadastro = findViewById(R.id.textoNomeCadastro) as EditText
        val textoTelefoneCadastro = findViewById(R.id.textoTelefoneCadastro) as EditText
        val matricula = textoMatriculaCadastro.text.toString()
        val nome = textoNomeCadastro.text.toString()
        val telefone = textoTelefoneCadastro.text.toString()
        val aluno = Aluno(matricula, nome, telefone)
        val it = Intent().apply {
            putExtra("aluno", aluno)
        }
        setResult(Activity.RESULT_OK, it)

        finish()
    }

    fun cancelarCadastro(view: View?) {
        finish()
    }
}
