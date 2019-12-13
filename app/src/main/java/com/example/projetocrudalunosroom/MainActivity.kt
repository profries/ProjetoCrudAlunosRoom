package com.example.projetocrudalunosroom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetocrudalunosroom.adapter.AlunoAdapter
import com.example.projetocrudalunosroom.model.Aluno


class MainActivity : AppCompatActivity(),AlunoAdapter.OnItemClickListener {
    private val REQ_CADASTRO = 1;
    private val REQ_DETALHE  = 2;
    private var listaAlunos: ArrayList<Aluno> = ArrayList()
    private var posicaoAlterar=-1

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: AlunoAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = AlunoAdapter(listaAlunos)
        viewAdapter.onItemClickListener = this


        listaAlunos.add(Aluno("001","Fulano","51-33445566"))
        listaAlunos.add(Aluno("002","Sicrano","51-44556677"))
        listaAlunos.add(Aluno("003","Beltrano","51-99887766"))

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {

            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter



        }
    }

    override fun onItemClicked(view: View, position: Int) {
        val it = Intent(this, DetalheActivity::class.java)
        this.posicaoAlterar = position
        val aluno = listaAlunos.get(position)
        it.putExtra("aluno", aluno)
        startActivityForResult(it, REQ_DETALHE)
    }

    fun abrirFormulario(view: View) {
        val it = Intent(this, CadastroActivity::class.java)
        startActivityForResult(it, REQ_CADASTRO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CADASTRO) {
            if (resultCode == Activity.RESULT_OK) {
                val aluno = data?.getSerializableExtra("aluno") as Aluno
                listaAlunos.add(aluno)
                viewAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Cadastro realizada com sucesso!", Toast.LENGTH_SHORT)
                    .show()
            }
        } else if (requestCode == REQ_DETALHE) {
            if (resultCode == DetalheActivity.RESULT_EDIT) {
                val aluno = data?.getSerializableExtra("aluno") as Aluno
                listaAlunos.set(this.posicaoAlterar, aluno)
                viewAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Edicao realizada com sucesso!", Toast.LENGTH_SHORT)
                    .show()
            } else if (resultCode == DetalheActivity.RESULT_DELETE) {
                listaAlunos.removeAt(this.posicaoAlterar)
                viewAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Exclusao realizada com sucesso!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }



}
