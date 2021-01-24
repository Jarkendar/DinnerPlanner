package com.dinnerplanner.ui.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.dinnerplanner.R
import com.dinnerplanner.data.MeatStatus
import com.dinnerplanner.data.Recipe
import com.dinnerplanner.data.SpicyLevel
import com.dinnerplanner.utils.getMeatStatus
import kotlinx.android.synthetic.main.activity_recipe_details.view.*
import kotlinx.android.synthetic.main.components_list.view.*

class RecipeDetailsDialog(private val recipe: Recipe) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_recipe_details, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupClickListeners(view)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView(view: View) {
        with(view) {
            details_title.text = recipe.title
            details_components.text = recipe.componentList.joinToString("\n")
            details_preparing.text = recipe.instruction.joinToString("\n")
            when (recipe.spicyLevel) {
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
            when (recipe.getMeatStatus()) {
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
        }
    }

    private fun setupClickListeners(view: View) {
        view.close_button.setOnClickListener {
            dismiss()
        }
    }
}