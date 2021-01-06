package com.dinnerplanner.ui.recipeList

import androidx.lifecycle.ViewModel
import com.dinnerplanner.data.Recipe
import com.dinnerplanner.data.RecipeRepository

class RecipeListViewModel constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {

    fun getRecipes() = recipeRepository.getRecipes()

    fun addRecipe(recipe: Recipe) = recipeRepository.addRecipe(recipe)
}