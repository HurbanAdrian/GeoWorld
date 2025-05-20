package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geoworld.data.database.entity.PlayerStatsEntity
import com.example.geoworld.data.repository.PlayerStatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StatsViewModel(private val repository: PlayerStatsRepository) : ViewModel() {

    private val _stats = MutableStateFlow<List<PlayerStatsEntity>>(emptyList())
    val stats: StateFlow<List<PlayerStatsEntity>> = _stats

    fun loadStats() {
        viewModelScope.launch {
            _stats.value = repository.getAllStats()
        }
    }

    fun insertStat(stat: PlayerStatsEntity) {
        viewModelScope.launch {
            repository.insert(stat)
            loadStats()
        }
    }
}