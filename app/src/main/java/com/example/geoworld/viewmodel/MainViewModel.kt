package com.example.geoworld.viewmodel

import androidx.lifecycle.ViewModel
import com.example.geoworld.data.CountryRepository
import com.example.geoworld.model.Country

/**
 * ViewModel pre zdieľanie zoznamu krajín naprieč UI komponentmi.
 *
 * V tejto triede držíme statický zoznam krajín z CountryRepository,
 * ktorý je dostupný pre ostatné časti aplikácie, ak je to potrebné.
 */
class MainViewModel : ViewModel() {
    /**
     * Zoznam všetkých krajín načítaný z CountryRepository.
     */
    val countries: List<Country> = CountryRepository.countries
}