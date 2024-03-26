package com.example.gameverse

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class Game(val name: String, val price: Float, val rating: Float, val imageUrl: String)


@Composable
fun SearchBar() {
    var gameName by remember { mutableStateOf ("") }
    val icon : ImageVector = Icons.Default.Search
    Column() {
        Box (modifier = Modifier
            .fillMaxWidth()) {
            OutlinedTextField(
                value = gameName,
                onValueChange = { gameName = it },
                label = {
                    Text("Enter the game name",
                        color = LocalContentColor.current.copy(alpha = 0.6f)
                    )},
                trailingIcon = {
                    Icon(imageVector = icon, contentDescription = "Search Icon")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

    }
}

@Composable
fun GameList(gameList: List<Game>) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(gameList) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.LightGray
                    ),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                        ) {
                            AsyncImage(
                                model = item.imageUrl,
                                contentDescription = null,
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
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Price: ${item.price} AUD",
                                color = Color.Gray,
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
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BrowseMainPage(gameList: List<Game>) {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar()
        GameList(gameList = gameList)
    }
}


@Preview
@Composable
fun GameListPreview() {
    val games = listOf(
        Game("CS:GO", 0.0f, 4.3f, "https://seeklogo.com/images/C/csgo-logo-CAA0A4D48A-seeklogo.com.png"),
        Game("Dota2", 0.0f, 4.7f, "https://i.pinimg.com/originals/8a/8b/50/8a8b50da2bc4afa933718061fe291520.jpg")
    )
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        BrowseMainPage(gameList = games)
    }

}