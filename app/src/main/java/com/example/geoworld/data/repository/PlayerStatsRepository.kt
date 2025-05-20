package com.example.geoworld.data.repository

import com.example.geoworld.data.database.dao.PlayerStatsDao
import com.example.geoworld.data.database.entity.PlayerStatsEntity

class PlayerStatsRepository(private val dao: PlayerStatsDao) {
    suspend fun insert(stat: PlayerStatsEntity) = dao.insert(stat)
    suspend fun getAllStats(): List<PlayerStatsEntity> = dao.getAll()
}