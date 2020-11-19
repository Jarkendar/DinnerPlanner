package com.dinnerplanner.data

class RecipeRepository private constructor(private val recipeDao: FakeRecipeDao) {

    fun addRecipe(recipe: Recipe) {
        recipeDao.addRecipe(recipe)
    }

    fun getRecipes() = recipeDao.getRecipes()

    companion object {
        @Volatile
        private var instance: RecipeRepository? = null

        fun getInstance(recipeDao: FakeRecipeDao) = instance ?: synchronized(this) {
            instance ?: RecipeRepository(recipeDao).also { instance = it }
        }
    }
}