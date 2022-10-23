package com.udacity.shoestore.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel


class ShoeDetailsFragment : Fragment() {
    lateinit var binding:FragmentShoeDetailsBinding
    lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentShoeDetailsBinding.inflate(inflater, container, false)
        binding.btnDetailsSave.setOnClickListener()
        {
            if (validateShoeData())
            {
                var shoe:Shoe=setShoe()

                viewModel.shoeList.add(shoe)
                Navigation.findNavController(view!!).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
            }

        }
        binding.btnCancel.setOnClickListener()
        {
            Navigation.findNavController(view!!).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
        }
        return binding.root
    }
    private fun setShoe():Shoe{
        var shoe: Shoe= Shoe(
            name = binding.txtDetailsName.text.toString(),
            size = binding.txtDetailsSize.text.toString().toDouble(),
            description = binding.txtDetailsDescription.text.toString(),
            company = binding.txtDetailsBrand.text.toString()
        )
        return shoe

    }
    private fun validateShoeData ():Boolean
    {
        var isDataValid:Boolean=true
        if(binding.txtDetailsName.text.isEmpty())
        {
            binding.txtDetailsName.setError("Enter Valid Name")
            isDataValid=false
        }
        if(binding.txtDetailsBrand.text.isEmpty())
        {
            binding.txtDetailsBrand.setError("Enter a valid brand")
            isDataValid=false
        }
        if (binding.txtDetailsSize.text.isEmpty())
        {
            binding.txtDetailsSize.setError("Please, set the size")
            isDataValid=false
        }
        return isDataValid

    }

}