package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.geoworld.data.repository.QuestionRepository


class QuestionViewModelFactory(
    private val repository: QuestionRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
            return QuestionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}