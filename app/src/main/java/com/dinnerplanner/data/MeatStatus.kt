package com.dinnerplanner.data

import com.dinnerplanner.R

enum class MeatStatus(val drawableID: Int, val stringId: Int) {
    MEAT(R.drawable.meat_symbol, R.string.meat_status_meat),
    VEGETARIAN(R.drawable.vegetarian_symbol, R.string.meat_status_vegetarian),
    VEGAN(R.drawable.vegan_symbol, R.string.meat_status_vegan)
}