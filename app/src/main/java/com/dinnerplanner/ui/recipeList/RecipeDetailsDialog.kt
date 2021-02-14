package com.dinnerplanner.ui.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.dinnerplanner.R
import com.dinnerplanner.data.Recipe
import com.dinnerplanner.utils.getMeatStatus
import kotlinx.android.synthetic.main.components_list.view.*
import kotlinx.android.synthetic.main.dialog_recipe_details.view.*

class RecipeDetailsDialog(private val recipe: Recipe) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_recipe_details, container, false)

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
            details_components.text =
                recipe.componentList.joinToString("\n") { ingredient -> ingredient.name }
            details_preparing.text = recipe.instruction.joinToString("\n")
            details_spicy.text = resources.getText(recipe.spicyLevel.stringId)
            details_spicy_icon.setImageResource(recipe.spicyLevel.drawableId)
            details_difficulty.text = resources.getText(recipe.difficultyLevel.stringId)
            details_difficulty_icon.setImageResource(recipe.difficultyLevel.drawableId)
            with(recipe.getMeatStatus()) {
                details_meat_status.text = resources.getText(this.stringId)
                details_meat_status_icon.setImageResource(this.drawableID)
            }
        }
    }

    private fun setupClickListeners(view: View) {
        view.close_button.setOnClickListener {
            dismiss()
        }
    }
}