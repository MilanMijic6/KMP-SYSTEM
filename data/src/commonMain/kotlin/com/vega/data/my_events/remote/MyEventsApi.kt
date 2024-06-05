package com.vega.data.my_events.remote

import io.ktor.client.statement.HttpResponse

interface MyEventsApi {

    suspend fun getMyEvents(token: String, page: Int, pageSize: Int): HttpResponse

}