package com.dinnerplanner.data

import android.content.Context
import com.dinnerplanner.Database
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val recipeDao: FakeRecipeDao,
    appContext: Context
) {

    init {
        val driver: SqlDriver = AndroidSqliteDriver(Database.Schema, appContext, "test.db")

        val database = Database(driver)

        val playerQueries: TestDatabaseQueries = database.testDatabaseQueries

        println(playerQueries.selectAll().executeAsList())

        playerQueries.insertTest()
        println(playerQueries.selectAll().executeAsList())
    }

    fun addRecipe(recipe: Recipe) {
        recipeDao.addRecipe(recipe)
    }

    fun getRecipes() = recipeDao.getRecipes()

}