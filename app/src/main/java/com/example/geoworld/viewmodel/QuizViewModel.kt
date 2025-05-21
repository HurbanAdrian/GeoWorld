package com.example.geoworld.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.geoworld.model.QuizQuestion
import com.example.geoworld.data.CountryRepository
import com.example.geoworld.model.Country
import com.example.geoworld.model.Region
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class QuizViewModel(private val region: Region) : ViewModel() {

    private val countries = CountryRepository.getCountriesByRegion(region).shuffled()

    val score = mutableIntStateOf(0)
    val streak = mutableIntStateOf(0)
    val lives = mutableIntStateOf(3)
    val correctAnswers = mutableIntStateOf(0)
    val gameOver = mutableStateOf(false)

    private val _currentQuestion = MutableStateFlow<QuizQuestion?>(null)
    val currentQuestion: StateFlow<QuizQuestion?> = _currentQuestion

    val selectedAnswer = mutableStateOf<Country?>(null)
    val showResult = mutableStateOf(false)

    init {
        generateQuestion()
    }

    fun generateQuestion() {
        if (lives.intValue <= 0) {
            resetGame()
            return
        }

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
        selectedAnswer.value = answer
        showResult.value = true

        if (isCorrect) {
            score.intValue += 1
            streak.intValue += 1
            correctAnswers.intValue += 1
            Log.d("QUIZ", "Skóre zvýšené na ${score.intValue}")
        } else {
            lives.intValue -= 1
            streak.intValue = 0
            if (lives.intValue <= 0) {
                gameOver.value = true
            }
        }

        return isCorrect
    }

    fun resetGame() {
        score.intValue = 0
        lives.intValue = 3
        streak.intValue = 0
        correctAnswers.intValue = 0
        gameOver.value = false
        generateQuestion()
    }
}