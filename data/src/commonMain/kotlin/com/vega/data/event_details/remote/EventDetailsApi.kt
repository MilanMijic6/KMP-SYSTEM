package com.vega.data.event_details.remote

import io.ktor.client.statement.HttpResponse

interface EventDetailsApi {

    suspend fun getEvent(id: String, token: String): HttpResponse
    suspend fun reserveEvent(token: String, eventId: String): HttpResponse

}