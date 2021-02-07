package com.dinnerplanner.data

import com.dinnerplanner.R

enum class SpicyLevel(val drawableId: Int, val stringId: Int) {
    NO_SPICY(R.drawable.chili_off, R.string.spicy_level_no_spicy),
    MILD(R.drawable.chili_mild, R.string.spicy_level_mild),
    MEDIUM(R.drawable.chili_medium, R.string.spicy_level_medium),
    HOT(R.drawable.chili_hot, R.string.spicy_level_hot)
}