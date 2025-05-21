package com.example.geoworld.model

import androidx.annotation.StringRes

data class Country(
    @StringRes val nameResId: Int,
    val isoCode: String,
    val flagResId: Int,
    val mapResId: Int,
    val continent: String
)