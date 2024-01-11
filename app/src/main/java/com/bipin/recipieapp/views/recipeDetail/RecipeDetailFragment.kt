package com.bipin.recipieapp.views.recipeDetail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bipin.recipieapp.R
import com.bipin.recipieapp.databinding.FragmentRecipeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailFragment : Fragment(R.layout.fragment_recipe_detail) {

    var binding: FragmentRecipeDetailBinding? = null
    private val viewModel: RecipeDetailViewModel by viewModels()

    val args: RecipeDetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipeDetailBinding.bind(view)
        binding?.vm = viewModel

        viewModel.data.set(args.data)

    }
}