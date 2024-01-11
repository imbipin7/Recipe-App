package com.bipin.recipieapp.views.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.airbnb.lottie.LottieDrawable
import com.bipin.recipieapp.R
import com.bipin.recipieapp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {
    private var binding: FragmentSplashBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        binding?.lottieAnimationView?.setAnimation(R.raw.splash_anim)
        binding?.lottieAnimationView?.repeatCount = LottieDrawable.INFINITE
        binding?.lottieAnimationView?.playAnimation()

    }

    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed({
            view?.findNavController()?.navigate(R.id.action_splash_to_recipe)
        }, 3000)
    }


}