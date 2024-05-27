package com.vega.domain.repository.events

import com.vega.domain.model.events.UpcomingEvent

interface UpcomingEventsRepository {

    suspend fun getUpcomingEvents(page: Int, pageSize: Int): List<UpcomingEvent>

}