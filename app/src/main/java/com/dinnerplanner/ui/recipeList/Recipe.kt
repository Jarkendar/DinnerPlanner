package com.dinnerplanner.ui.recipeList

data class Recipe(val imageResourceID: Int,
             val title: String,
             val shortDescription: String,
             val description: String,
             val componentsArray: Array<String>,
             val categoriesArray: Array<String>,
             val vegan: Boolean,
             val vegetarian: Boolean,
             val spicyLevel: Int)