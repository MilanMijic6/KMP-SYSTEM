package com.vega.data.create_event.remote

import com.vega.data.api.ApiClientImpl
import com.vega.domain.model.create_event.CreateEventRequestBody
import io.ktor.client.statement.HttpResponse

class CreateEventApiImpl(
    private val apiClient: ApiClientImpl
) : CreateEventApi {
    override suspend fun createEvent(token: String, event: CreateEventRequestBody): HttpResponse =
        apiClient.createEvent("api/Events/createEvent", token, event)
}