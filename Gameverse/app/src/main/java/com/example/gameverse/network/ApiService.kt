package com.example.gameverse.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getGameList(
        @Query("key") key: String,
        @Query("search") search: String?=null,
        @Query("ordering") ordering: String?=null,
        @Query("page_size") PAGE_SIZE: Int?=null,
    ): GameList

    @GET("games/{gameId}")
    suspend fun getGameDetail(
        @Path("gameId") gameId: Int,
        @Query("key") key: String
    ): GameDetail
}