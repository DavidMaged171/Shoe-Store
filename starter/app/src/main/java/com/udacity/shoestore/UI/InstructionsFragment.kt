package com.udacity.shoestore.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentOnBoardingBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionsBinding.inflate(inflater,container,false)
        Log.i("LoginFragment","Called View Model")

        binding.btnInstructionNext.setOnClickListener()
        {
            Navigation.findNavController(view!!).navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }


        return binding.root
    }


}