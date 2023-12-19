package com.islamelmrabet.preferencesislam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.islamelmrabet.preferencesislam.Data.User
import com.islamelmrabet.preferencesislam.R
import com.islamelmrabet.preferencesislam.viewmodel.PreferencesViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController,preferencesViewModel: PreferencesViewModel) {

    val userData by preferencesViewModel.name.observeAsState()

    LaunchedEffect(userData) {
        delay(3000) // Duración de la SplashScreen
        navController.navigate(
            if (userData.isNullOrEmpty()) "OnBoarding_screen" else "main_screen"
        )
    }

    Splash()
}

@Composable
fun Splash() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inverseSurface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id= R.drawable.fotoperfil),
            contentDescription = "logo",
            modifier = Modifier
                .size(100.dp, 100.dp)
                .clip(CircleShape)
        )
        Text(
            stringResource(id = R.string.name),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }

}