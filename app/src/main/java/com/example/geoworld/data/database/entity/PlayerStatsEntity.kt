package com.example.geoworld.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entita reprezentujúca jeden štatistický záznam o hre hráča.
 * Ukladá skóre, správne odpovede, región a ďalšie parametre z jednej hernej session.
 *
 * Táto entita je mapovaná na tabuľku `player_stats` v Room databáze.
 */
@Entity(tableName = "player_stats")
data class PlayerStatsEntity(
    /**
     * Primárny kľúč – generuje sa automaticky.
     */
    @PrimaryKey(autoGenerate = true) val id: Int = 0,


    /**
     * Dosiahnuté skóre v danej hre.
     */
    val score: Int,

    /**
     * Počet správnych odpovedí.
     */
    val correctAnswers: Int,

    /**
     * Časový údaj – uložený ako Unix timestamp (v milisekundách).
     */
    val date: Long,

    /**
     * Región, v ktorom sa daná hra odohrávala, napr. "Europe".
     */
    val region: String,


    /**
     * Najvyšší počet správnych odpovedí za sebou (streak).
     */
    val streak: Int,

    /**
     * Počet zostávajúcich životov po skončení hry.
     */
    val livesLeft: Int
)