package com.dinnerplanner.ui.recipeList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dinnerplanner.R
import com.dinnerplanner.data.Ingredient

class ComponentArrayAdapter(private val ingredientArray: Array<Ingredient>) :
    RecyclerView.Adapter<ComponentArrayAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mName: TextView = view.findViewById(R.id.ingredient_name)
        val mAmount: TextView = view.findViewById(R.id.ingredient_amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val componentView = inflater.inflate(R.layout.components_list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(componentView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ingredient = ingredientArray[position]
        with(holder) {
            mName.text = ingredient.name
            val amountString = "${ingredient.quantity}${ingredient.unit}"
            mAmount.text = amountString
        }
    }

    override fun getItemCount(): Int {
        return ingredientArray.size
    }
}