package com.shoykat.theshopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.shoykat.theshopping.ViewModel.LoginViewModel
import com.shoykat.theshopping.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentLoginBinding.inflate(inflater,container,false)
        loginViewModel.authStateLD.observe(viewLifecycleOwner) {
            if (it == LoginViewModel.AuthState.AUTHENTICATED) {
                findNavController().navigate(R.id.action_loginFragment_to_homePageFragment)
            }
        }
        loginViewModel.errMsgLD.observe(viewLifecycleOwner) {
            binding.errMsg.text = it
        }
        binding.loginBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.PassEt.text.toString()
            // TODO: validate fields
            loginViewModel.loginUser(email, password)
            //findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }



        return binding.root
    }

}