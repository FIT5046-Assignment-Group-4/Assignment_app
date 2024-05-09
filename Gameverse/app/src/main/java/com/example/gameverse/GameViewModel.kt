package com.example.gameverse

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameverse.network.GameDetail
import com.example.gameverse.network.GameList
import kotlinx.coroutines.launch
import java.lang.Exception

class GameViewModel: ViewModel() {

    private val repository = ItemRepository()
    val retrofitResponse: MutableState <GameList> = mutableStateOf(GameList())
    val retrofitPopular: MutableState <GameList> = mutableStateOf(GameList())
    val retrofitLatest: MutableState <GameList> = mutableStateOf(GameList())
    val retrofitDetail: MutableState<GameDetail> = mutableStateOf(GameDetail(0,"",0.0,"",""))

    init {
        viewModelScope.launch {
            try {
                //load default game list
                val resReturned = repository.loadGameList()
                retrofitResponse.value = resReturned

                val resPopular = repository.getPopularGames()
                retrofitPopular.value = resPopular

                val resLatest = repository.getLatestGames()
                retrofitLatest.value = resLatest
            } catch (e: Exception) {
                e.message?.let { Log.d("API Response", it) }
            }

        }
    }

    //search game by keyword
    fun searchGame(keyword: String ) {
        viewModelScope.launch {
            try {
                val responseReturned = repository.loadGameList(keyword)
                retrofitResponse.value = responseReturned
            } catch (e: Exception) {
                e.message?.let { Log.d("API Response", it) }
            }

        }
    }

    //load game detail
    fun loadGameDetail(gameId: Int) {
        viewModelScope.launch {
            try{
                val responseReturned = repository.loadGameDetail(gameId)
                retrofitDetail.value = responseReturned
            } catch (e: Exception) {
                e.message?.let { Log.d("API Response", it) }
            }

        }
    }
}