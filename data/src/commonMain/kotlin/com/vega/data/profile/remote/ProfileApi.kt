package com.vega.data.profile.remote

import com.vega.domain.model.profile.UpdateUserRequestBody
import io.ktor.client.statement.HttpResponse

interface ProfileApi {
    suspend fun getUser(token: String): HttpResponse

    suspend fun updateUser(token: String, user: UpdateUserRequestBody): HttpResponse

}