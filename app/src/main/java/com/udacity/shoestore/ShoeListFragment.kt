package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeListViewModel

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

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun createShoeViews(shoes: List<Shoe>) {

        shoes.forEach {shoe: Shoe ->

            val shoeItemBinding : ShoeItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.shoe_item, null, false)

            shoeItemBinding.shoe = shoe

            binding.shoeListLayout.addView(shoeItemBinding.root)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val navController = this.findNavController()
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item)
    }
}