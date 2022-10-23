package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListViewModel: ViewModel() {
     lateinit var shoeList:MutableList<Shoe>

    init {
        Log.i("ShoeViewModel","ShoeViewModel Created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeViewModel","ShoeViewModel destroyed! ")
    }

    fun addShoe(shoe: Shoe){
        shoeList.add(shoe)
    }

}