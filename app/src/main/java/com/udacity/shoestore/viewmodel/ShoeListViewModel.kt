package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel() : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        loadShoeList()
        Timber.i("ShoeList Created")
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }

    private fun loadShoeList() {

        _shoeList.value = ArrayList()

        val shoe1 = Shoe("shoe1", 50.0, "nike", "shoe1")
        val shoe2 = Shoe("shoe2", 45.0, "addidas", "shoe2")
        val shoe3 = Shoe("shoe3", 85.0, "puma", "shoe3")

        _shoeList.value?.add(shoe1)
        _shoeList.value?.add(shoe2)
        _shoeList.value?.add(shoe3)
    }
}