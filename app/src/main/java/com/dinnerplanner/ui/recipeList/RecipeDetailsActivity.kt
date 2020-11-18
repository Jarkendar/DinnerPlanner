package com.dinnerplanner.ui.recipeList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dinnerplanner.R
import com.dinnerplanner.databinding.ActivityRecipeDetailsBinding

class RecipeDetailsActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRecipeDetailsBinding

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

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.activity_recipe_details,
            container,
            false
        )
        binding.setViewModel(viewModel)

//        // Required to update UI with LiveData
//        binding.setLifecycleOwner(this)

//        recipe =
//        initializeView()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initializeView() {

    }
}