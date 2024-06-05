package com.vega.data.update_event.remote

import com.vega.domain.model.update_event.UpdateEventRequestBody
import io.ktor.client.statement.HttpResponse

interface UpdateEventApi {
    suspend fun updateEvent(token: String, event: UpdateEventRequestBody) : HttpResponse
}