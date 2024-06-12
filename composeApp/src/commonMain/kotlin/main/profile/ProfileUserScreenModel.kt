package main.profile

import com.vega.domain.model.profile.User

data class ProfileUserScreenModel(
    val user: User,
    val errorMsg: String?,
    val updateName: String,
    val updateEmail: String,
    val updatedProfilePicture: String,
    val isEditedName: Boolean,
    val isEditedEmail: Boolean,
    val isEditedPicture: Boolean
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
    isEditedName = false,
    isEditedEmail = false,
    isEditedPicture = false
)