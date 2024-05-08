package com.example.gameverse

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.material3.Button
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.firebase.ui.auth.AuthUI
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

@RequiresApi(0)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Me(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val user = Firebase.auth.currentUser
    val photoUrl = user?.photoUrl?.toString()
    val imagePainter =if (photoUrl != null) {
        rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = photoUrl).apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
                placeholder(R.drawable.profile_picture)
                error(R.drawable.profile_picture)
            }).build()
        )
    } else {
        painterResource(id = R.drawable.profile_picture)
    }
    val name = user?.displayName
    val email = user?.email
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
            Image(painter = imagePainter,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .padding(top = 40.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                if (name != null) {
                    Text(text = name, fontSize = 28.sp, modifier = Modifier.padding(16.dp))
                }
            }

            Divider(color = Color.LightGray, thickness = 1.dp)

        if (email != null) {
            Text(text = email)
        }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    coroutineScope.launch {
                        signOut(context, navController)
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Sign Out")
            }
        }
    }
}

fun signOut(context: Context, navController: NavController) {
    AuthUI.getInstance()
        .signOut(context)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navController.navigate(Routes.Home.value)
            }
        }
}