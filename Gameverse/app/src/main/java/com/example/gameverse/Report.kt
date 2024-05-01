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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.android.gms.wallet.button.ButtonConstants

@Composable
fun Report() {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title =
            {
                Text(text = "CS:GO")
            },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.White,
            elevation = 8.dp
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.fb_image),
                contentDescription = "What is New",
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }
        Text(
            text = "CS:GO",
            fontSize = 25.0.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp)
        )
        Divider(color = Color.LightGray,
            thickness = 3.dp,
            modifier = Modifier.padding(vertical = 5.dp))
        Text(
            text ="Counter-Strike: Global Offensive (CS:GO) is a 2012 multiplayer tactical first-person shooter developed by Valve and Hidden Path Entertainment. " +
                    "It is the fourth game in the Counter-Strike series. " +
                    "Developed for over two years, Global Offensive was released for OS X, " +
                    "PlayStation 3, Windows, and Xbox 360 in August 2012, and for Linux in 2014.",
            modifier = Modifier.padding(5.dp)
        )
        Divider(color = Color.LightGray,
            thickness = 3.dp,
            modifier = Modifier.padding(vertical = 5.dp))

        Text(
            text = "Game evaluation",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 5.dp)
        )

        Image(
            painterResource(id = R.drawable.rating),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .scale(1.8f)
                .padding(top = 18.dp)
        )

        Divider(color = Color.LightGray,
            thickness = 3.dp,
            modifier = Modifier.padding(top = 40.dp, bottom = 20.dp))

        Row(modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            for(i in 1..5) {
                Icon(
                    Icons.Outlined.Star,
                    contentDescription = " ",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { /* 点击事件 */ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.LightGray,
                    contentColor = Color.White
                )
            ) {
                Text(text = "I want to rate")
            }
        }

        Box(modifier = Modifier.align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .padding(16.dp)) {
            Button(
                onClick = { /* TODO */} ,
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


@Preview
@Composable
fun ReportPreview() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Report()
    }
}