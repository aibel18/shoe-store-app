package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)

        binding.loginButton.setOnClickListener {
            val username = binding.userNameEdit.text.toString()
            val password = binding.passwordEdit.text.toString()

            toWelcome(username, password)
        }

        binding.loginAccountButton.setOnClickListener{
            toWelcome(viewModel.username.value.toString(), viewModel.password.value.toString())
        }

        return binding.root
    }

    private fun toWelcome(username: String, password: String) {
        if(username.isNotEmpty() && password.isNotEmpty()) {
            viewModel.login(username, password)
            val action = LoginFragmentDirections.actionLoginToWelcome(username, password)
            findNavController().navigate(action)
        }
        else{
            Toast.makeText(this.activity, "username or password is invalid", Toast.LENGTH_SHORT).show()
        }
    }
}