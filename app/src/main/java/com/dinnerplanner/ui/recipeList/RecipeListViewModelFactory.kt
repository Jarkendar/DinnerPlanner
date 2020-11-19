package com.dinnerplanner.ui.recipeList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dinnerplanner.data.RecipeRepository

class RecipeListViewModelFactory(private val recipeRepository: RecipeRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RecipeListViewModel(recipeRepository) as T
    }
}