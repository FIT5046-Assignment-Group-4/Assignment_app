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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        //contentAlignment = Alignment.TopCenter
    )
    {
        var languages = listOf(
            "Game1",
            "Game2",
            "Game3",
            "Game4",
            "Game5",
            "Game6",
            "Game7"
        )

        Column(
            //horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)) {

            Text(text = "GameVerse",fontSize = 35.0.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.size(10.dp))


            var searchText by remember {mutableStateOf("")}
            CustomEdit(
                text = searchText,
                onValueChange = {
                    searchText = it
                },
                hint = "Search",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 0.dp, end = 10.dp, bottom = 10.dp)
                    .height(50.dp)
                    .background(Color(0xBCE9E9E9), shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 16.dp),
                // textStyle = Typography.bodyMedium,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )

            Text(text = "WHAT'S NEW", fontSize = 20.0.sp, textAlign = TextAlign.Start, modifier = Modifier.padding(bottom = 5.dp)
            )
            Image(painter = painterResource(id = R.drawable.what_new), contentDescription = "What is New" , modifier = Modifier.padding(bottom = 5.dp))

            Spacer(modifier = Modifier.size(5.dp))
            Text(text = "FEATURED & RECOMMENDED", fontSize = 20.0.sp, textAlign = TextAlign.Start, modifier = Modifier.padding(bottom = 5.dp)
            )

            LazyRow(contentPadding = PaddingValues(10.dp)){
                items(items = languages){item ->
                    RowItem(name = item)
                }
            }

            //Text(text = "Home Screen",
            //    style = MaterialTheme.typography.headlineMedium)
            //Spacer(modifier = Modifier.size(30.dp))
            //Text("Welcome to Navigation app", style = MaterialTheme.typography.bodyLarge)
        } }




}

@Composable
fun RowItem(name : String){
    Card(
        Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(200.dp)
            .aspectRatio(1.5f), colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Box(){
            Column {

            }
            Text(text = name, fontSize = 22.sp)
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

