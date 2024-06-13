package com.vega.domain.usecase.profile

import com.vega.domain.model.profile.UpdateUserRequestBody
import com.vega.domain.repository.profile.ProfileRepository

class UpdateUserUseCase(
    private val repository: ProfileRepository
) {
    suspend fun execute(parameter: UpdateUserRequestBody) =
        repository.updateUser(parameter)

}