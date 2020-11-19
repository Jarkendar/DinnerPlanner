package com.dinnerplanner.ui.recipeDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dinnerplanner.data.Recipe

class RecipeDetailsViewModelFactory(private val recipe: Recipe) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeDetailsViewModel::class.java)) {
            return RecipeDetailsViewModel(recipe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}