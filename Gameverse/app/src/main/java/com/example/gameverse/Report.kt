package com.example.gameverse

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gameverse.local.GameEntity
import com.example.gameverse.local.LocalDatabaseViewModel
import com.google.android.gms.wallet.button.ButtonConstants

@Composable
fun Report(navController: NavHostController, gameId: Int) {
    val gameViewModel: GameViewModel = viewModel()
    val likeViewModel: LocalDatabaseViewModel = viewModel()
    val detailReturn by gameViewModel.retrofitDetail
    val data = detailReturn

    LaunchedEffect(gameId) {
        gameViewModel.loadGameDetail(gameId)
    }


    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())) {
        //top bar
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title =
            {
                Text(text = data.name)
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {  // This will navigate back when clicked
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.White,
            elevation = 8.dp
        )
        //content
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            AsyncImage(
                model = data.backgroundImage,
                contentDescription = "What is New",
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }
        Text(
            text = data.name,
            fontSize = 25.0.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp)
        )
        Divider(color = Color.LightGray,
            thickness = 3.dp,
            modifier = Modifier.padding(vertical = 5.dp))
        Text(
            text = data.description,
            modifier = Modifier.padding(5.dp)
        )
        Divider(color = Color.LightGray,
            thickness = 3.dp,
            modifier = Modifier.padding(vertical = 5.dp))

        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .padding(16.dp)) {
            Button(
                onClick = {
                          likeViewModel.insertGame(
                              GameEntity(id = gameId,
                                  name = data.name,
                                  backgroundImage = data.backgroundImage,
                                  rating = data.rating,
                                  ratingTop = 0
                                  )
                          )
                } ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Gray,
                    contentColor = Color.White
                )

            ) {
                Text(text = "Add to Favorite List")
            }
        }

    }
}