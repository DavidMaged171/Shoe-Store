package com.udacity.shoestore.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.ShoeViewModel


class ShoeDetailsFragment : Fragment() {
    lateinit var binding:FragmentShoeDetailsBinding
    lateinit var viewModel: ShoeViewModel
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentShoeDetailsBinding.inflate(inflater, container, false)

        binding.shoeData=viewModel
        binding.lifecycleOwner=this

        binding.btnDetailsSave.setOnClickListener()
        {
           if (viewModel.isNewShoeValid())
           {
                viewModel.addShoe(viewModel.newShoe)
           }
        }
        binding.btnCancel.setOnClickListener()
        {
            Navigation.findNavController(view!!).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }
        return binding.root
    }
}