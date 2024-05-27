package com.vega.domain.repository.events

import com.vega.domain.model.events.UpcomingEventsResponse

interface UpcomingEventsRepository {

    suspend fun getUpcomingEvents(page: Int, pageSize: Int): UpcomingEventsResponse

}