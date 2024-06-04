package com.vega.data.profile.remote

import com.vega.data.api.ApiClientImpl
import io.ktor.client.statement.HttpResponse

class ProfileApiImpl(
    private val apiClient: ApiClientImpl
) : ProfileApi {
    override suspend fun getUser(token: String): HttpResponse =
        apiClient.getUser(
            endpoint = "api/Users",
            token = token
        )

    override suspend fun updateUser(
        token: String,
        name: String,
        email: String,
        profilePicture: String
    ): HttpResponse = apiClient.updateUser(
        endpoint = "api/Users/updateUser",
        token = token,
        name = name,
        email = email,
        profilePicture = profilePicture
    )
}