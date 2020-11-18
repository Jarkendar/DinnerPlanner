package com.dinnerplanner.ui.recipeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dinnerplanner.R

class RecipeListViewModel : ViewModel() {

    private val _list = MutableLiveData<Array<Recipe>>().apply {
        value = arrayOf(
            Recipe(
                R.color.black,
                "Ciasto",
                "Słodki wypiek",
                "Zawiera dużo cukru",
                arrayOf("cukier", "mąka", "miłość"),
                arrayOf("słodkie"),
                arrayOf("1", "2", "3"),
                true,
                true,
                SpicyLevel.NO_SPICY
            ),
            Recipe(
                R.color.design_default_color_error,
                "Naleśnik",
                "Słodki placek",
                "Najlepiej podać z bananem i nutellą",
                arrayOf("cukier", "mąka", "jajka", "mleko", "woda"),
                arrayOf("słodkie", "smażone"),
                arrayOf("1", "2", "3"),
                false,
                true,
                SpicyLevel.NO_SPICY
            ),
            Recipe(
                R.color.design_default_color_primary_dark,
                "Ziemniaki",
                "Zwykłe polskie danie",
                "Nie gotowane trują",
                arrayOf("ziemniaki"),
                arrayOf("obiad"),
                arrayOf("1", "2", "3"),
                true,
                true,
                SpicyLevel.NO_SPICY
            ),
            Recipe(
                R.color.design_default_color_primary,
                "Pomidory",
                "Czerwone jagody",
                "Podawać z dużą ilością słodkiej śmietany",
                arrayOf("pomidory", "śmietana", "sól", "pieprz"),
                arrayOf("obiad", "kolacja", "pycha"),
                arrayOf("1", "2", "3"),
                false,
                true,
                SpicyLevel.HOT
            ),
            Recipe(
                R.color.design_default_color_secondary,
                "Mięsko",
                "Pożywienie godne człowieka wyprostowanego",
                "Przed wykonaniem zabij",
                arrayOf("mięso", "sos"),
                arrayOf("obiad"),
                arrayOf("1", "2", "3"),
                false,
                false,
                SpicyLevel.MEDIUM
            ),
            Recipe(
                R.color.design_default_color_secondary_variant,
                "Pyzy",
                "Te prawdziwe bez mięsa",
                "A może frytki do tego",
                arrayOf("mąka", "drożdże", "woda", "czas"),
                arrayOf("obiad", "kolacja", "pycha", "w dużej ilości"),
                arrayOf("1", "2", "3"),
                true,
                true,
                SpicyLevel.MILD
            )
        )
    }

    val recipeList: LiveData<Array<Recipe>> = _list
}