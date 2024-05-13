package com.example.gameverse.screens.registration

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.gameverse.components.CustomExpandableDropDownMenu
import com.example.gameverse.components.DisplayDatePicker
import com.example.gameverse.navigation.Routes
import com.example.gameverse.screens.home.GameViewModel
import com.example.gameverse.screens.login.LoginScreenViewModel
import com.google.firebase.auth.FirebaseAuth
import java.util.Calendar

@RequiresApi(0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavController,
                       viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val gameViewModel: GameViewModel = viewModel()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            RegistrationForm() { firstName, lastName, location,
                                              selectedGender, selectedGenre, selectedImageUri,
                                              selectedDate ->
                viewModel.updateUserDetailsWithImage(firstName, lastName, location,
                    selectedGender, selectedGenre, selectedDate, selectedImageUri
                    ) {
                    navController.navigate(Routes.MainPage.value)
                }
            }

        }
    }
}

@Composable
fun RegistrationForm(
    onDone: (
        String, String, String, String, String, Uri, Long
            ) -> Unit)
{
    var firstName by remember{mutableStateOf("")}
    var lastName by remember{mutableStateOf("")}
    var location by remember{mutableStateOf("")}

    val genders = listOf("Male", "Female", "Prefer Not to Say")
    var selectedGender = rememberSaveable { mutableStateOf(genders[0]) }

    val genres = listOf("Action", "Fighting", "Horror", "Shooting", "RPG", "Sandbox", "Simulation")
    var selectedGenre = rememberSaveable { mutableStateOf(genres[0]) }

    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri})

    val calendar = Calendar.getInstance()
    var selectedDate by remember { mutableStateOf(calendar.timeInMillis) }

    Column(modifier = Modifier.height(1000.dp)){
        OutlinedTextField(value = firstName, onValueChange = {firstName = it
        }, label = {
            Text(text = "First name")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = lastName, onValueChange = {lastName = it}, label = {
            Text(text = "Last name")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = location, onValueChange = {location = it}, label = {
            Text(text = "Country")
        }, placeholder = {
            Text(text = "E.g. Australia")
        })

        Spacer(modifier = Modifier.height(16.dp))

        CustomExpandableDropDownMenu(
            selectedState = selectedGender, genders)

        Spacer(modifier = Modifier.height(16.dp))

        CustomExpandableDropDownMenu(
            selectedState = selectedGenre, genres)

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }) {
                Text(text = "Upload a profile picture")
            }
        }
        if(selectedImageUri != null) {
            AsyncImage(
                model = selectedImageUri,
                contentDescription = "Selected Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(150.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))

        DisplayDatePicker(selectedDate = selectedDate, onDateSelected = { date ->
            selectedDate = date
        })

        Button(onClick = {
            selectedImageUri?.let {
                onDone(firstName, lastName, location, selectedGender.value, selectedGenre.value,
                    it, selectedDate )
            }
        },
            modifier = Modifier.width(250.dp)) {
            Text(text = "Login")
        }
    }
}