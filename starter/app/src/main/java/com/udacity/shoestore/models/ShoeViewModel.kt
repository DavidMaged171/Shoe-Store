package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel(){
    lateinit var newShoe:Shoe

    private val shoeLiveData=MutableLiveData<MutableList<Shoe>?>(mutableListOf())

    fun addShoe(shoe: Shoe)
    {
        shoeLiveData.value?.add(shoe)
        shoeLiveData.value=shoeLiveData.value
    }

    private fun isShoeDataValid (input: String?):Boolean
    {
        return !input.isNullOrEmpty()
    }
    fun getShoeLiveData():LiveData<MutableList<Shoe>?>
    {
        return shoeLiveData
    }
    fun isNewShoeValid():Boolean
    {
        return newShoe.let {
            isShoeDataValid(it.name)&&isShoeDataValid(it.company)&&isShoeDataValid(it.size.toString())
        }
    }
}