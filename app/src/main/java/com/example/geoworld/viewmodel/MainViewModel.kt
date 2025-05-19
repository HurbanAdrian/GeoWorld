package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import com.example.geoworld.data.CountryRepository
import com.example.geoworld.model.Country

class MainViewModel : ViewModel() {
    val countries: List<Country> = CountryRepository.countries
}