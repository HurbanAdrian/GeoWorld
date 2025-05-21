package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geoworld.data.database.entity.PlayerStatsEntity
import com.example.geoworld.data.repository.PlayerStatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel zodpovedný za manipuláciu s hernými štatistikami hráča.
 *
 * Komunikuje s [PlayerStatsRepository] na získanie, vloženie a vymazanie dát z databázy.
 * Uchováva aktuálny stav štatistík v [StateFlow], aby boli pozorovateľné v UI.
 *
 * @param repository Inštancia repozitára pre prácu s databázou hráčskych štatistík.
 */
class StatsViewModel(private val repository: PlayerStatsRepository) : ViewModel() {

    // Interné MutableStateFlow pre uchovanie štatistík
    private val _stats = MutableStateFlow<List<PlayerStatsEntity>>(emptyList())

    /**
     * Verejné pozorovateľné štatistiky pre zobrazenie v UI.
     */
    val stats: StateFlow<List<PlayerStatsEntity>> = _stats

    /**
     * Načíta všetky štatistiky z databázy.
     * Spúšťa sa v coroutine pomocou [viewModelScope].
     */
    fun loadStats() {
        viewModelScope.launch {
            _stats.value = repository.getAllStats()
        }
    }

    /**
     * Vloží novú štatistiku do databázy a obnoví zoznam.
     *
     * @param stat Nová štatistika, ktorú treba uložiť.
     */
    fun insertStat(stat: PlayerStatsEntity) {
        viewModelScope.launch {
            repository.insert(stat)
            loadStats()                                 // aktualizácia stavu po pridaní
        }
    }

    /**
     * Vymaže všetky štatistiky z databázy a obnoví stav.
     */
    fun clearStats() {
        viewModelScope.launch {
            repository.clearStats()
            loadStats()             // znvou nacitanie zoznamu
        }
    }
}