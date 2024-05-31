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
}