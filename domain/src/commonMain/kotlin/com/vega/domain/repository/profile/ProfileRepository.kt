package com.vega.domain.repository.profile

import com.vega.domain.model.profile.UpdateUserRequestBody
import com.vega.domain.model.profile.User

interface ProfileRepository {

    suspend fun getUser(): User

    suspend fun updateUser(parameter: UpdateUserRequestBody)

    suspend fun logout()

}