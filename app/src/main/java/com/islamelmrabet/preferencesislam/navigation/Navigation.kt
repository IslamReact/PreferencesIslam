package com.islamelmrabet.preferencesislam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.islamelmrabet.preferencesislam.ui.screens.MainScreen
import com.islamelmrabet.preferencesislam.ui.screens.SplashScreen
import com.islamelmrabet.preferencesislam.ui.screens.onBoarding.OnBoardingScreen
import com.islamelmrabet.preferencesislam.viewmodel.PreferencesViewModel

@Composable
fun Navigation(preferencesViewModel : PreferencesViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route,
    ) {
        composable(Routes.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Routes.MainScreen.route) {
            MainScreen(navController, preferencesViewModel)
        }
        composable(Routes.OnBoardingScreen.route) {
            OnBoardingScreen(navController, preferencesViewModel)
        }
    }
}
