package com.vega.domain.usecase.event_details

import com.vega.domain.repository.event_details.EventDetailsRepository

class ReserveEventDetailsUseCase(
    private val repository: EventDetailsRepository
) {
    suspend fun execute(eventId: String) = repository.reserveEvent(eventId)

}