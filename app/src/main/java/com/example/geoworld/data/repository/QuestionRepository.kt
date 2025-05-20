package com.example.geoworld.data.repository

import com.example.geoworld.data.database.dao.QuestionDao
import com.example.geoworld.data.database.entity.QuestionEntity


class QuestionRepository(private val dao: QuestionDao) {
    suspend fun insert(question: QuestionEntity) = dao.insert(question)
    suspend fun getAllQuestions(): List<QuestionEntity> = dao.getAll()
}