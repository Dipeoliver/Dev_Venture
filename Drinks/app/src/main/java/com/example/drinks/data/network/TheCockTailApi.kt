package com.example.drinks.data.network

import com.example.drinks.data.DrinkListRemoteEntity
import retrofit2.http.GET

interface TheCockTailApi {
    // GET = Retrofit
    // " " final variavel da url
    @GET("filter.php?a=Alcoholic")
    // metodo que a interface vai expor
    suspend fun getDrinks(): DrinkListRemoteEntity


    @GET("filter.php?a=Non_Alcoholic")
    // metodo que a interface vai expor
    suspend fun getDrinksNonAlcoholic(): DrinkListRemoteEntity
}