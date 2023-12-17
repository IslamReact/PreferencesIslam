package com.islamelmrabet.preferencesislam.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islamelmrabet.preferencesislam.Data.User
import com.islamelmrabet.preferencesislam.preferences.AppPreferences
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PreferencesViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application.applicationContext)

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun saveUser(name: String, phoneNumber: Int) {
        viewModelScope.launch {
            preferences.saveUser(User(name, phoneNumber))
        }
    }

    fun loadUser() {
        viewModelScope.launch {
            preferences.loadUser().collect { user ->
                _user.value = user
            }
        }
    }
}


