package com.udacity.shoestore.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeListFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding = FragmentShoeListBinding.inflate(inflater,container,false)

        binding.fabAddShoe.setOnClickListener()
        {
            Navigation.findNavController(view!!).navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }

        return binding.root
    }

}