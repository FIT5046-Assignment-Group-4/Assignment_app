package com.example.gameverse

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController){
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo_250x250), contentDescription = "",
            modifier = Modifier.size(230.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Please sign in")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "Email Address",);
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(text = "Password");
        },
            visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate(Routes.MainPage.value)
        },
            modifier = Modifier.width(250.dp)) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Or sign in with")

        Spacer(modifier = Modifier.height(16.dp))

        Image(painter = painterResource(id = R.drawable.google),
            contentDescription = "Google",
            modifier = Modifier.size(60.dp).clickable {
                navController.navigate(Routes.MainPage.value)
            })
    }
}