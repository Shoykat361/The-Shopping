package com.shoykat.theshopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.shoykat.theshopping.ViewModel.LoginViewModel
import com.shoykat.theshopping.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {
    private lateinit var binding:FragmentSignupBinding
    private val loginViewModel: LoginViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentSignupBinding.inflate(inflater,container,false)
        loginViewModel.authStateLD.observe(viewLifecycleOwner) {
            if (it == LoginViewModel.AuthState.AUTHENTICATED) {
                findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
            }
        }
        loginViewModel.errMsgLD.observe(viewLifecycleOwner) {
            //binding.errorMsg.text = it
        }
        binding.signUpBtnSignUpPage.setOnClickListener {
            val email = binding.emailEtSignUpPage.text.toString()
            val password = binding.PassEtSignUpPage .text.toString()
            loginViewModel.registerUser(email,password)

        }
        return binding.root
    }

}