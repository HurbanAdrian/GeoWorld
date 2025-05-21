package com.example.geoworld.model

import androidx.annotation.StringRes
import com.example.geoworld.R

enum class GameMode(@StringRes val labelResId: Int) {
    FLAGS(R.string.game_mode_flags),
    MAPS(R.string.game_mode_maps)
}