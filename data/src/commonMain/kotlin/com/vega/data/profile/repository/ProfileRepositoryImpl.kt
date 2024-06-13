package com.vega.data.profile.repository

import com.vega.data.auth.storage.SettingsStorage
import com.vega.data.profile.model.UserDto
import com.vega.data.profile.model.toUser
import com.vega.data.profile.remote.ProfileApi
import com.vega.domain.model.profile.UpdateUserRequestBody
import com.vega.domain.model.profile.User
import com.vega.domain.repository.profile.ProfileRepository
import io.ktor.client.call.body

class ProfileRepositoryImpl(
    private val api: ProfileApi,
    private val storage: SettingsStorage
) : ProfileRepository {
    override suspend fun getUser(): User =
        runCatching {
            storage.getToken()
        }.mapCatching {
            api.getUser(it)
        }.mapCatching {
            it.body<UserDto>().toUser()
        }.getOrThrow()

    override suspend fun updateUser(parameter: UpdateUserRequestBody) {
        runCatching {
            storage.getToken()
        }.mapCatching {
            api.updateUser(
                token = it,
                user = parameter
            )
        }.getOrThrow()
    }

    override suspend fun logout() = storage.removeToken()
}