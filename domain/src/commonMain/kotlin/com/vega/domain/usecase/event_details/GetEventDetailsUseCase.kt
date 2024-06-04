package com.vega.domain.usecase.event_details

import com.vega.domain.repository.event_details.EventDetailsRepository

class GetEventDetailsUseCase(
    private val repository: EventDetailsRepository
) {
    suspend fun execute(id: String) = repository.getEventDetails(id)
}