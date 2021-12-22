package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class AccountViewModel() : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _active = MutableLiveData<Boolean>()
    val active: LiveData<Boolean>
        get() = _active

    init {
        _active.value = false
        Timber.i("Account Created")
    }

    fun setAccount(username: String, password: String) {

        if(username.isNotEmpty() && password.isNotEmpty()) {
            _username.value = username
            _password.value = password
            _active.value = true
        }
        else {
            _active.value = false
        }
    }
}