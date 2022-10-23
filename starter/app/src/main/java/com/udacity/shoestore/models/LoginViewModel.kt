package com.udacity.shoestore.models

import android.text.Editable
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginViewModel:ViewModel() {

    lateinit var binding:FragmentLoginBinding
    init {
        Log.i("LoginViewModel","LoginViewModel Created")
    }
     fun isEmailValid(email:String):Boolean {
        var reg=Regex("^\\w+@[a-zA-z_]+?\\.[a-zA-Z]{2,3}$")
        return (email.matches(reg))
    }
     fun isPasswordValid(password:String):Boolean{
        return (!password.isEmpty())
    }



}