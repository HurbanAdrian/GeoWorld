package com.example.geoworld.model

import androidx.annotation.StringRes
import com.example.geoworld.R

/**
 * Enum trieda reprezentujúca geografické regióny dostupné v hre.
 *
 * Každý región má referenciu na textový zdroj (string resource), ktorý sa zobrazuje v UI.
 *
 * @property labelResId ID string resource pre zobrazenie názvu regiónu.
 */
enum class Region(@StringRes val labelResId: Int) {
    EUROPE(R.string.region_europe),
    ASIA(R.string.region_asia),
    AFRICA(R.string.region_africa),
    AMERICA(R.string.region_america),
    OCEANIA(R.string.region_oceania)
}