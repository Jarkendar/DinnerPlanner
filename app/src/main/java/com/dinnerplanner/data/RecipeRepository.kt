package com.dinnerplanner.data

import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val recipeDao: RecipeDao
) {

    fun addRecipe(recipe: Recipe) {
        recipeDao.addRecipe(recipe)
    }

    fun getRecipes() = recipeDao.getRecipes()

}