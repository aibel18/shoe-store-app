package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_item.view.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var viewModel: ShoeListViewModel

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
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.addButton.setOnClickListener{
            val action = ShoeListFragmentDirections.actionShoeListToShoeDetail()
            findNavController().navigate(action)
        }

        createShoeViews()

        return binding.root
    }

    private fun createShoeViews() {

        viewModel.shoeList.value?.forEach {shoe: Shoe ->

            val shoeItem = View.inflate(context, R.layout.shoe_item, null)

            shoeItem.name_label.text = shoe.name
            shoeItem.company_label.text = shoe.company
            shoeItem.size_label.text = shoe.size.toString()

            binding.shoeListLayout.addView(shoeItem)
        }
    }
}