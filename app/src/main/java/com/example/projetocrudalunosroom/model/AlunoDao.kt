package com.example.projetocrudalunosroom.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlunoDao {
    @Query("SELECT * FROM aluno")
    fun getAll(): List<Aluno>

    @Query("SELECT * FROM aluno WHERE id= :id")
    fun getById(id: Int): Aluno

    @Insert
    fun insert(vararg aluno: Aluno)

    @Delete
    fun delete(user: Aluno)
}