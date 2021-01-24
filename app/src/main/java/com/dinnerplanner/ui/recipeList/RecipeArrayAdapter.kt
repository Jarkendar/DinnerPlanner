package com.dinnerplanner.ui.recipeList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dinnerplanner.R
import com.dinnerplanner.data.MeatStatus
import com.dinnerplanner.data.Recipe
import com.dinnerplanner.data.SpicyLevel
import com.dinnerplanner.ui.recipeDetails.RecipeDetailsActivity
import com.dinnerplanner.utils.getMeatStatus

class RecipeArrayAdapter(private val context: Context, var recipeArray: Array<Recipe>): RecyclerView.Adapter<RecipeArrayAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val mTitle: TextView = view.findViewById(R.id.recipe_title)
        val mDescription: TextView = view.findViewById(R.id.recipe_description)
        val mSpicy: ImageView = view.findViewById(R.id.spicy_image)
        val mMeatStatus: ImageView = view.findViewById(R.id.meat_status_image)
        val mRecipeImage: ImageView = view.findViewById(R.id.recipe_image)
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

            mSpicy.setImageResource(
                when (recipeData.spicyLevel) {
                    SpicyLevel.NO_SPICY -> R.drawable.chili_off
                    SpicyLevel.MILD -> R.drawable.chili_mild
                    SpicyLevel.MEDIUM -> R.drawable.chili_medium
                    SpicyLevel.HOT -> R.drawable.chili_hot
                }
            )
            mMeatStatus.setImageResource(
                when (recipeData.getMeatStatus()) {
                    MeatStatus.VEGAN -> R.drawable.vegan_symbol
                    MeatStatus.VEGETARIAN -> R.drawable.vegetarian_symbol
                    MeatStatus.MEAT -> R.drawable.meat_symbol
                }
            )
        }

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, RecipeDetailsActivity::class.java)
                    .apply { putExtra(Recipe.RECIPE_KEY, recipeData) })
        }
    }

    override fun getItemCount(): Int {
        return recipeArray.size
    }

    fun update(updateArray: Array<Recipe>){
        this.recipeArray = updateArray
        notifyDataSetChanged()
    }
}