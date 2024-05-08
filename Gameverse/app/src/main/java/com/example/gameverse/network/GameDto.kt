package com.example.gameverse.network

import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("background_image")
    val backgroundImage: String,
    val id: Int,
    val name: String,
    val rating: Double,
    @SerializedName("rating_top")
    val ratingTop: Int,
    val released: String,
)
