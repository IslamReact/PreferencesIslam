package com.islamelmrabet.preferencesislam.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.islamelmrabet.preferencesislam.Data.User
import kotlinx.coroutines.flow.map

class AppPreferences (val context: Context){
    companion object {
        val NAME = stringPreferencesKey("NAME")
        val PHONE = intPreferencesKey("PHONE")
    }

    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "preferences")

    suspend fun saveUser(user: User) {
        context.dataStore.edit { preferences ->
            preferences[NAME] = user.name
            preferences[PHONE] = user.phoneNumber
        }
    }

    fun loadUser() = context.dataStore.data.map{ preferences ->
        User(
            name = preferences[NAME] ?: "",
            phoneNumber = preferences[PHONE] ?: 0,
        )
    }
}