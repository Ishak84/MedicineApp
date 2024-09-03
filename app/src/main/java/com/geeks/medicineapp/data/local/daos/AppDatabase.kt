package com.geeks.medicineapp.data.local.daos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geeks.medicineapp.data.local.entity.model.Model

@Database(entities = [Model::class], version = 4)
abstract class AppDatabase : RoomDatabase(){
    abstract fun noteDao() : NoteDao
}