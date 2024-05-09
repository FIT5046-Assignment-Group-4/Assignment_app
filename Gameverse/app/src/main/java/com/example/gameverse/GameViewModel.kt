package com.example.gameverse

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameverse.network.ApiClient
import com.example.gameverse.network.GameDetail
import com.example.gameverse.network.GameDto
import com.example.gameverse.network.GameList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel: ViewModel() {

    private val repository = GameRepository()
    val retrofitResponse: MutableState <GameList> = mutableStateOf(GameList())
    val retrofitPopular: MutableState <GameList> = mutableStateOf(GameList())
    val retrofitLatest: MutableState <GameList> = mutableStateOf(GameList())
    val retrofitDetail: MutableState<GameDetail> = mutableStateOf(GameDetail(0,"",0.0,"",""))

    init {
        viewModelScope.launch {
            //load default game list
            val resReturned = repository.loadGameList()
            retrofitResponse.value = resReturned

            val resPopular = repository.getPopularGames()
            retrofitPopular.value = resPopular

            val resLatest = repository.getLatestGames()
            retrofitLatest.value = resLatest
        }
    }

    //search game by keyword
    fun searchGame(keyword: String ) {
        viewModelScope.launch {
            val responseReturned = repository.loadGameList(keyword)
            retrofitResponse.value = responseReturned
        }
    }

    //load game detail
    fun loadGameDetail(gameId: Int) {
        viewModelScope.launch {
            val responseReturned = repository.loadGameDetail(gameId)
            retrofitDetail.value = responseReturned
        }
    }
}