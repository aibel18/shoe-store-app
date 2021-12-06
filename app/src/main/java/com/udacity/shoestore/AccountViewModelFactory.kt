package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AccountViewModelFactory(private val username: String, private val password: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AccountViewModel::class.java)) {
            return AccountViewModel(username, password) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}