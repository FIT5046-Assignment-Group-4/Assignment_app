package com.example.gameverse.navigation

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gameverse.screens.SplashScreen
import com.example.gameverse.screens.account.EditAccounts
import com.example.gameverse.screens.account.UserDetailScreen
import com.example.gameverse.screens.browse.Browse
import com.example.gameverse.screens.home.Home
import com.example.gameverse.screens.likes.Likes
import com.example.gameverse.screens.login.LoginScreen
import com.example.gameverse.screens.registration.RegistrationScreen
import com.example.gameverse.screens.report.Report


@RequiresApi(0)
@Composable
fun MainPage(navController: NavHostController = rememberNavController()) {
    var isBottomBarVisible by remember { mutableStateOf(false) }

    val key = remember { mutableStateOf(0) }

    // Function to toggle the bottom bar visibility
    val toggleBottomBar: (Boolean) -> Unit = { isVisible ->
        isBottomBarVisible = isVisible
        key.value++
    }
    Log.d("TAG", "MainPage: $isBottomBarVisible")
    Scaffold(
        bottomBar = {
            if(isBottomBarVisible) {
                BottomNavigationBar(navController = navController)
            }
        }

    ) { paddingValues ->
        NavHost(
            navController,
            startDestination = Routes.SplashScreen.value,
            Modifier.padding(paddingValues)
        ){
            composable(Routes.SplashScreen.value) {
                BackHandler(true) {}
                SplashScreen(navController, isBottomBarVisible, toggleBottomBar)
            }
            composable(Routes.Login.value) {
                BackHandler(true) {}
                LoginScreen(navController, isBottomBarVisible, toggleBottomBar)
            }
            composable(Routes.Registration.value) {
                BackHandler(true) {}
                RegistrationScreen(navController, isBottomBarVisible, toggleBottomBar)
            }
            composable(Routes.MainPage.value) {
                MainPage()
            }
            composable(Routes.Home.value) {
                Home(navController)
            }
            composable(Routes.Browse.value) {
                Browse(navController)
            }
            composable(Routes.Likes.value) {
                Likes(navController)
            }
            composable(Routes.Me.value) {
                UserDetailScreen(navController, isBottomBarVisible, toggleBottomBar)
            }
            composable(Routes.EditAccount.value) {
                EditAccounts(navController)
            }
            composable(Routes.Report.value + "/{gameId}",
                arguments = listOf(navArgument("gameId"){ type = NavType.IntType}
                )
            ) {backStackEntry ->
                val gameId = backStackEntry.arguments?.getInt("gameId", 0)
                if (gameId != null) {
                    Report(navController, gameId)
                }
            }
        }
    }
}

@Composable
private fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(backgroundColor = Color.LightGray) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        NavBarItem().NavBarItems().forEach { navItem ->
            BottomNavigationItem(
                icon = { Icon(navItem.icon, contentDescription = null) },
                label = { Text(navItem.label) },
                selected = currentDestination?.hierarchy?.any {
                    it.route == navItem.route
                } == true,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

