package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.viewmodel.AccountViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private val viewModel: AccountViewModel by activityViewModels()

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

        binding.loginButton.setOnClickListener {
            val username = binding.userNameEdit.text.toString()
            val password = binding.passwordEdit.text.toString()

            toWelcome(username, password)
        }

        binding.loginAccountButton.setOnClickListener{
            val username = viewModel.username.value?.toString()
            val password = viewModel.password.value?.toString()

            toWelcome(username, password)
        }

        return binding.root
    }

    private fun toWelcome(username: String?, password: String?) {
        if(username.isNullOrEmpty() || password.isNullOrEmpty()) {
            Toast.makeText(this.activity, "username or password is invalid", Toast.LENGTH_SHORT).show()
            return
        }
        viewModel.setAccount(username, password)
        val action = LoginFragmentDirections.actionLoginToWelcome()
        findNavController().navigate(action)
    }
}