package com.islamelmrabet.preferencesislam.navigation

sealed class Routes(val route: String) {
    object MainScreen: Routes("main_screen")
    object OnBoardingScreen: Routes("OnBoarding_screen")
    object SplashScreen: Routes("Splash_screen")

}