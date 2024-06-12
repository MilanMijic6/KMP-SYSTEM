package main.profile

import com.vega.domain.model.profile.User

data class ProfileUserScreenModel(
    val user: User,
    val errorMsg: String?,
    val updateName: String,
    val updateEmail: String,
    val updatedProfilePicture: String,
    val isEnabledButton: Boolean
)

fun setInitState(): ProfileUserScreenModel = ProfileUserScreenModel(
    user = User(
        email = "",
        name = "",
        profilePicture = ""
    ),
    errorMsg = "",
    updateName = "",
    updateEmail = "",
    updatedProfilePicture = "",
    isEnabledButton = false
)