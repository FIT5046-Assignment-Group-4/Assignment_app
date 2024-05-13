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

}
