package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import com.example.geoworld.model.QuizQuestion
import com.example.geoworld.data.CountryRepository
import com.example.geoworld.model.Country
import com.example.geoworld.model.Region
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class QuizViewModel(region: Region) : ViewModel() {

    private val countries = CountryRepository.getCountriesByRegion(region).shuffled()

    private val _currentQuestion = MutableStateFlow<QuizQuestion?>(null)
    val currentQuestion: StateFlow<QuizQuestion?> = _currentQuestion

    init {
        generateQuestion()
    }

    fun generateQuestion() {
        val correct = countries.random()
        val options = countries
            .filter { it != correct }
            .shuffled()
            .take(3)
            .plus(correct)
            .shuffled()

        _currentQuestion.value = QuizQuestion(correct, options)
    }

    fun answerSelected(answer: Country): Boolean {
        val isCorrect = answer == _currentQuestion.value?.country
        generateQuestion() // move to next
        return isCorrect
    }
}