package com.exequielvr.myappsprint.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_details_table")
data class ItemsDetailEntity(

    @PrimaryKey
    val id: Int,
    val nombre: String,
    val origen: String,
    val imagenLink: String,
    val marca: String,
    val numero: Int,
    val precio: Int,
    val entrega: Boolean
)