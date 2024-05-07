package com.example.gameverse.network

import com.google.gson.annotations.JsonAdapter
import okhttp3.internal.platform.Platform


data class Game(
    val background_image: Int,
    val id: Int,
    val name: String,
    val rating: Double,
    val rating_top: Int,
    val released: String,
)
