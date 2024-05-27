package com.vega.data.events.remote

import io.ktor.client.statement.HttpResponse

interface UpcomingEventsApi {

    suspend fun getUpcomingEvents(page: Int, pageSize: Int): HttpResponse

}