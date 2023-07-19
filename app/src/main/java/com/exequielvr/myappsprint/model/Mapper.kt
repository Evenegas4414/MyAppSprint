package com.exequielvr.myappsprint.model


fun fromInternetToItemsEntity(itemsList: List<Items>): List<ItemsEntity> {

    return itemsList.map {
        ItemsEntity(
            id = it.id,
            nombre = it.nombre,
            origen = it.origen,
            imagenLink = it.imagenLink,
            marca = it.marca,
            numero = it.numero
        )
    }
}

fun fromInternetToItemDetailEntity(item: ItemDetail): ItemsDetailEntity {

    return ItemsDetailEntity(
        id = item.id,
        nombre = item.nombre,
        origen = item.origen,
        imagenLink = item.imagenLink,
        marca = item.marca,
        numero = item.numero,
        precio = item.precio,
        entrega = item.entrega
    )
}












