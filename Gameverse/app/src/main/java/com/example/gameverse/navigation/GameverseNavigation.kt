package com.example.gameverse.navigation

import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gameverse.screens.SplashScreen
import com.example.gameverse.screens.login.LoginScreen
import com.example.gameverse.screens.registration.RegistrationScreen


@RequiresApi(64)
@Composable
fun GameverseNavigation(navController: NavHostController) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.value
    ) {
        composable(Routes.SplashScreen.value) {
            BackHandler(true) {}
            SplashScreen(navController)
        }
        composable(Routes.Login.value) {
            BackHandler(true) {}
            LoginScreen(navController)
        }
        composable(Routes.Registration.value) {
            BackHandler(true) {}
            RegistrationScreen(navController)
        }
        composable(Routes.MainPage.value) {
            MainPage()
        }
    }
}
