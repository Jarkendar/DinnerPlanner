package com.dinnerplanner.ui.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
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

//            val recyclerAdapter =
//            recyclerView = rootView.findViewById<RecyclerView>(R.id.component_list).apply {
//                setHasFixedSize(true)
//                adapter = recyclerAdapter
//            }

            component_list.layoutManager = LinearLayoutManager(context)
            component_list.adapter = ComponentArrayAdapter(recipe.componentList.toTypedArray())

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