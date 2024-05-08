package com.example.gameverse

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameverse.network.ApiClient
import com.example.gameverse.network.GameDto
import com.example.gameverse.network.GameList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel: ViewModel() {

    private val repository = GameRepository()
    val retrofitResponse: MutableState <GameList> = mutableStateOf(GameList())
    val retrofitPopulart: MutableState <GameList> = mutableStateOf(GameList())
    val retrofitLatest: MutableState <GameList> = mutableStateOf(GameList())

    init {
        viewModelScope.launch {
            val resReturned = repository.loadGameList()
            retrofitResponse.value = resReturned
            val resPopular = repository.getPopularGames()
            retrofitPopulart.value = resPopular
            val resLatest = repository.getLatestGames()
            retrofitLatest.value = resLatest
        }
    }

    fun searchGame(keyword: String ) {
        viewModelScope.launch {
            val responseReturned = repository.loadGameList(keyword)
            retrofitResponse.value = responseReturned
        }

    }
}