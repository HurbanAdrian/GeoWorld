package com.example.geoworld.model

/**
 * Reprezentuje jednu otázku v kvíze.
 *
 * @property country Správna odpoveď – krajina, ktorú má hráč identifikovať.
 * @property options Zoznam možností (krajín), z ktorých si hráč vyberá. Obsahuje aj správnu odpoveď.
 */
data class QuizQuestion(
    val country: Country,
    val options: List<Country>
)