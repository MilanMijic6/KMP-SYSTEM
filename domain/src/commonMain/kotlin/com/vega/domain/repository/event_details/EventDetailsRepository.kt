package com.vega.domain.repository.event_details

import com.vega.domain.model.event_details.EventDetails

interface EventDetailsRepository {

    suspend fun getEventDetails(id: String): EventDetails

    suspend fun reserveEvent(eventId: String)

    suspend fun deleteEvent(id: String)
}