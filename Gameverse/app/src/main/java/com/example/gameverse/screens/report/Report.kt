package com.example.gameverse.screens.report

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gameverse.components.BarChartScreen
import com.example.gameverse.local.GameEntity
import com.example.gameverse.local.LocalDatabaseViewModel
import com.example.gameverse.screens.home.GameViewModel
import com.github.mikephil.charting.data.BarEntry

@SuppressLint("UnrememberedMutableState")
@Composable
fun Report(navController: NavHostController, gameId: Int) {
    val gameViewModel: GameViewModel = viewModel()
    val likeViewModel: LocalDatabaseViewModel = viewModel()
    val detailReturn by gameViewModel.retrofitDetail
    val data = detailReturn

    val context = LocalContext.current

    LaunchedEffect(gameId) {
        gameViewModel.loadGameDetail(gameId)
    }

    val barEntries by derivedStateOf {
        data.ratings.map { rating ->
            BarEntry(rating.id.toFloat(), rating.count.toFloat())
        }
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
            .height(350.dp)) {
            BarChartScreen(barEntries = barEntries)
        }


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
                    Toast.makeText(context,"Game is added to favorite list",Toast.LENGTH_SHORT).show()
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