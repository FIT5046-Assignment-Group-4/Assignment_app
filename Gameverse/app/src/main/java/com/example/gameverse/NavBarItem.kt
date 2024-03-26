package com.example.gameverse

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector


data class NavBarItem (
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home, val route : String = ""
){
    fun NavBarItems(): List<NavBarItem> {
        return listOf( NavBarItem(
            label = "Home",
            icon = Icons.Filled.Home, route = Routes.Home.value
            ),
            NavBarItem(
                label = "Browse",
                icon = Icons.Filled.Search, route = Routes.Browse.value
            ),
            NavBarItem(
                label = "Likes",
                icon = Icons.Filled.ThumbUp, route = Routes.Likes.value
            ),
            NavBarItem(
                label = "Me",
                icon = Icons.Filled.Person, route = Routes.Me.value
            ),)
    }
}