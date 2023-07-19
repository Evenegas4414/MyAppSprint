package com.exequielvr.myappsprint


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

fun fromInternetToItemDetailEntity(course: ItemDetail): ItemsDetailEntity {

    return ItemsDetailEntity(
        id = course.id,
        title = course.title,
        previewDescription = course.previewDescription,
        image = course.image,
        weeks = course.weeks,
        tuition = course.tuition,
        minimumSkill = course.minimumSkill,
        scholarshipAvailable = true,
        modality = course.modality,
        star = course.start
    )
}












