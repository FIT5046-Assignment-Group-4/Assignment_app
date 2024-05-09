package com.example.gameverse

import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(0)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Me(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Accounts Page")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Routes.EditAccount.value)
            }) {
                Icon(Icons.Default.Check, contentDescription = "Edit")
            }
        }
    ) {innerPadding ->
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(innerPadding)) {
            Text(text = "Accounts Page", fontSize = 40.sp, fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .padding(top = 40.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(text = "Joshua", fontSize = 28.sp, modifier = Modifier.padding(16.dp))
            }

            Divider(color = Color.LightGray, thickness = 1.dp)

            Text(text = "park.hw@hotmail.com")
        }
    }
}