package com.exequielvr.myappsprint

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface AppApi {

    @GET("courses")
    suspend fun fecthItemsList(): Response<List<Items>>

    @GET("courses/{id}")
    suspend fun fechItemDetail(@Path("id") id: String): Response<ItemDetail>
}