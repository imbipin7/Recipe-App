package com.bipin.recipieapp.views.keep

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bipin.recipieapp.R
import com.bipin.recipieapp.databinding.FragmentKeepBinding
import com.bipin.recipieapp.model.MaterialsItem
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KeepFragment : Fragment(R.layout.fragment_keep) {

    var binding: FragmentKeepBinding? = null
    private val viewModel: KeepViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentKeepBinding.bind(view)
        binding?.vm = viewModel

        val list = listOf(
            MaterialsItem(name = "Cheese", quantity = "1", img = ContextCompat.getDrawable(requireActivity(), R.drawable.pexels_alleksana_5949888)),
            MaterialsItem(name = "Tomato", quantity = "10g", img = ContextCompat.getDrawable(requireActivity(), R.drawable.pexels_cottonbro_studio_4057698)),
            MaterialsItem(name = "Spaghetti", quantity = "50g", img = ContextCompat.getDrawable(requireActivity(), R.drawable.pexels_kate_romeo_2425705)),
            MaterialsItem(name = "Pizza", quantity = "200g", img = ContextCompat.getDrawable(requireActivity(), R.drawable.pexels_nataliya_vaitkevich_5792322)),
            MaterialsItem(name = "Salad", quantity = "2 sheets", img = ContextCompat.getDrawable(requireActivity(), R.drawable.pexels_valeria_boltneva_1510714)),
        )

        viewModel.adapter.addItems(list)
        viewModel.adapter.setOnItemClick(viewModel.adapterClick)

        binding?.collapsingToolbar?.setCollapsedTitleTypeface(Typeface.SANS_SERIF);

        binding?.toolbar?.setOnClickListener {
            val isExpanded = binding?.appBarLayout?.height == 0
            binding?.appBarLayout?.setExpanded(!isExpanded, true)
            binding?.nestedScrollView?.smoothScrollTo(0, 0)
        }

    }
}