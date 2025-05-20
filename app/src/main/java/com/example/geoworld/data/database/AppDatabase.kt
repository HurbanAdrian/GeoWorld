package com.example.geoworld.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geoworld.data.database.dao.CountryDao
import com.example.geoworld.data.database.dao.PlayerStatsDao
import com.example.geoworld.data.database.dao.QuestionDao
import com.example.geoworld.data.database.entity.CountryEntity
import com.example.geoworld.data.database.entity.PlayerStatsEntity
import com.example.geoworld.data.database.entity.QuestionEntity

@Database(
    entities = [CountryEntity::class, QuestionEntity::class, PlayerStatsEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
    abstract fun questionDao(): QuestionDao
    abstract fun playerStatsDao(): PlayerStatsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

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

