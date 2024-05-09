package com.example.gameverse.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameEntity(
    val name: String,
    val backgroundImage: String,
    val ratingTop: Int,
    val rating: Double,

    @PrimaryKey
    val id: Int?  = -1,
)