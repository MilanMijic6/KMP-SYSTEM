package com.vega.data.api

import com.vega.domain.model.create_event.CreateEventRequestBody
import com.vega.domain.model.login.LoginRequestBody
import com.vega.domain.model.register.RegisterRequestBody
import com.vega.domain.model.update_event.UpdateEventRequestBody
import io.ktor.client.statement.HttpResponse

interface ApiClient {

    suspend fun login(endpoint: String, params: LoginRequestBody): HttpResponse

    suspend fun register(endpoint: String, params: RegisterRequestBody): HttpResponse

    suspend fun getUpcomingEvents(endpoint: String, page: Int, pageSize: Int): HttpResponse

    suspend fun getUser(endpoint: String, token: String): HttpResponse

    suspend fun getEventDetails(endpoint: String, token: String): HttpResponse

    suspend fun reserveEvent(endpoint: String, token: String): HttpResponse

    suspend fun updateUser(
        endpoint: String,
        token: String,
        name: String,
        email: String,
        profilePicture: String
    ): HttpResponse

    suspend fun deleteEvent(endpoint: String, token: String): HttpResponse

    suspend fun updateEvent(
        endpoint: String,
        token: String,
        params: UpdateEventRequestBody
    ): HttpResponse

    suspend fun getMyEvents(endpoint: String, token: String, page: Int, pageSize: Int): HttpResponse

    suspend fun createEvent(
        endpoint: String,
        token: String,
        params: CreateEventRequestBody
    ): HttpResponse

}