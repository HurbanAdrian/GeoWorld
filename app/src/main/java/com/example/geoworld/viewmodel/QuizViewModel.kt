package com.example.geoworld.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.geoworld.model.QuizQuestion
import com.example.geoworld.data.CountryRepository
import com.example.geoworld.model.Country
import com.example.geoworld.model.Region
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel zodpovedný za logiku kvízovej hry.
 *
 * Udržiava stav hry vrátane skóre, životov, otázok, vybranej odpovede a výsledku.
 * Otázky sú generované náhodne zo zoznamu krajín podľa vybraného regiónu.
 *
 * @param region Región, z ktorého sa budú generovať krajiny pre otázky.
 */
class QuizViewModel(private val region: Region) : ViewModel() {
    // Náhodne zamiešaný zoznam krajín z vybraného regiónu
    private val countries = CountryRepository.getCountriesByRegion(region).shuffled()

    // Stavové premenné pre sledovanie priebehu hry
    val score = mutableIntStateOf(0)
    val streak = mutableIntStateOf(0)
    val lives = mutableIntStateOf(3)
    val correctAnswers = mutableIntStateOf(0)
    val gameOver = mutableStateOf(false)

    // Aktuálna otázka (s možnosťami a správnou odpoveďou)
    private val _currentQuestion = MutableStateFlow<QuizQuestion?>(null)
    val currentQuestion: StateFlow<QuizQuestion?> = _currentQuestion

    // Používateľova vybraná odpoveď a stav, či sa má ukázať výsledok
    val selectedAnswer = mutableStateOf<Country?>(null)
    val showResult = mutableStateOf(false)

    init {
        // Generovanie prvej otázky pri inicializácii - s pomocou internetu to init
        generateQuestion()
    }

    /**
     * Generuje novú otázku, ak hráč má ešte životy.
     * Ak životy došli, hra sa reštartuje.
     */
    fun generateQuestion() {
        if (lives.intValue <= 0) {
            resetGame()
            return
        }

        // s pomocou chatGPT
        val correct = countries.random()
        val options = countries
            .filter { it != correct }
            .shuffled()
            .take(3)
            .plus(correct)
            .shuffled()

        _currentQuestion.value = QuizQuestion(correct, options)
    }

    /**
     * Spracovanie vybranej odpovede používateľa.
     *
     * Zmení skóre, životy a nastaví stav zobrazenia výsledku.
     *
     * @param answer Krajina, ktorú používateľ vybral ako odpoveď.
     * @return true ak bola odpoveď správna, inak false.
     */
    fun answerSelected(answer: Country): Boolean {
        val isCorrect = answer == _currentQuestion.value?.country
        selectedAnswer.value = answer
        showResult.value = true

        if (isCorrect) {
            score.intValue += 1
            streak.intValue += 1
            correctAnswers.intValue += 1
            //Log.d("QUIZ", "Skóre zvýšené na ${score.intValue}")
        } else {
            lives.intValue -= 1
            streak.intValue = 0
            if (lives.intValue <= 0) {
                gameOver.value = true
            }
        }

        return isCorrect
    }

    /**
     * Reštartuje celú hru — skóre, životy, otázky, odpovede.
     */
    fun resetGame() {
        score.intValue = 0
        lives.intValue = 3
        streak.intValue = 0
        correctAnswers.intValue = 0
        gameOver.value = false

        selectedAnswer.value = null
        showResult.value = false

        //generateQuestion()
    }
}