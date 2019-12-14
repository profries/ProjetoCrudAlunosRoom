package com.example.projetocrudalunosroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Aluno (
    @PrimaryKey val id: Int,
    val matricula: String,
    val nome: String,
    val telefone: String
)
