package com.example.gameverse.network

data class GameDto(
    val background_image: String,
    val id: Int,
    val name: String,
    val rating: Double,
    val rating_top: Int,
    val released: String,
)
