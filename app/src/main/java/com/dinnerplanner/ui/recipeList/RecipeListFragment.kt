package com.dinnerplanner.ui.recipeList

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dinnerplanner.R
import com.dinnerplanner.RecipeSetViewModel
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

    private val recipeSet: RecipeSetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_recipe_list, container, false)
        setHasOptionsMenu(true)

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_menu, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val searchBar = menu.findItem(R.id.bar_search).actionView as SearchView
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                recyclerAdapter.filterResults(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                recyclerAdapter.filterResults(newText)
                return false
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.filter_menu -> Toast.makeText(context, "Clicked filters menu", Toast.LENGTH_SHORT)
                .show() //todo do something

        }
        return super.onOptionsItemSelected(item)
    }

    override fun longClick(recipe: Recipe, isClicked: Boolean) {
        if (isClicked) {
            recipeSet.addRecipe(recipe)
        } else {
            recipeSet.removeRecipe(recipe)
        }
    }
}