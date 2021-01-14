package com.dinnerplanner.utils

import android.content.Context
import com.dinnerplanner.data.RecipeDao
import com.dinnerplanner.data.RecipeRepository
import com.dinnerplanner.ui.recipeDetails.RecipeDetailsViewModel
import com.dinnerplanner.ui.recipeList.RecipeListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class HiltInjector {

    @Singleton
    @Provides
    fun provideRecipeRepository(@ApplicationContext appContext: Context): RecipeRepository =
        RecipeRepository(RecipeDao(appContext))

    @Singleton
    @Provides
    fun provideRecipeListViewModel(recipeRepository: RecipeRepository): RecipeListViewModel =
        RecipeListViewModel(recipeRepository)

    @Singleton
    @Provides
    fun provideRecipeDetailsViewModel() = RecipeDetailsViewModel()
}