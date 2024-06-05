package com.vega.domain.usecase.event_details

import com.vega.domain.repository.event_details.EventDetailsRepository

class DeleteEventUseCase(
    private val repository: EventDetailsRepository
) {
    suspend fun execute(eventId: String) = repository.deleteEvent(eventId)

}