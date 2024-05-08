package com.example.gameverse.network

import com.google.gson.annotations.SerializedName

data class GameList(
    @SerializedName("results")
    val result: List<GameDto> = ArrayList()
)

