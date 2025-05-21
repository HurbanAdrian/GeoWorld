package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.geoworld.data.repository.PlayerStatsRepository

/**
 * Factory trieda pre vytváranie inštancií [StatsViewModel] s parametrom [PlayerStatsRepository].
 *
 * Používa sa na zabezpečenie dependency injection pri vytváraní ViewModelu v rámci Composable funkcií.
 *
 * @property repository Inštancia repozitára s ktorým bude ViewModel pracovať.
 */
class StatsViewModelFactory(
    private val repository: PlayerStatsRepository
) : ViewModelProvider.Factory {

    /**
     * Vytvára inštanciu [StatsViewModel] ak je požadovaný typ, inak vyhadzuje výnimku.
     *
     * @param modelClass Trieda ViewModelu, ktorý má byť vytvorený.
     * @param extras Ďalšie parametre (v tomto prípade nepoužité).
     * @return Nová inštancia [StatsViewModel].
     * @throws IllegalArgumentException ak nie je typ ViewModelu podporovaný.
     */
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(StatsViewModel::class.java)) {
            return StatsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}