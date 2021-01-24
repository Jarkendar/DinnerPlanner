package com.dinnerplanner.utils

import com.dinnerplanner.data.MeatStatus
import com.dinnerplanner.data.Recipe

fun Recipe.getMeatStatus(): MeatStatus {
    return when {
        this.vegan -> MeatStatus.VEGAN
        this.vegetarian -> MeatStatus.VEGETARIAN
        else -> MeatStatus.MEAT
    }
}