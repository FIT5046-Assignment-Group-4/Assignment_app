package com.example.gameverse.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getGameList(
        @Query("key") key: String,
        @Query("search") search: String?=null,
    ): GameList

}