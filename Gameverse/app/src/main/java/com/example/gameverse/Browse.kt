package com.example.gameverse

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gameverse.UIcomponent.SearchBar


@Composable
fun Browse(navController: NavHostController) {
    val gameViewModel: GameViewModel = viewModel()
    val gameReturned by gameViewModel.retrofitResponse
    val gameList = gameReturned.result

    var keyword by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            text = keyword,
            onValueChange = {
                keyword = it
            },
            hint = "Search",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 5.dp)
                .height(50.dp)
                .background(Color(0xBCE9E9E9), shape = MaterialTheme.shapes.medium)
                .padding(horizontal = 16.dp),
            // textStyle = Typography.bodyMedium,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            keyboardActions = KeyboardActions{
                gameViewModel.searchGame(keyword)
            },
            search = Modifier
                .padding(start = 10.dp)
                .clickable { gameViewModel.searchGame(keyword)

                }
        )
        //Game list
        Box(
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(gameList) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .clickable(onClick = { navController.navigate(Routes.Report.value) }),
                        elevation = CardDefaults.cardElevation(5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                                    .aspectRatio(1f / 1f)

                            ) {
                                AsyncImage(
                                    model = item.backgroundImage,
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 16.dp)
                                    .align(Alignment.CenterVertically),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = item.name,
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(20.dp),
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Rating Top: ${item.ratingTop}",
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(
                                    text = "Rating: ${item.rating}",
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


