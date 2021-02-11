package com.dinnerplanner.ui.recipeList

import com.dinnerplanner.data.Recipe
import java.util.*

class Filter(var sourceArray: Array<Recipe>) : IRecipeFilter {

    override fun performFilter(query: String): Array<Recipe> {
        return sourceArray.filter { recipe ->
            recipe.title.toLowerCase(Locale.getDefault())
                .contains(query.toLowerCase(Locale.getDefault()))
        }.toTypedArray()
    }
}