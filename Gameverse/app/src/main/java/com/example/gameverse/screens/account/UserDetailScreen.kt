package com.example.gameverse.screens.account

import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.gameverse.R
import com.example.gameverse.navigation.Routes
import com.example.gameverse.screens.login.LoginScreenViewModel
import com.google.firebase.auth.FirebaseAuth


@RequiresApi(0)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(
    navController: NavHostController,
    isBottomBarVisible: Boolean,
    toggleBottomBar: (Boolean) -> Unit,
    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    viewModel.getData()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Accounts Page")
                },
                actions = {
                    IconButton(onClick = {
                        FirebaseAuth.getInstance().signOut().run {
                            toggleBottomBar(!isBottomBarVisible)
                            navController.navigate(Routes.SplashScreen.value) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Logout, contentDescription = "Log Out")
                    }
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Routes.EditAccount.value)
            }) {
                IconButton(onClick = {

                }) {

                }
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