package com.islamelmrabet.preferencesislam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreferencesViewModel : ViewModel() {

    // LiveData para almacenar los datos
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    // LiveData para almacenar los datos
    private val _phoneNumber = MutableLiveData<Int>()
    val phoneNumber: LiveData<Int> = _phoneNumber

    fun updateUserName(name: String) {
        _userName.value = name
    }

    fun updateRepetitions(phoneNumber: Int) {
        _phoneNumber.value = phoneNumber
    }
}