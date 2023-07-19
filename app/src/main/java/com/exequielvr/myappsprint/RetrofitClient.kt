package com.exequielvr.myappsprint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {


    companion object {
        private const val BASE_URL = "https://caso-invest-center-mariocanedo.vercel.app/"

        lateinit var retrofitInstance: Retrofit
        fun retrofitInstance(): AppApi {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(AppApi::class.java)

        }

    }
}