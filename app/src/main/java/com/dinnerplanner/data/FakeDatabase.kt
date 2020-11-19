package com.dinnerplanner.data

class FakeDatabase private constructor() {

    var recipeDao = FakeRecipeDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}