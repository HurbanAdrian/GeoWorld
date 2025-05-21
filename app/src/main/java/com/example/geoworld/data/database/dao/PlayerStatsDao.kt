package com.example.geoworld.data.database.dao

import androidx.room.*
import com.example.geoworld.data.database.entity.PlayerStatsEntity

/**
 * Data Access Object pre štatistiky hráča.
 * Poskytuje metódy na vkladanie, čítanie a mazanie záznamov v tabuľke `player_stats`.
 */
@Dao
interface PlayerStatsDao {

    /**
     * Vloží nový štatistický záznam hráča do databázy.
     *
     * @param stat Inštancia [PlayerStatsEntity], ktorú chceme uložiť.
     */
    @Insert
    suspend fun insert(stat: PlayerStatsEntity)

    /**
     * Získa všetky štatistiky zoradené od najnovšej podľa dátumu.
     *
     * @return Zoznam štatistík [PlayerStatsEntity].
     */
    @Query("SELECT * FROM player_stats ORDER BY date DESC")
    suspend fun getAll(): List<PlayerStatsEntity>

    /**
     * Vymaže všetky záznamy zo štatistík hráča.
     */
    @Query("DELETE FROM player_stats")
    suspend fun deleteAllStats()

    /**
     * Blokujúco načíta všetky štatistiky (používané v `StatsService` mimo coroutines).
     * (Spúšťa sa na IO vlákne, mimo hlavného UI threadu)
     *
     * @return Zoznam všetkých štatistík [PlayerStatsEntity].
     */
    @Query("SELECT * FROM player_stats")
    fun getAllStatsBlocking(): List<PlayerStatsEntity>
}