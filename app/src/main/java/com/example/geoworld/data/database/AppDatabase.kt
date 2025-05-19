package com.example.geoworld.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.geoworld.data.database.dao.CountryDao
import com.example.geoworld.data.database.dao.PlayerStatsDao
import com.example.geoworld.data.database.dao.QuestionDao
import com.example.geoworld.data.database.entity.CountryEntity
import com.example.geoworld.data.database.entity.PlayerStatsEntity
import com.example.geoworld.data.database.entity.QuestionEntity

@Database(
    entities = [CountryEntity::class, QuestionEntity::class, PlayerStatsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
    abstract fun questionDao(): QuestionDao
    abstract fun playerStatsDao(): PlayerStatsDao
}