package com.example.gameverse

import android.os.Bundle
import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gameverse.ui.theme.GameverseTheme
import androidx.navigation.navDeepLink
import com.example.gameverse.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import androidx.compose.runtime.livedata.observeAsState

class MainActivity : ComponentActivity() {
    @RequiresApi(64)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            GameverseTheme {
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
            }
        }
    }
}



