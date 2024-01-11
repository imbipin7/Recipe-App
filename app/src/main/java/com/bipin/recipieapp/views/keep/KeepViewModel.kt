package com.bipin.recipieapp.views.keep

import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.bipin.recipieapp.R
import com.bipin.recipieapp.adapter.RecyclerAdapter
import com.bipin.recipieapp.model.MaterialsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KeepViewModel @Inject constructor() : ViewModel() {

    val adapter by lazy { RecyclerAdapter<MaterialsItem>(R.layout.item_food) }


    val adapterClick = RecyclerAdapter.OnItemClick { view, viewHolder, type ->
        when (view.id) {
            R.id.cvItem -> {
                view.findNavController().navigate(
                    KeepFragmentDirections.actionKeepToRecipeDetail(
                        adapter.getItemAt(viewHolder?.adapterPosition ?: 0)
                    )
                )
            }
        }
    }

    init {

    }
}