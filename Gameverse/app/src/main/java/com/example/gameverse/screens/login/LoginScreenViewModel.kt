package com.example.gameverse.screens.login

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameverse.model.LocalUser
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth

    val storageReference = Firebase.storage.reference

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun signInWithEmailAndPassword(email: String, password: String,  home: () -> Unit)
            = viewModelScope.launch{
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("FB", "signInWithEmailAndPassword: Yay ${task.result.toString()}")
                        home()
                    } else {
                        Log.d("FB", "signInWithEmailAndPassword: ${task.result.toString()}")
                    }
                }
        } catch (ex: Exception) {
            Log.d("FB", "signInWithEmailAndPassword: ${ex.message}")
        }
    }

    fun createUserWithEmailAndPassword(email: String, password: String, home: () -> Unit) {
        if(_loading.value == false) {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        val displayName = task.result?.user?.email?.split('@')?.get(0)
                        createUser(displayName)
                        home()
                    } else {
                        Log.d("FB", "createUserWithEmailAndPassword: ${task.result.toString()}")
                    }
                    _loading.value = false
                }
        }
    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
        val user = LocalUser(
            userId = userId.toString(),
            nickName = displayName.toString(),
            firstName = "",
            lastName = "",
            location = "",
            gender = "",
            profilePictureUrl = "",
            favGenre = "",
            dateOfBirth = "",
            id = null).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
    }

    fun updateUserDetailsWithImage(firstName: String, lastName: String, location: String,
                                   gender: String, genre: String, dob: Long, imageUri: Uri?,
                                   home: () -> Unit) {
        val userId = Firebase.auth.currentUser?.uid

        val storageRef = storageReference.child("user_images/$userId/profile_picture.jpg")

        val task = if (imageUri != null) {
            storageRef.putFile(imageUri).continueWithTask { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                storageRef.downloadUrl
            }
        } else {
            Tasks.forResult(null)
        }

        task.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val imageUrl = task.result?.toString()
                val userData = hashMapOf(
                    "first_name" to firstName,
                    "last_name" to lastName,
                    "location" to location,
                    "gender" to gender,
                    "favourite_genre" to genre,
                    "dob" to dob
                )

                imageUrl?.let { userData["profile_picture"] = it }

                if (userId != null) {
                    FirebaseFirestore.getInstance().collection("users").document(userId)
                        .set(userData)
                        .addOnSuccessListener {
                            home()
                        }
                        .addOnFailureListener { e ->
                        }
                }
            } else {
            }
        }
    }
}