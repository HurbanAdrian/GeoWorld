package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geoworld.data.database.entity.QuestionEntity
import com.example.geoworld.data.repository.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuestionViewModel(private val repository: QuestionRepository) : ViewModel() {

    private val _questions = MutableStateFlow<List<QuestionEntity>>(emptyList())
    val questions: StateFlow<List<QuestionEntity>> = _questions

    fun loadQuestions() {
        viewModelScope.launch {
            _questions.value = repository.getAllQuestions()
        }
    }
}