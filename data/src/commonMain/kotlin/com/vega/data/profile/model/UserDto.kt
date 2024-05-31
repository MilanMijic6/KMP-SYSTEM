package com.vega.data.profile.model

import com.vega.domain.model.profile.User
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val email: String,
    val name: String,
    val profilePicture: String
)

fun UserDto.toUser(): User {
    return User(
        email = email,
        name = name,
        profilePicture = profilePicture
    )
}