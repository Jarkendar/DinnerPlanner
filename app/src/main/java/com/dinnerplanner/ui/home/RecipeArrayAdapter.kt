package com.dinnerplanner.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dinnerplanner.R

class RecipeArrayAdapter(val context: Context, private var data: Array<String>): RecyclerView.Adapter<RecipeArrayAdapter.ViewHolder>() {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val recipeView = inflater.inflate(R.layout.recipe_item, parent, false)
        // Return a new holder instance
        return ViewHolder(recipeView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun update(updateArray: Array<String>){
        this.data = updateArray
        notifyDataSetChanged()
    }
}