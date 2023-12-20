package com.islamelmrabet.preferencesislam.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.islamelmrabet.preferencesislam.Data.User
import com.islamelmrabet.preferencesislam.preferences.AppPreferences
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PreferencesViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application.applicationContext)

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _numberPhone = MutableLiveData<Int>()
    val numberPhone: LiveData<Int> = _numberPhone

    fun onUserNameChanged(name: String){
        _name.value = name
    }

    fun onUserPhoneChanged(phone: Int){
        _numberPhone.value = phone
    }

    fun saveUser(name : String, numberPhone : Int) {
        viewModelScope.launch {
            preferences.saveUser(User(name, numberPhone))
        }
    }

    fun loadUser() {
        viewModelScope.launch {
            preferences.loadUser().collect { user ->
                _name.value = user.name
                _numberPhone.value = user.phoneNumber
            }
        }
    }

    fun navigateBasedOnUser(navController: NavController) {
        viewModelScope.launch {
            preferences.loadUser().collect { user ->
                if (user.name.isNotEmpty() && user.phoneNumber != 0) {
                    // Usuario guardado, navegar a la pantalla principal
                    navController.navigate("main_screen")
                } else {
                    // No se encontró un usuario guardado, navegar a la pantalla de OnBoarding
                    navController.navigate("OnBoarding_screen")
                }
            }
        }
    }
}


