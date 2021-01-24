package com.dinnerplanner.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dinnerplanner.Database
import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import javax.inject.Inject

class RecipeDao @Inject constructor(appContext: Context) {

    private val recipeList = mutableListOf<Recipe>()

    private val recipes = MutableLiveData<List<Recipe>>()
    private var recipeQueries: RecipeQueries

    init {
        val driver: SqlDriver = AndroidSqliteDriver(Database.Schema, appContext, "test.db")

        val listOfStringsAdapter = object : ColumnAdapter<List<String>, String> {
            override fun decode(databaseValue: String) = databaseValue.split(",")
            override fun encode(value: List<String>) = value.joinToString(separator = ",")
        }

        val database = Database(
            driver,
            RecipeAdapter = Recipe.Adapter(
                componentListAdapter = listOfStringsAdapter,
                categoriesArrayAdapter = listOfStringsAdapter,
                instructionAdapter = listOfStringsAdapter,
                spicyLevelAdapter = EnumColumnAdapter()
            )
        )

        recipeQueries = database.recipeQueries

        recipeQueries.initDatabase()
        println(recipeQueries.selectAll().executeAsList())

        recipes.value = recipeQueries.selectAll().executeAsList()
    }

    fun addRecipe(recipe: Recipe) {
        recipeList.add(recipe)
        recipes.value = recipeList
    }

    fun getRecipes() = recipes as LiveData<List<Recipe>>
}