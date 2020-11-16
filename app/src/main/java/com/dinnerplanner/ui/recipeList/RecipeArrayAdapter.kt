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
            mRecipeImage.setImageResource(recipeData.imageResourceID)

            mSpicy.setImageResource(when (recipeData.spicyLevel) {
                SpicyLevel.NO_SPICY -> R.drawable.chili_off
                SpicyLevel.MILD -> R.drawable.chili_mild
                SpicyLevel.MEDIUM -> R.drawable.chili_medium
                SpicyLevel.HOT -> R.drawable.chili_hot
            })
            mMeatStatus.setImageResource(when {
                recipeData.vegan && recipeData.vegetarian -> R.drawable.vegan_symbol
                recipeData.vegetarian -> R.drawable.vegetarian_symbol
                else -> R.drawable.meat_symbol
            })
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