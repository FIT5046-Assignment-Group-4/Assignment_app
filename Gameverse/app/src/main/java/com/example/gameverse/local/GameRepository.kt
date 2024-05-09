package com.example.gameverse.local

import android.app.Application
import kotlinx.coroutines.flow.Flow

class GameRepository (application: Application) {
    private var gameDAO: GameDAO = GameDatabase.getDatabase(application).gameDAO()

    val allGames: Flow<List<GameEntity>> = gameDAO.getAllGames()

    suspend fun insert(game: GameEntity) {
        gameDAO.insertGame(game)
    }

    suspend fun delete(game: GameEntity) {
        gameDAO.deleteGame(game)
    }
}