package com.example.geoworld.data.database.dao

import androidx.room.*
import com.example.geoworld.data.database.entity.CountryEntity

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(country: CountryEntity)

    @Query("SELECT * FROM countries")
    suspend fun getAll(): List<CountryEntity>
}