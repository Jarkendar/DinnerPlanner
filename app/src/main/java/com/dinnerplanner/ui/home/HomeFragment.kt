package com.dinnerplanner.ui.home

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

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecipeArrayAdapter
    private lateinit var recyclerManager: RecyclerView.LayoutManager

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerAdapter = RecipeArrayAdapter(requireContext(), emptyArray())

        homeViewModel.recipeList.observe(viewLifecycleOwner, Observer {
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