package com.example.geoworld.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,             // "flag", "map"
    val correctAnswer: String,
    val options: String,          // comma-separated list of options
    val countryId: Int            // foreign key reference
)