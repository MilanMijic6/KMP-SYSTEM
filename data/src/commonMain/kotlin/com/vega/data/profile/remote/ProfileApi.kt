package com.vega.data.profile.remote

import io.ktor.client.statement.HttpResponse

interface ProfileApi {
    suspend fun getUser(token: String): HttpResponse

}