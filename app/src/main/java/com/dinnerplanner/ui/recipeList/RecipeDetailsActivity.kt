package com.dinnerplanner.ui.recipeList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dinnerplanner.R

class RecipeDetailsActivity : AppCompatActivity() {

    private lateinit var recipe: Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recipe = intent.getParcelableExtra(Recipe.RECIPE_KEY)!!
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}