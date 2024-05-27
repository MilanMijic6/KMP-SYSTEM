package com.vega.data.events.remote

import com.vega.data.api.ApiClientImpl
import io.ktor.client.statement.HttpResponse

class UpcomingEventsApiImpl(
    private val apiClient: ApiClientImpl
) : UpcomingEventsApi {
    override suspend fun getUpcomingEvents(page: Int, pageSize: Int): HttpResponse =
        apiClient.getUpcomingEvents(
            endpoint = "api/Events/getUpcomingEvents",
            page = page,
            pageSize = pageSize
        )
}