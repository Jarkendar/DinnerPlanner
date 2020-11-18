package com.dinnerplanner.ui.recipeList

import android.os.Parcel
import android.os.Parcelable

data class Recipe(
    val imageResourceID: Int,
    val title: String,
    val shortDescription: String,
    val description: String,
    val componentsArray: Array<String>,
    val categoriesArray: Array<String>,
    val instruction: Array<String>,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val spicyLevel: SpicyLevel
) : Parcelable {

    companion object CREATOR : Parcelable.Creator<Recipe> {

        const val RECIPE_KEY = "recipe_key"

        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createStringArray()!!,
        parcel.createStringArray()!!,
        parcel.createStringArray()!!,
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        SpicyLevel.values()[parcel.readInt()]
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResourceID)
        parcel.writeString(title)
        parcel.writeString(shortDescription)
        parcel.writeString(description)
        parcel.writeStringArray(componentsArray)
        parcel.writeStringArray(categoriesArray)
        parcel.writeStringArray(instruction)
        parcel.writeByte(if (vegan) 1 else 0)
        parcel.writeByte(if (vegetarian) 1 else 0)
        parcel.writeInt(spicyLevel.ordinal)
    }

    override fun describeContents(): Int {
        return 0
    }
}