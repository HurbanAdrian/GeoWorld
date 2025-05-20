package com.example.geoworld.data.database.dao

import androidx.room.*
import com.example.geoworld.data.database.entity.PlayerStatsEntity

@Dao
interface PlayerStatsDao {
    @Insert
    suspend fun insert(stat: PlayerStatsEntity)

    @Query("SELECT * FROM player_stats ORDER BY date DESC")
    suspend fun getAll(): List<PlayerStatsEntity>

    @Query("DELETE FROM player_stats")
    suspend fun deleteAllStats()
}