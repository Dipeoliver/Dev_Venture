package com.example.drinks.data

import com.google.gson.annotations.SerializedName

data class DrinkListRemoteEntity(
    // o serialized faz a converção do nome
    @SerializedName("drinks")
    val drinksList: List<DrinkRemoteEntity>
)