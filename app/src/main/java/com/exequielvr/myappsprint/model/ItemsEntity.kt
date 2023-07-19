package com.exequielvr.myappsprint.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_list_table")
data class ItemsEntity(

    @PrimaryKey
    val id: Int,
    val nombre: String,
    val origen: String,
    val imagenLink: String,
    val marca: String,
    val numero: Int
)