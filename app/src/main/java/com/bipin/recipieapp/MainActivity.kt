package com.bipin.recipieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.bipin.recipieapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = findNavController(R.id.fragmentMain)


        binding?.bottomNav?.setOnItemSelectedListener { item ->
            if (item.itemId != navController.currentDestination!!.id) {
                when (item.itemId) {
                    R.id.recipe -> navController.navigate(R.id.recipe)
                    R.id.search -> navController.navigate(R.id.search)
                    R.id.keep -> navController.navigate(R.id.keep)
                    R.id.myPage -> navController.navigate(R.id.myPage)
                }
            }
            true
        }

        navController?.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.recipe ||
                destination.id == R.id.search ||
                destination.id == R.id.keep ||
                destination.id == R.id.myPage
            ) {
                binding?.bottomNav?.selectedItemId = destination.id
                binding.bottomNav.isVisible = true
            } else {
                binding.bottomNav.isVisible = false

            }

        }
    }
}