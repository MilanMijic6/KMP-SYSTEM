package com.vega.domain.repository.profile

import com.vega.domain.model.profile.User

interface ProfileRepository {

    suspend fun getUser(): User

    suspend fun updateUser(name: String, email: String, profilePicture: String)

    suspend fun logout()

}