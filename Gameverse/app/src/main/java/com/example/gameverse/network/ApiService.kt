package com.example.gameverse.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getGameList(
        @Query("key") key: String,
        @Query("search") search: String?=null
    ): GameList

    companion object {
        const val API_KEY = "7139aadd1c63493c973dc3b5c0156464"
    }
}