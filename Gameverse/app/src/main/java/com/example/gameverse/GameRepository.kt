package com.example.gameverse

import com.example.gameverse.network.ApiClient
import com.example.gameverse.network.GameList

class GameRepository {
    private val searchService = ApiClient.apiService
    private val API_KEY = "7139aadd1c63493c973dc3b5c0156464"

    suspend fun getResponse(search: String?=null): GameList {
        return searchService.getGameList(API_KEY,search)
    }
}