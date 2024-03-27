package com.example.gameverse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Browse(navController: NavHostController) {
//<<<<<<< HEAD
    //mock data
//    val games = listOf(
//        Game("CS:GO", 0.0f, 4.3f, "https://seeklogo.com/images/C/csgo-logo-CAA0A4D48A-seeklogo.com.png"),
//        Game("Dota2", 0.0f, 4.7f, "https://i.pinimg.com/originals/8a/8b/50/8a8b50da2bc4afa933718061fe291520.jpg")
//=======
    val games = listOf(
        Game("CS:GO", 0.00f, 4.3f, "https://seeklogo.com/images/C/csgo-logo-CAA0A4D48A-seeklogo.com.png"),
        Game("Dota2", 0.00f, 4.7f, "https://i.pinimg.com/originals/8a/8b/50/8a8b50da2bc4afa933718061fe291520.jpg")
    )
    BrowseMainPage(gameList = games)
    //                SearchBar()
    // A surface container using the 'background' color from the theme
    //                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    //                    Greeting("Android")
    //                }
//    Box(modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//>>>>>>> main
//    )
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        BrowseMainPage(gameList = games)
    }

//    Box(modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    )
//    {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Text(text = "Browse Screen",
//                style = MaterialTheme.typography.headlineMedium)
//        } }
}