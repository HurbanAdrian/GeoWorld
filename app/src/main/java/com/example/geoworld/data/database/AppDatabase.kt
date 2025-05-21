package com.example.geoworld.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geoworld.data.database.dao.PlayerStatsDao
import com.example.geoworld.data.database.entity.PlayerStatsEntity

/**
 * Hlavná Room databáza pre aplikáciu GeoWorld.
 *
 * Obsahuje iba jednu entitu – [PlayerStatsEntity], ktorá uchováva herné štatistiky.
 * Poskytuje DAO [PlayerStatsDao] na prácu so štatistickými údajmi.
 *
 * Verzia databázy sa inkrementuje pri akejkoľvek zmene schémy.
 */
@Database(
    entities = [PlayerStatsEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    /**
     * DAO na prístup k štatistikám hráča.
     */
    abstract fun playerStatsDao(): PlayerStatsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Získa singleton inštanciu databázy.
         *
         * Používa `synchronized` blok na zaistenie thread-safe inicializácie.
         * Pri zmene verzie automaticky zmaže a znovu vytvorí databázu
         * pomocou `fallbackToDestructiveMigration(true)`.
         * Pomoc s chatGPT
         */
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "geo_world.db"
                )
                    .fallbackToDestructiveMigration(true)       // zmaze databazu a znovu vytvori pri zmene verzie
                    .build().also { INSTANCE = it }
            }
        }
    }
}

