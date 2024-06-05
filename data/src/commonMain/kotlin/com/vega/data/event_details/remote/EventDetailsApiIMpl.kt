package com.vega.data.event_details.remote

import com.vega.data.api.ApiClientImpl
import io.ktor.client.statement.HttpResponse

class EventDetailsApiIMpl (
    private val apiClient: ApiClientImpl
) : EventDetailsApi {
    override suspend fun getEvent(id: String, token: String): HttpResponse =
        apiClient.getEventDetails(
            endpoint = "api/Events/event/${id}",
            token = token
        )


    override suspend fun reserveEvent(token: String, eventId: String): HttpResponse =
        apiClient.reserveEvent(
            endpoint = "reserve/${eventId}",
            token = token
        )

    override suspend fun deleteEvent(token: String, id: String): HttpResponse =
        apiClient.deleteEvent(
            endpoint = "api/Events/deleteEvent/${id}",
            token = token
        )
}