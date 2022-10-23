package com.udacity.shoestore.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater,container,false)
        Log.i("LoginFragment","Called View Model")

        binding.btnOnBoardingNext.setOnClickListener()
        {
            Navigation.findNavController(view!!).navigate(R.id.action_onBoardingFragment_to_instructionsFragment)
        }
        return binding.root
    }

}