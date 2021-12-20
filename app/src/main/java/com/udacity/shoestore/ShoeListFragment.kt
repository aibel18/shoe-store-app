package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_fragment,
            container,
            false
        )

        binding.addButton.setOnClickListener{
            val action = ShoeListFragmentDirections.actionShoeListToShoeDetail()
            findNavController().navigate(action)
        }

        return binding.root
    }
}