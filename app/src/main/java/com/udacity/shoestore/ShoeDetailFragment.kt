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
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private val viewModel: ShoeListViewModel by activityViewModels()
    private var myShoe : Shoe = Shoe("", 0.0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_detail_fragment,
            container,
            false
        )

        binding.shoe = myShoe

        binding.saveButton.setOnClickListener {

            binding.apply {
                addShoe()
            }
        }

        binding.cancelButton.setOnClickListener{
            backShoeList()
        }

        return binding.root
    }

    private fun addShoe() {
        if(myShoe.name.isEmpty()) {
            Toast.makeText(this.activity, "the shoe name is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if(myShoe.size == 0.0) {
            Toast.makeText(this.activity, "the shoe size is 0.0", Toast.LENGTH_SHORT).show()
            return
        }
        if(myShoe.company.isEmpty()) {
            Toast.makeText(this.activity, "the shoe company is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if(myShoe.description.isEmpty()) {
            Toast.makeText(this.activity, "the shoe description is empty", Toast.LENGTH_SHORT).show()
            return
        }
        viewModel.addShoe(myShoe)

        backShoeList()
    }

    private fun backShoeList() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailToShoeList()
        findNavController().navigate(action)
    }
}