package com.exequielvr.myappsprint.model

data class ItemDetail(

    val id: Int,
    val nombre: String,
    val origen: String,
    val imagenLink: String,
    val marca: String,
    val numero: Int,
    val precio: Int,
    val entrega: Boolean
)