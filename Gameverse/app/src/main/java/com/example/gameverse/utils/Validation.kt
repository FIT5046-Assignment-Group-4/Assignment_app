package com.example.gameverse.utils

fun isValidEmail(target: CharSequence): Boolean {
    return if (target.isEmpty()) false
    else android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
}

fun isValidPassword(password: String): Boolean {
    return password.length in 8..24
}