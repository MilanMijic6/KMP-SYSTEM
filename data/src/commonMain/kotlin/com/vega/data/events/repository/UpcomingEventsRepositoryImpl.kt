package com.vega.data.events.repository

import com.vega.data.events.model.UpcomingEventsResponseDto
import com.vega.data.events.model.toUpcomingEvent
import com.vega.data.events.model.toUpcomingEventsResponse
import com.vega.data.events.remote.UpcomingEventsApi
import com.vega.domain.model.events.UpcomingEvent
import com.vega.domain.model.events.UpcomingEventsResponse
import com.vega.domain.repository.events.UpcomingEventsRepository
import io.ktor.client.call.body

class UpcomingEventsRepositoryImpl(
    private val upcomingEventsApi: UpcomingEventsApi
) : UpcomingEventsRepository {
    override suspend fun getUpcomingEvents(page: Int, pageSize: Int): UpcomingEventsResponse =
        runCatching {
            upcomingEventsApi.getUpcomingEvents(page, pageSize)
        }.mapCatching {
            it.body<UpcomingEventsResponseDto>().toUpcomingEventsResponse()
        }.getOrThrow()
}