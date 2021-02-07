package com.dinnerplanner.data

import com.dinnerplanner.R

enum class DifficultyLevel(val drawableId: Int, val stringId: Int) {
    EASY(R.drawable.roman_numeral_1, R.string.difficulty_level_easy),
    MEDIUM(R.drawable.roman_numeral_2, R.string.difficulty_level_medium),
    HARD(R.drawable.roman_numeral_3, R.string.difficulty_level_hard),
    VERY_HARD(R.drawable.roman_numeral_4, R.string.difficulty_level_very_hard)
}