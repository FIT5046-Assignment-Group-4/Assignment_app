package com.example.gameverse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameverse.network.ApiClient
import kotlinx.coroutines.launch

class GameViewModel: ViewModel() {
    private val _gameData = MutableLiveData("No data")
    val gameData: LiveData<String> get() = _gameData

    private suspend fun getGameList(search: String?=null) {
        _gameData.value = ApiClient.apiService.getGameList("7139aadd1c63493c973dc3b5c0156464",search).toString()
    }

    init {
        viewModelScope.launch {
            getGameList()
        }
    }
}