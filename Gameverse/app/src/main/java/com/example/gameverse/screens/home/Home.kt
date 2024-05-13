package com.example.gameverse.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gameverse.navigation.Routes
import com.example.gameverse.network.GameDto

@Composable
fun Home(navController: NavHostController) {
    val gameViewModel: GameViewModel = viewModel()
    val popularGameReturn by gameViewModel.retrofitPopular
    val popularGameList = popularGameReturn.result
    val latestGameReturn by gameViewModel.retrofitLatest
    val latestGameList = latestGameReturn.result

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        //contentAlignment = Alignment.TopCenter
    )
    {
        Column(
            //horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {

            Text(
                text = "GameVerse",
                fontWeight = FontWeight.Bold,
                fontSize = 38.0.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "WHAT'S NEW",
                fontSize = 20.0.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            LazyRow(contentPadding = PaddingValues(5.dp)) {
                items(latestGameList) { item ->
                    RowItem(
                        game = item,
                        modifier = Modifier,
                        navController
                    )
                }
            }

            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "FEATURED & RECOMMENDED", fontSize = 20.0.sp, textAlign = TextAlign.Start
            )

            LazyRow(contentPadding = PaddingValues(5.dp)) {
                items(popularGameList) { item ->
                    RowItem(
                        game = item,
                        modifier = Modifier,
                        navController
                    )
                }
            }
        }
    }


}

@Composable
fun RowItem(
    game: GameDto,
    modifier: Modifier,
    navController: NavHostController
) {
    Card(
        modifier
            .padding(5.dp)
            .wrapContentSize()
            .fillMaxWidth()
            .height(240.dp)
            .clickable {
                navController.navigate(Routes.Report.value + "/${game.id}")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(modifier.width(280.dp)) {
            AsyncImage(
                model = game.backgroundImage,
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .width(280.dp)
                    .padding(bottom = 5.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = game.name,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
            Text(text = "Rating: ${game.rating}", fontSize = 18.sp)
        }
    }
}

