package com.example.gameverse.model

data class LocalUser(
    val id: String?,
    val userId: String,
    val firstName: String,
    val lastName: String,
    val nickName: String,
    val profilePictureUrl: String,
    val location: String,
    val gender: String,
    val favGenre: String,
    val dateOfBirth: String
    ) {

    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "user_id" to this.userId,
            "first_name" to this.firstName,
            "last_name" to this.lastName,
            "nickname" to this.nickName,
            "location" to this.location,
            "gender" to this.gender,
            "profile_picture" to this.profilePictureUrl,
            "favourite_genre" to this.favGenre,
            "dob" to this.dateOfBirth
        )
    }
}
