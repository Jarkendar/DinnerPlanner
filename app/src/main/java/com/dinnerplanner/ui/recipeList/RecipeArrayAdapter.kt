package com.dinnerplanner.ui.recipeList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dinnerplanner.R

class RecipeArrayAdapter(private val context: Context, var recipeArray: Array<Recipe>): RecyclerView.Adapter<RecipeArrayAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val mTitle: TextView = view.findViewById(R.id.recipe_title)
        val mDescription: TextView = view.findViewById(R.id.recipe_description)
        val mAdditionInfo: TextView = view.findViewById(R.id.recipe_info)
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
            mAdditionInfo.text = "tmp text"
            mRecipeImage.setImageResource(recipeData.imageResourceID)
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(context, recipeData.title, Toast.LENGTH_SHORT).show()
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