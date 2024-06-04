package com.vega.data.profile.remote

import io.ktor.client.statement.HttpResponse

interface ProfileApi {
    suspend fun getUser(token: String): HttpResponse

    suspend fun updateUser(
        token: String,
        name: String,
        email: String,
        profilePicture: String
    ): HttpResponse

}