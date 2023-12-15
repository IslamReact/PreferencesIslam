package com.islamelmrabet.preferencesislam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.islamelmrabet.preferencesislam.navigation.Navigation
import com.islamelmrabet.preferencesislam.ui.PreferencesIslamContent
import com.islamelmrabet.preferencesislam.viewmodel.PreferencesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferencesViewModel by viewModels<PreferencesViewModel>()

        setContent {
            PreferencesIslamContent {
                Navigation(preferencesViewModel)
            }
        }
    }
}
