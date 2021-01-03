package com.dinnerplanner.data

import android.content.Context
import com.dinnerplanner.Database
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

class RecipeRepository private constructor(private val recipeDao: FakeRecipeDao) {

    fun addRecipe(recipe: Recipe) {
        recipeDao.addRecipe(recipe)
    }

    fun getRecipes() = recipeDao.getRecipes()

    companion object {
        @Volatile
        private var instance: RecipeRepository? = null

        fun getInstance(recipeDao: FakeRecipeDao, context: Context) =
            instance ?: synchronized(this) {
                val driver: SqlDriver = AndroidSqliteDriver(Database.Schema, context, "test.db")

                val database = Database(driver)

                val playerQueries: TestDatabaseQueries = database.testDatabaseQueries

                println(playerQueries.selectAll().executeAsList())

                playerQueries.insertTest()
                println(playerQueries.selectAll().executeAsList())
                instance ?: RecipeRepository(recipeDao).also { instance = it }
            }
    }
}