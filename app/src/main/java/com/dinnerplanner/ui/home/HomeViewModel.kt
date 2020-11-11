package com.dinnerplanner.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _list = MutableLiveData<Array<String>>().apply {
        value = arrayOf("First", "Second", "Third", "Fourth", "Fifth", "Sixth")
    }

    val recipeList: LiveData<Array<String>> = _list
}