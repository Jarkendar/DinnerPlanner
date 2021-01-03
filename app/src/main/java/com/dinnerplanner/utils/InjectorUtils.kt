package com.dinnerplanner.utils

import android.content.Context
import com.dinnerplanner.data.FakeDatabase
import com.dinnerplanner.data.RecipeRepository
import com.dinnerplanner.ui.recipeList.RecipeListViewModelFactory

object InjectorUtils {

    fun provideRecipeListViewModelFactory(context: Context): RecipeListViewModelFactory {
        val recipeRepository =
            RecipeRepository.getInstance(FakeDatabase.getInstance().recipeDao, context)
        return RecipeListViewModelFactory(recipeRepository)
    }
}