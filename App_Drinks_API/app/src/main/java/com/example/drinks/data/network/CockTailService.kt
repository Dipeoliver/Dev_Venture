package com.example.drinks.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL="https://www.thecocktaildb.com/api/json/v1/1/"

private val retrofit =
    // ator principal da geracao
    Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object CockTailService{
    val service: TheCockTailApi by  lazy {
        retrofit.create(TheCockTailApi::class.java)
    }
}