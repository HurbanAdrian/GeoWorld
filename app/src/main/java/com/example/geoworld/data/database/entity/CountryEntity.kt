package com.example.geoworld.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val isoCode: String,
    val continent: String,
    val flagResId: Int,
    val mapResId: Int
)