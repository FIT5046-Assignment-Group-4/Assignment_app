package com.example.gameverse

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginSelectionScreen(navController: NavController){
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo_250x250), contentDescription = "",
            modifier = Modifier.size(230.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Welcome to Gameverse", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Button(onClick = {
            navController.navigate(Routes.Login.value)
            },
            modifier = Modifier.width(250.dp)){
            Text(text = "Login")
        }

        Button(onClick = {
            navController.navigate(Routes.Registration.value)
            },
            modifier = Modifier.width(250.dp)) {
            Text(text = "Register")
        }

        Button(onClick = {
            navController.navigate(Routes.MainPage.value)
        },
            modifier = Modifier.width(250.dp)) {
            Text(text = "Guest")
        }
        
    }

}