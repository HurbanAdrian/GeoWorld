package com.example.geoworld.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_stats")
data class PlayerStatsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val score: Int,
    val correctAnswers: Int,
    val date: Long // timestamp
)