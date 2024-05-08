package com.example.gameverse

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@RequiresApi(0)
@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation (backgroundColor= Color.LightGray ){
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                NavBarItem().NavBarItems().forEach { navItem -> BottomNavigationItem(
                    icon = { Icon(navItem.icon, contentDescription = null) },
                    label = { Text(navItem.label) },
                    selected = currentDestination?.hierarchy?.any {
                        it.route == navItem.route
                    } == true,
                    onClick = {
                        navController.navigate(navItem.route) {
                            // popUpTo is used to pop up to a given destination before navigating
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            //at most one copy of a given destination on the
                            launchSingleTop = true
                            // this navigation action should restore any
                            restoreState = true }
                    }
                )
                } }
        }
    ) { paddingValues ->
        NavHost(
            navController,
            startDestination = Routes.Home.value,
            Modifier.padding(paddingValues)
        ){
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
                Me(navController)
            }
            composable(Routes.EditAccount.value) {
                EditAccounts(navController)
            }
            composable(Routes.Report.value + "/{gameId}",
                arguments = listOf(navArgument("gameId"){ type = NavType.IntType}
                )
            ) {backStackEntry ->
                val gameId = backStackEntry.arguments?.getInt("gameId", 0)
                Report(navController, gameId)
            }
        }
    }
}