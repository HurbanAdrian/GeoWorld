package com.example.geoworld.model

import androidx.annotation.StringRes

/**
 * Trieda reprezentujúca jednu krajinu v hre GeoWorld.
 *
 * @property nameResId ID string resource s lokalizovaným názvom krajiny (napr. R.string.country_france)
 * @property isoCode Trojpísmenový ISO kód krajiny (napr. "fra" pre Francúzsko)
 * @property flagResId ID drawable resource s obrázkom vlajky krajiny
 * @property mapResId ID drawable resource s obrázkom slepej mapy krajiny
 * @property continent Názov kontinentu, do ktorého krajina patrí (napr. "Europe")
 */
data class Country(
    @StringRes val nameResId: Int,
    val isoCode: String,
    val flagResId: Int,
    val mapResId: Int,
    val continent: String
)