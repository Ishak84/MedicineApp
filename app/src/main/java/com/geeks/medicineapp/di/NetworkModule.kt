package com.geeks.medicineapp.di

import android.content.Context
import androidx.room.Room

import com.geeks.medicineapp.data.local.daos.AppDatabase
import com.geeks.medicineapp.data.local.daos.NoteDao
import org.koin.dsl.module

val networkModule = module {

    single { provideDao(get()) }
    single { provideDatabase(get()) }

}

fun provideDao(database: AppDatabase): NoteDao {
    return database.noteDao()
}

fun provideDatabase(
    context: Context
) = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "home_data"
).allowMainThreadQueries().build()