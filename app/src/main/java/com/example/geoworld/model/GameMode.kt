package com.example.geoworld.model

import androidx.annotation.StringRes
import com.example.geoworld.R

/**
 * Enum trieda reprezentujúca herné módy v hre GeoWorld.
 *
 * @property labelResId ID string resource s lokalizovaným názvom módu pre zobrazenie v UI.
 *
 * Módy:
 * - [FLAGS]: hráč háda krajinu podľa vlajky
 * - [MAPS]: hráč háda krajinu podľa slepej mapy
 */
enum class GameMode(@StringRes val labelResId: Int) {
    FLAGS(R.string.game_mode_flags),
    MAPS(R.string.game_mode_maps)
}