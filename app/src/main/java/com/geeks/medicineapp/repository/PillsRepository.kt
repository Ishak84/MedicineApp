package com.geeks.medicineapp.repository

import androidx.lifecycle.LiveData

import com.geeks.medicineapp.data.local.daos.NoteDao
import com.geeks.medicineapp.data.local.entity.model.Model

class PillsRepository(
    private val pillsDao: NoteDao
) {
    suspend fun insert(pills: Model) {
        pillsDao.insertPills(pills)
    }

     fun getAllPills(): LiveData<List<Model>> {
        return pillsDao.getAllPills()
    }
}