package com.bipin.recipieapp.views.recipeDetail

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.bipin.recipieapp.R
import com.bipin.recipieapp.adapter.RecyclerAdapter
import com.bipin.recipieapp.model.MaterialsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor() : ViewModel() {

    val adapter by lazy { RecyclerAdapter<MaterialsItem>(R.layout.item_materials) }
    var data: ObservableField<MaterialsItem> = ObservableField()


    var list = listOf(
        MaterialsItem(name = "Tomato", quantity = "1", img = null),
        MaterialsItem(name = "salt", quantity = "10g", img = null),
        MaterialsItem(name = "pepper", quantity = "50g", img = null),
        MaterialsItem(name = "spaghetti", quantity = "200g", img = null),
        MaterialsItem(name = "herbs", quantity = "2 sheets", img = null),
        MaterialsItem(name = "Tomato", quantity = "1", img = null),
        MaterialsItem(name = "salt", quantity = "10g", img = null),
        MaterialsItem(name = "pepper", quantity = "50g", img = null),
        MaterialsItem(name = "spaghetti", quantity = "200g", img = null),
        MaterialsItem(name = "herbs", quantity = "2 sheets", img = null),
        MaterialsItem(name = "Tomato", quantity = "1", img = null),
        MaterialsItem(name = "salt", quantity = "10g", img = null),
        MaterialsItem(name = "pepper", quantity = "50g", img = null),
        MaterialsItem(name = "spaghetti", quantity = "200g", img = null),
        MaterialsItem(name = "herbs", quantity = "2 sheets", img = null),
    )

    init {
        adapter.addItems(list)

    }
}