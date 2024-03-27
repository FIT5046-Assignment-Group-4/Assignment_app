package com.example.gameverse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gameverse.ui.theme.GameverseTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(64)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            GameverseTheme {
//<<<<<<< HEAD
////                val games = listOf(
////                    Game("CS:GO", 0.00f, 4.3f, "https://seeklogo.com/images/C/csgo-logo-CAA0A4D48A-seeklogo.com.png"),
////                    Game("Dota2", 0.00f, 4.7f, "https://i.pinimg.com/originals/8a/8b/50/8a8b50da2bc4afa933718061fe291520.jpg")
////                )
////                BrowseMainPage(gameList = games)
////                SearchBar()
//                // A surface container using the 'background' color from the theme
////<<<<<<< HEAD
////                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
////                    Greeting("Android")
//////                }
////=======
//=======
//>>>>>>> main
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavHost(navController = navController, startDestination = Routes.LoginSelection.value, builder = {
                        composable(Routes.LoginSelection.value){
                            LoginSelectionScreen(navController)
                        }
                        composable(Routes.Registration.value){
                            RegistrationScreen(navController)
                        }
                        composable(Routes.Login.value){
                            LoginScreen(navController)
                        }
                        composable(Routes.MainPage.value){
                            BottomNavigationBar()
                        }
                    })
                }
//<<<<<<< HEAD
////>>>>>>> main
//=======
//>>>>>>> main
            }
        }
    }
}

//<<<<<<< HEAD
////<<<<<<< HEAD
////@Composable
////fun Greeting(name: String, modifier: Modifier = Modifier) {
////    Text(
////            text = "Hello $name!",
////            modifier = modifier
////    )
////}

