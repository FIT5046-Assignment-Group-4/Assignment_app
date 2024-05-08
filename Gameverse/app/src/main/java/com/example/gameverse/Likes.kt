package com.example.gameverse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun Likes(navController: NavHostController) {
//    val gameList = listOf(
//        Game(R.drawable.gta5, 1, "Grand Theft Auto V",9.5,5,"2013"),
//        Game(R.drawable.csgo, 2, "CS:GO",9.1,4,"2012"),
////        Game("Honkai Impact 3", 0.00f, 6.6f, R.drawable.honkai_impact_3),
////        Game("War Thunder", 0.00f, 7.0f, R.drawable.wt)
//    )
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        TopAppBar(
//            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
//            title =
//            {
//                Text(text = "Favorite Games",
//                    modifier = Modifier.fillMaxWidth(),
//                    textAlign = TextAlign.Center)
//            },
//            backgroundColor = Color.White,
//            contentColor = Color.White,
//            elevation = 8.dp
//        )
//        Box(
//            contentAlignment = Alignment.Center
//        ) {
//            LazyColumn(modifier = Modifier.fillMaxWidth()) {
//                items(gameList) { item ->
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(5.dp)
//                            .clickable {
//                                navController.navigate(Routes.Report.value) },
//                        elevation = CardDefaults.cardElevation(5.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = Color.White
//                        ),
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(10.dp)
//                        ) {
//                            Box(
//                                modifier = Modifier
//                                    .size(80.dp)
//                            ) {
//                                AsyncImage(
//                                    model = item.background_image,
//                                    contentDescription = null,
//                                )
//                            }
//                            Column(
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .padding(end = 16.dp)
//                                    .align(Alignment.CenterVertically),
//                                horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//                                Text(
//                                    text = item.name,
//                                    fontSize = 20.sp,
//                                    modifier = Modifier.padding(bottom = 4.dp)
//                                )
//                                Text(
//                                    text = "Price: ${item.rating_top}",
//                                    modifier = Modifier.padding(bottom = 4.dp)
//                                )
//                            }
//
//                            Column(
//                                modifier = Modifier
//                                    .align(Alignment.CenterVertically),
//                                horizontalAlignment = Alignment.End
//                            ) {
//                                Text(
//                                    text = "Rating: ${item.rating}",
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}