package com.example.geoworld.data.repository

import com.example.geoworld.data.database.dao.PlayerStatsDao
import com.example.geoworld.data.database.entity.PlayerStatsEntity

/**
 * Repository vrstva pre prácu so štatistikami hráča.
 *
 * Oddeluje priamu interakciu s databázou od zvyšku aplikácie, čím umožňuje
 * jednoduchšie testovanie a lepšie dodržiavanie architektonických zásad.
 *
 * @param dao Inštancia DAO pre štatistiky hráča.
 */
class PlayerStatsRepository(private val dao: PlayerStatsDao) {
    /**
     * Uloží nový štatistický záznam do databázy.
     */
    suspend fun insert(stat: PlayerStatsEntity) = dao.insert(stat)

    /**
     * Získa všetky štatistiky hráča zozbierané počas hry.
     */
    suspend fun getAllStats(): List<PlayerStatsEntity> = dao.getAll()

    /**
     * Vymaže všetky štatistické údaje z databázy.
     */
    suspend fun clearStats() = dao.deleteAllStats()
}