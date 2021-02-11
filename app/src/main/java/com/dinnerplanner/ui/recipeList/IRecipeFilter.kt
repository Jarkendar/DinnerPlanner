package com.dinnerplanner.ui.recipeList

import com.dinnerplanner.data.Recipe

interface IRecipeFilter {
    fun performFilter(query: String): Array<Recipe>
}