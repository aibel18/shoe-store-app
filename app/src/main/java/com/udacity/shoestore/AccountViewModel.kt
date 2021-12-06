package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel(newUsername: String? = null, newPassword: String? = null) : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    init {
        setAccount(newUsername, newPassword)
    }

    private fun setAccount(username: String?, password: String?) {
        _username.value = username
        _password.value = password
    }

    fun login(username: String, password: String) {
        setAccount(username, password)
        Log.i("LoginViewModel", "${_password.value} ${_username.value}")
    }
    fun login() {
        Log.i("LoginViewModel", "${_password.value} ${_username.value}")
    }
}