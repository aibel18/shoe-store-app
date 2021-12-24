package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeListViewModel
import kotlinx.android.synthetic.main.shoe_item.view.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

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

        viewModel.shoeList.observe(viewLifecycleOwner, { shoes ->
            createShoeViews(shoes)
        })

        return binding.root
    }

    private fun createShoeViews(shoes: List<Shoe>) {

        shoes.forEach {shoe: Shoe ->

            val shoeItemBinding : ShoeItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.shoe_item, null, false)

            shoeItemBinding.shoe = shoe

            binding.shoeListLayout.addView(shoeItemBinding.root)
        }
    }
}