package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.geoworld.model.Region

/**
 * Factory trieda pre vytvorenie inštancie [QuizViewModel] so zadaným regiónom.
 *
 * ViewModelProvider.Factory sa používa, keď ViewModel potrebuje konštruktor s argumentmi,
 * ktoré nie sú predvolene podporované cez štandardný ViewModelProvider.
 *
 * @param region Región, ktorý sa má použiť v kvízovej hre.
 */
class QuizViewModelFactory(private val region: Region) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Overíme, že sa vytvára QuizViewModel
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(region) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")       // nie ako zdroj text je to pre Debug
    }
}