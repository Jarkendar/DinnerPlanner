package com.dinnerplanner.ui.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dinnerplanner.R

class RecipeListFragment : Fragment() {

    private lateinit var recipeListViewModel: RecipeListViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecipeArrayAdapter
    private lateinit var recyclerManager: RecyclerView.LayoutManager

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        recipeListViewModel =
                ViewModelProvider(this).get(RecipeListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recipe_list, container, false)

        recyclerAdapter = RecipeArrayAdapter(requireContext(), emptyArray())

        recipeListViewModel.recipeList.observe(viewLifecycleOwner, Observer {
            recyclerAdapter.update(it)
        })

        recyclerManager = LinearLayoutManager(context)

        recyclerView = root.findViewById<RecyclerView>(R.id.recipe_list).apply {
            setHasFixedSize(true)
            adapter = recyclerAdapter
            layoutManager = recyclerManager
        }
        return root
    }
}