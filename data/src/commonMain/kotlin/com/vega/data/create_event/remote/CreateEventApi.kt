package com.vega.data.create_event.remote

import com.vega.domain.model.create_event.CreateEventRequestBody
import io.ktor.client.statement.HttpResponse

interface CreateEventApi {
    suspend fun createEvent(token: String, event: CreateEventRequestBody) : HttpResponse
}