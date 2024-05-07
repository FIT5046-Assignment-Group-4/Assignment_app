package com.example.gameverse

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gameverse.network.ApiClient
import com.example.gameverse.network.Game
import retrofit2.Call
import retrofit2.Response


@Composable
fun Browse(navController: NavHostController) {
    val gameViewModel: GameViewModel = viewModel()
    val data = gameViewModel.gameData.observeAsState().value

    var searchText by remember { mutableStateOf("") }
    val gameList = listOf(
        Game(R.drawable.gta5, 1, "Grand Theft Auto V",9.5,5,"2013"),
        Game(R.drawable.csgo, 2, "CS:GO",9.1,4,"2012"),
        Game(R.drawable.honkai_impact_3, 3, "Honkai Impact 3",8.0,7,"2015"),
        Game(R.drawable.wt,4,"War Thunder",7.0, 6,"2013")
    )
    Column {
        Text(text = "Games Data: $data")
    }

//    Column(modifier = Modifier.fillMaxSize()) {
//        CustomEdit(
//            text = searchText,
//            onValueChange = {
//                searchText = it
//            },
//            hint = "Search",
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 5.dp)
//                .height(50.dp)
//                .background(Color(0xBCE9E9E9), shape = MaterialTheme.shapes.medium)
//                .padding(horizontal = 16.dp),
//            // textStyle = Typography.bodyMedium,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
//                            .clickable(onClick = { navController.navigate(Routes.Report.value) }),
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

