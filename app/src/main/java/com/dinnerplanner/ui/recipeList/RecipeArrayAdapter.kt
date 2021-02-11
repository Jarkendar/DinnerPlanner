package com.dinnerplanner.ui.recipeList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.dinnerplanner.R
import com.dinnerplanner.data.Recipe
import com.dinnerplanner.utils.getMeatStatus

class RecipeArrayAdapter(
    private val context: Context,
    var recipeArray: Array<Recipe>,
    private val clickListener: ItemClickListener
) : RecyclerView.Adapter<RecipeArrayAdapter.ViewHolder>() {

    private val filter = Filter(recipeArray)

    interface ItemClickListener {
        fun longClick(recipe: Recipe, isClicked: Boolean)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mBackgroundLayout: ConstraintLayout = view.findViewById(R.id.recipe_container)
        val mTitle: TextView = view.findViewById(R.id.recipe_title)
        val mDescription: TextView = view.findViewById(R.id.recipe_description)
        val mSpicy: ImageView = view.findViewById(R.id.spicy_image)
        val mMeatStatus: ImageView = view.findViewById(R.id.meat_status_image)
        val mRecipeImage: ImageView = view.findViewById(R.id.recipe_image)
        val mDifficultyLevel: ImageView = view.findViewById(R.id.difficulty_image)
        var isClicked: Boolean = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val recipeView = inflater.inflate(R.layout.recipe_list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(recipeView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipeData = recipeArray[position]

        with(holder) {
            mTitle.text = recipeData.title
            mDescription.text = recipeData.shortDescription
            mRecipeImage.setImageResource(
                when (recipeData.imageResourceID) {// TODO to change on image from database
                    1 -> R.color.design_default_color_secondary_variant
                    2 -> R.color.design_default_color_primary
                    3 -> R.color.design_default_color_error
                    4 -> R.color.black
                    5 -> R.color.design_default_color_primary_dark
                    6 -> R.color.design_default_color_secondary
                    else -> R.color.design_default_color_primary_dark
                }
            )

            mSpicy.setImageResource(recipeData.spicyLevel.drawableId)
            mMeatStatus.setImageResource(recipeData.getMeatStatus().drawableID)
            mDifficultyLevel.setImageResource(recipeData.difficultyLevel.drawableId)

            itemView.setOnClickListener {
                RecipeDetailsDialog(recipeData).show(
                    (context as FragmentActivity).supportFragmentManager,
                    "TAG"
                )
            }
            itemView.setOnLongClickListener {
                isClicked = !isClicked
                mBackgroundLayout.setBackgroundResource(if (isClicked) R.color.green else R.color.white)
                clickListener.longClick(recipeData, isClicked)
                return@setOnLongClickListener true
            }
        }
    }

    override fun getItemCount(): Int {
        return recipeArray.size
    }

    fun update(updateArray: Array<Recipe>) {
        filter.sourceArray = updateArray
        recipeArray = updateArray
        notifyDataSetChanged()
    }

    fun filterResults(query: String) {
        recipeArray = filter.performFilter(query)
        notifyDataSetChanged()
    }
}