package com.dinnerplanner.ui.recipeDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dinnerplanner.R
import com.dinnerplanner.data.MeatStatus
import com.dinnerplanner.data.Recipe
import com.dinnerplanner.data.SpicyLevel
import kotlinx.android.synthetic.main.activity_recipe_details.*

class RecipeDetailsActivity() : AppCompatActivity() {


    private lateinit var viewModel: RecipeDetailsViewModel
    private lateinit var viewModelFactory: RecipeDetailsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModelFactory =
            RecipeDetailsViewModelFactory(intent.getParcelableExtra(Recipe.RECIPE_KEY)!!)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(RecipeDetailsViewModel::class.java)

        initializeView(this)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initializeView(activity: RecipeDetailsActivity) {
        with(viewModel) {
            title.observe(activity, Observer { t -> details_title.text = t })
            components.observe(activity, Observer { components ->
                details_components.text = components.joinToString("\n")
            })
            instruction.observe(activity, Observer { instruction ->
                details_preparing.text = instruction.joinToString("\n")
            })
            spicyLevel.observe(activity, Observer { spicyLevel ->
                when (spicyLevel!!) {
                    SpicyLevel.NO_SPICY -> {
                        details_spicy.text = "NO SPICY"
                        details_spicy_icon.setImageResource(R.drawable.chili_off)
                    }
                    SpicyLevel.MILD -> {
                        details_spicy.text = "MILD"
                        details_spicy_icon.setImageResource(R.drawable.chili_mild)
                    }
                    SpicyLevel.MEDIUM -> {
                        details_spicy.text = "MEDIUM"
                        details_spicy_icon.setImageResource(R.drawable.chili_medium)
                    }
                    SpicyLevel.HOT -> {
                        details_spicy.text = "HOT"
                        details_spicy_icon.setImageResource(R.drawable.chili_hot)
                    }
                }
            })
            meatStatus.observe(activity, Observer { meatStatus ->
                when (meatStatus!!) {
                    MeatStatus.VEGAN -> {
                        details_meat_status.text = "VEGAN"
                        details_meat_status_icon.setImageResource(R.drawable.vegan_symbol)
                    }
                    MeatStatus.VEGETARIAN -> {
                        details_meat_status.text = "VEGETARIAN"
                        details_meat_status_icon.setImageResource(R.drawable.vegetarian_symbol)
                    }
                    MeatStatus.MEAT -> {
                        details_meat_status.text = "MEAT"
                        details_meat_status_icon.setImageResource(R.drawable.meat_symbol)
                    }
                }
            })
        }
    }
}