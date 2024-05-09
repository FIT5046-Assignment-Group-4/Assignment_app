package com.example.gameverse.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalDatabaseViewModel(applicaton: Application) : AndroidViewModel(applicaton) {
    private val cRepository: GameRepository
    init {
        cRepository = GameRepository(applicaton)
    }
    val allGames: LiveData<List<GameEntity>> = cRepository.allGames.asLiveData()

    fun insertGame(game: GameEntity) = viewModelScope.launch(Dispatchers.IO) {
        cRepository.insert(game)
    }

    fun deleteGame(game: GameEntity) = viewModelScope.launch(Dispatchers.IO) {
        cRepository.delete(game)
    }
}