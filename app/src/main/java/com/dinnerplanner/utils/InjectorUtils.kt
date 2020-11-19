package com.dinnerplanner.utils

import com.dinnerplanner.data.FakeDatabase
import com.dinnerplanner.data.RecipeRepository
import com.dinnerplanner.ui.recipeList.RecipeListViewModelFactory

object InjectorUtils {

    fun provideRecipeListViewModelFactory(): RecipeListViewModelFactory {
        val recipeRepository = RecipeRepository.getInstance(FakeDatabase.getInstance().recipeDao)
        return RecipeListViewModelFactory(recipeRepository)
    }
}