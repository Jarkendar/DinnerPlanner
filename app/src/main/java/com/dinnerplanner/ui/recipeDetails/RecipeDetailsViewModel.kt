package com.dinnerplanner.ui.recipeDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dinnerplanner.data.MeatStatus
import com.dinnerplanner.data.Recipe
import com.dinnerplanner.data.SpicyLevel

class RecipeDetailsViewModel : ViewModel() {

    val title = MutableLiveData<String>()
    val components = MutableLiveData<Array<String>>()
    val instruction = MutableLiveData<Array<String>>()
    val spicyLevel = MutableLiveData<SpicyLevel>()
    val meatStatus = MutableLiveData<MeatStatus>()
    val vegan = MutableLiveData<Boolean>()
    val vegetarian = MutableLiveData<Boolean>()

    fun setRecipe(recipe: Recipe) {
        title.value = recipe.title
        components.value = recipe.componentsArray
        instruction.value = recipe.instruction
        spicyLevel.value = recipe.spicyLevel
        meatStatus.value = recipe.getMeatStatus()
    }



}