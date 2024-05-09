package com.example.gameverse

import com.example.gameverse.network.ApiClient
import com.example.gameverse.network.GameDetail
import com.example.gameverse.network.GameList

class ItemRepository {
    private val service = ApiClient.apiService
    private val API_KEY = "7139aadd1c63493c973dc3b5c0156464"

    //load game list in the browse page
    suspend fun loadGameList(search: String?=null, ordering: String?=null): GameList {
        return service.getGameList(API_KEY,search,ordering)
    }
    //load game detail in the single page
    suspend fun loadGameDetail(gameId: Int): GameDetail {
        return service.getGameDetail(gameId, API_KEY)
    }
    //home page
    suspend fun getPopularGames(): GameList{
        return service.getGameList(API_KEY, ordering = "-rating", PAGE_SIZE = 6)
    }
    //home page
    suspend fun getLatestGames(): GameList{
        return service.getGameList(API_KEY, ordering = "-added", PAGE_SIZE = 6)
    }
}