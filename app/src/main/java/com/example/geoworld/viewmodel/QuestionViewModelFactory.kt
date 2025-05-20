package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.geoworld.model.Region


class QuizViewModelFactory(private val region: Region) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(region) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}