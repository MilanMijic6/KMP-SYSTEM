package com.vega.data.api

import com.vega.domain.model.login.LoginRequestBody
import com.vega.domain.model.register.RegisterRequestBody
import io.ktor.client.statement.HttpResponse

interface ApiClient {

    suspend fun login(endpoint: String, params: LoginRequestBody): HttpResponse

    suspend fun register(endpoint: String, params: RegisterRequestBody) : HttpResponse

    suspend fun getUpcomingEvents(endpoint: String, page: Int, pageSize: Int): HttpResponse

    suspend fun getUser(endpoint: String, token: String): HttpResponse

    suspend fun getEventDetails(endpoint: String, token: String): HttpResponse

    suspend fun reserveEvent(endpoint: String, token: String): HttpResponse

}