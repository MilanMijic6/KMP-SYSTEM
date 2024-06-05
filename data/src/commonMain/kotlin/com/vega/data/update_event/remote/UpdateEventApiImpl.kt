package com.vega.data.update_event.remote

import com.vega.data.api.ApiClientImpl
import com.vega.domain.model.update_event.UpdateEventRequestBody
import io.ktor.client.statement.HttpResponse

class UpdateEventApiImpl(
    private val apiClient: ApiClientImpl
) : UpdateEventApi {
    override suspend fun updateEvent(token: String, event: UpdateEventRequestBody): HttpResponse =
        apiClient.updateEvent("api/Events/updateEvent", token, event)
}