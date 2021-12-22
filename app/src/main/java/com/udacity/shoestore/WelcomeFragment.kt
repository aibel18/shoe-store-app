package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.WelcomeFragmentBinding
import com.udacity.shoestore.viewmodel.AccountViewModel

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding
    private val viewModel: AccountViewModel by activityViewModels()

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

        binding.accountViewModel = viewModel

        binding.startButton.setOnClickListener{
            val action = WelcomeFragmentDirections.actionWelcomeToInstruction()
            findNavController().navigate(action)
        }

        return binding.root
    }
}