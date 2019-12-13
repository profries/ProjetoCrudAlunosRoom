package com.example.projetocrudalunosroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetocrudalunosroom.R
import com.example.projetocrudalunosroom.model.Aluno


class AlunoAdapter (private var listaAlunos:ArrayList<Aluno>) : RecyclerView.Adapter<AlunoAdapter.MyViewHolder>() {
    var onItemClickListener: OnItemClickListener? = null

    class MyViewHolder : RecyclerView.ViewHolder {
        var textMatricula: TextView
        var textNome: TextView
        var textTelefone: TextView
        constructor(view: View) : super(view) {
            textMatricula = view.findViewById(R.id.textoMatricula)
            textNome = view.findViewById(R.id.textoNome)
            textTelefone = view.findViewById(R.id.textTelefone)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): AlunoAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_aluno, parent, false) as View
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textMatricula.text = listaAlunos.get(position).matricula
        holder.textNome.text = listaAlunos.get(position).nome
        holder.textTelefone.text = listaAlunos.get(position).telefone
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClicked(
                holder.itemView,
                position
            )
        }
    }

    override fun getItemCount() = listaAlunos.size

    interface OnItemClickListener {
        fun onItemClicked(view: View, position: Int)
    }
}
