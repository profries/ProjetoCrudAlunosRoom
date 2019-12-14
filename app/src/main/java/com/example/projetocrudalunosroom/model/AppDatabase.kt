package com.example.projetocrudalunosroom.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Aluno::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alunoDao(): AlunoDao
}