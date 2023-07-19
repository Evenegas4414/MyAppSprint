package com.exequielvr.myappsprint

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface AppApi {

    @GET("shoes")
    suspend fun fecthItemsList(): Response<List<Items>>

    @GET("shoes/{id}")
    suspend fun fechItemDetail(@Path("id") id: String): Response<ItemDetail>
}