package com.geeks.medicineapp.data.local.entity.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "model")
data class Model(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val time : String,
    val description : String
)
