package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel() : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        loadShoeList()
        Log.i("ShoeListViewModel", "ShoeList Created")
    }

    private fun loadShoeList() {

        val shoe1 = Shoe("shoe1", 50.0, "nike", "shoe1")
        val shoe2 = Shoe("shoe2", 45.0, "adidas", "shoe2")
        val shoe3 = Shoe("shoe3", 85.0, "puma", "shoe3")

        _shoeList.value.add(shoe1)
        _shoeList.value.add(shoe2)
        _shoeList.value.add(shoe3)
    }
}