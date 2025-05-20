package com.example.geoworld.model

data class QuizQuestion(
    val country: Country,
    val options: List<Country>
)