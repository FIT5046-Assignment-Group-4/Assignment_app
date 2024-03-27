package com.example.gameverse

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        //contentAlignment = Alignment.TopCenter
    )
    {
        var imageId = arrayOf(
            R.drawable.img_game_1,
            R.drawable.img_game_2,
            R.drawable.img_game_3
        )

        var names = arrayOf(
            "Apex Legends",
            "Dragon's Dogma 2",
            "Final Fantasy VII REMAKE INTERGRADE"

        )

        var prices = arrayOf(
            "$0.00",
            "$0.00",
            "$0.00"
        )

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


            var searchText by remember { mutableStateOf("") }
            CustomEdit(
                text = searchText,
                onValueChange = {
                    searchText = it
                },
                hint = "Search",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, top = 0.dp, end = 5.dp, bottom = 5.dp)
                    .height(50.dp)
                    .background(Color(0xBCE9E9E9), shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 16.dp),
                // textStyle = Typography.bodyMedium,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "WHAT'S NEW",
                fontSize = 20.0.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.what_new),
                contentDescription = "What is New",
                modifier = Modifier.padding(bottom = 5.dp)
            )

            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "FEATURED & RECOMMENDED", fontSize = 20.0.sp, textAlign = TextAlign.Start
            )

            LazyRow(contentPadding = PaddingValues(5.dp)) {
                val itemCount = imageId.size
                items(itemCount) { item ->
                    RowItem(
                        itemIndex = item,
                        painter = imageId,
                        title = names,
                        price = prices,
                        modifier = Modifier
                    )
                }
            }

            //Text(text = "Home Screen",
            //    style = MaterialTheme.typography.headlineMedium)
            //Spacer(modifier = Modifier.size(30.dp))
            //Text("Welcome to Navigation app", style = MaterialTheme.typography.bodyLarge)
        }
    }


}

@Composable
fun RowItem(
    itemIndex: Int,
    painter: Array<Int>,
    title: Array<String>,
    price: Array<String>,
    modifier: Modifier
) {
    Card(
        modifier
            .padding(5.dp)
            .wrapContentSize()
            .fillMaxWidth()
            .height(200.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(modifier.width(234.dp)) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = title[itemIndex],
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
            Text(text = price[itemIndex], fontSize = 18.sp)
        }
    }
}


@Composable
fun CustomEdit(
    text: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    hint: String = "Please Type in",
    @DrawableRes startIcon: Int = -1,
    iconSpacing: Dp = 6.dp,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    cursorBrush: Brush = SolidColor(MaterialTheme.colorScheme.primary)
) {
    var hasFocus by remember { mutableStateOf(false) }

    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier.onFocusChanged { hasFocus = it.isFocused },
        singleLine = true,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        cursorBrush = cursorBrush,
        decorationBox = @Composable { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (startIcon != -1) {
                    Image(painter = painterResource(id = startIcon), contentDescription = null)
                    Spacer(modifier = Modifier.width(iconSpacing))
                }

                Box(modifier = Modifier.weight(1f)) {
                    if (text.isEmpty())
                        Text(text = hint, color = Color.Gray, style = textStyle)

                    innerTextField()
                }

                if (hasFocus && text.isNotEmpty()) {
                    Icon(imageVector = Icons.Filled.Clear,
                        contentDescription = null,
                        modifier = Modifier.clickable { onValueChange.invoke("") })
                }
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
        }
    )
}

