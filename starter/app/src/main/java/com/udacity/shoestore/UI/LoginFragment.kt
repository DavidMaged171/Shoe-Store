package com.udacity.shoestore.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.LoginViewModel

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding:FragmentLoginBinding
    private lateinit var viewModel:LoginViewModel

    //Inflating and Returning the View with DataBindingUtil
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
          binding = FragmentLoginBinding.inflate(inflater,container,false)
        Log.i("LoginFragment","Called View Model")

        binding.btnLogin.setOnClickListener()
        {
            if (isLoginDataValid())
            {
                Navigation.findNavController(view!!).navigate(R.id.action_loginFragment_to_onBoardingFragment)
            }
        }
        binding.btnSignUp.setOnClickListener()
        {
            if (isLoginDataValid())
            {
                Navigation.findNavController(view!!).navigate(R.id.action_loginFragment_to_onBoardingFragment)
            }
        }


        viewModel=ViewModelProvider(this).get(LoginViewModel::class.java)
        return binding.root
    }

    private fun getEmail():String
    {
        return binding.edittextEmail.text.toString()
    }
    private fun getPassword():String{
        return binding.edittextPassword.text.toString()
    }
    private fun isLoginDataValid():Boolean{
        var isDataValid:Boolean=true
        if(!viewModel.isEmailValid(getEmail()))
        {
            binding.edittextEmail.setError("Enter a valid email address")
            isDataValid=false
        }
        if(! viewModel.isPasswordValid(getPassword()))
        {
            binding.edittextPassword.setError("Enter a valid password")
            isDataValid=false
        }
        return isDataValid
    }
}