package com.islamelmrabet.preferencesislam.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.islamelmrabet.preferencesislam.ui.theme.PreferencesIslamTheme


@Composable
fun PreferencesIslamContent(content: @Composable () -> Unit) {
    PreferencesIslamTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}