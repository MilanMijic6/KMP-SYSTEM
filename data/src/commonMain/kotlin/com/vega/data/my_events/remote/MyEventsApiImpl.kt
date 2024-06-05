package com.vega.data.my_events.remote

import com.vega.data.api.ApiClientImpl
import io.ktor.client.statement.HttpResponse

class MyEventsApiImpl(
    private val apiClient: ApiClientImpl
) : MyEventsApi {
    override suspend fun getMyEvents(token: String, page: Int, pageSize: Int): HttpResponse =
        apiClient.getMyEvents(
            endpoint = "users/events",
            token = token,
            page = page,
            pageSize = pageSize
        )
}