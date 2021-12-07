package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )
        val welcomeFragmentArgs by navArgs<WelcomeFragmentArgs>()

        val viewModelFactory = AccountViewModelFactory(welcomeFragmentArgs.userName, welcomeFragmentArgs.password)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AccountViewModel::class.java)

        binding.accountViewModel = viewModel

//        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}