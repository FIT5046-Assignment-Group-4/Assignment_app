package com.example.gameverse.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDAO{
    @Query("SELECT * FROM GameEntity")
    fun getAllGames(): Flow<List<GameEntity>>

    @Insert
    suspend fun insertGame(game: GameEntity)

    @Delete
    suspend fun deleteGame(game: GameEntity)
}