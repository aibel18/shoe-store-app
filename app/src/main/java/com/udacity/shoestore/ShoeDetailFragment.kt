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

        binding.saveButton.setOnClickListener {

            binding.apply {
                addShoe(nameEdit.text?.toString(),  sizeEdit.text?.toString(), companyEdit.text?.toString(), descriptionEdit.text?.toString())
            }
        }

        binding.cancelButton.setOnClickListener{
            backShoeList()
        }

        return binding.root
    }

    private fun addShoe(name: String?, size: String?, company: String?, description: String?) {
        if(name.isNullOrEmpty()) {
            Toast.makeText(this.activity, "the shoe name is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if(size.isNullOrEmpty()) {
            Toast.makeText(this.activity, "the shoe size is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if(company.isNullOrEmpty()) {
            Toast.makeText(this.activity, "the shoe company is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if(description.isNullOrEmpty()) {
            Toast.makeText(this.activity, "the shoe name is empty", Toast.LENGTH_SHORT).show()
            return
        }

        val shoe = Shoe(name,  size.toDouble(), company, description)

        viewModel.addShoe(shoe)

        backShoeList()
    }

    private fun backShoeList() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailToShoeList()
        findNavController().navigate(action)
    }
}