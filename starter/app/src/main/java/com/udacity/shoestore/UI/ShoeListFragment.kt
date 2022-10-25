package com.udacity.shoestore.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoecardBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding

    private lateinit var shoeViewModel:ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShoeListBinding.inflate(inflater,container,false)

        binding.fabAddShoe.setOnClickListener()
        {
            Navigation.findNavController(view!!).navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }
        setMenuVisibility(true)

        return binding.root
    }
    private fun initShoeObserver()
    {
        shoeViewModel.getShoeLiveData().observe(viewLifecycleOwner)
        {
            it?.forEach{
                shoe ->binding.shoeList.addView(getShoeView(shoe))
            }
        }
    }

    private fun getShoeView(shoe: Shoe):View
    {
        val itemBinding=ShoecardBinding.inflate(LayoutInflater.from(context))
        itemBinding.shoe=shoe
        itemBinding.executePendingBindings()
        return itemBinding.root
    }

}








