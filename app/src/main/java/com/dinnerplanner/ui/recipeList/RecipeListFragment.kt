package com.dinnerplanner.ui.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dinnerplanner.R
import com.dinnerplanner.data.Recipe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RecipeListFragment : Fragment(), RecipeArrayAdapter.ItemClickListener {

    @Inject
    lateinit var recipeListViewModel: RecipeListViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecipeArrayAdapter
    private lateinit var recyclerManager: RecyclerView.LayoutManager

    val recipeSet = mutableSetOf<Recipe>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_recipe_list, container, false)

        recyclerAdapter = RecipeArrayAdapter(requireActivity(), emptyArray(), this)

        recipeListViewModel.getRecipes().observe(viewLifecycleOwner, Observer {
            recyclerAdapter.update(it.toTypedArray())
        })

        recyclerManager = GridLayoutManager(
            context,
            2
        )//recyclerManager = LinearLayoutManager(context) TODO grid or linear -> consider

        recyclerView = root.findViewById<RecyclerView>(R.id.recipe_list).apply {
            setHasFixedSize(true)
            adapter = recyclerAdapter
            layoutManager = recyclerManager
        }
        return root
    }

    override fun longClick(recipe: Recipe, isClicked: Boolean) {
        if (isClicked) {
            recipeSet.add(recipe)
        } else {
            recipeSet.remove(recipe)
        }
    }
}