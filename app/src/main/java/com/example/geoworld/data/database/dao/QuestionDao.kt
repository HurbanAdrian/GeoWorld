package com.example.geoworld.data.database.dao

import androidx.room.*
import com.example.geoworld.data.database.entity.QuestionEntity

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(question: QuestionEntity)

    @Query("SELECT * FROM questions")
    suspend fun getAll(): List<QuestionEntity>
}