package com.dinnerplanner

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dinnerplanner.ui.dashboard.DashboardFragment
import com.dinnerplanner.ui.recipeList.RecipeListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        navView.menu.findItem(R.id.navigation_dashboard).setChecked(true)

        navController.currentDestination?.id
        //todo to change it, it is very simple implementation
        var fragment = Fragment()
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    fragment = RecipeListFragment()
                }
                R.id.navigation_dashboard -> {
                    fragment = DashboardFragment()
                }
            }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
            true
        }

        navView.selectedItemId = R.id.navigation_home//R.id.navigation_dashboard
//        findViewById<View>(R.id.navigation_dashboard).performClick()
//        navView.setOnNavigationItemSelectedListener {
//            Log.d("********", it.toString())
//            return@setOnNavigationItemSelectedListener true
//        }
    }

    public fun addRecipeToList(view: View) {
        //todo open view to add recipe, remove toast
        Toast.makeText(this, "Click FAB", Toast.LENGTH_SHORT).show()
    }
}