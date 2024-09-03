package com.geeks.medicineapp.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.geeks.medicineapp.data.local.entity.model.Model

@Dao
interface NoteDao {

    @Query("SELECT * FROM model")
    fun getAllPills(): LiveData<List<Model>>

    @Query("SELECT * FROM model WHERE id = :id")
    fun getPillsById(id: Int): Model

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPills(pills: Model)

    @Delete
    suspend fun deletePills(pills: Model)

    @Update
    suspend fun updatePills(pills: Model)
}