package com.vega.domain.usecase.profile

import com.vega.domain.repository.profile.ProfileRepository

class UpdateUserUseCase(
    private val repository: ProfileRepository
) {
    suspend fun execute(name: String, email: String, profilePicture: String) =
        repository.updateUser(name, email, profilePicture)

}