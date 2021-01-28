package com.dinnerplanner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dinnerplanner.data.Recipe

class RecipeSetViewModel : ViewModel() {

    val recipeSet = MutableLiveData<HashSet<Recipe>>()

    init {
        recipeSet.value = HashSet()
    }

    fun addRecipe(recipe: Recipe) {
        recipeSet.value!!.add(recipe)
    }

    fun removeRecipe(recipe: Recipe) {
        recipeSet.value!!.remove(recipe)
    }
}