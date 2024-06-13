package com.vega.data.profile.remote

import com.vega.data.api.ApiClientImpl
import com.vega.domain.model.profile.UpdateUserRequestBody
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
        user: UpdateUserRequestBody
    ): HttpResponse = apiClient.updateUser(
        endpoint = "api/Users/updateUser",
        token = token,
        params = user
    )
}