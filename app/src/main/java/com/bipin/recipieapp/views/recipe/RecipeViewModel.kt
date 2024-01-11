package com.bipin.recipieapp.views.recipe

import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.bipin.recipieapp.R
import com.bipin.recipieapp.adapter.RecyclerAdapter
import com.bipin.recipieapp.model.MaterialsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor() : ViewModel() {
    val adapter by lazy { RecyclerAdapter<MaterialsItem>(R.layout.item_food_single) }
    val adapterRecommend by lazy { RecyclerAdapter<MaterialsItem>(R.layout.item_food_horizontal) }


    val adapterClick = RecyclerAdapter.OnItemClick { view, viewHolder, type ->
        when (view.id) {
            R.id.clItem -> {
                view.findNavController().navigate(
                    RecipeFragmentDirections.actionRecipeToRecipeDetail(
                        adapter.getItemAt(viewHolder?.adapterPosition ?: 0)
                    )
                )
            }
        }
    }
    val adapterRecommendClick = RecyclerAdapter.OnItemClick { view, viewHolder, type ->
        when (view.id) {
            R.id.clItem -> {
                view.findNavController().navigate(
                    RecipeFragmentDirections.actionRecipeToRecipeDetail(
                        adapter.getItemAt(viewHolder?.adapterPosition ?: 0)
                    )
                )
            }
        }
    }

    init {


    }

}