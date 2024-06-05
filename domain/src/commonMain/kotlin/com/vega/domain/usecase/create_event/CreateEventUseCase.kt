package com.vega.domain.usecase.create_event

import com.vega.domain.model.create_event.CreateEventRequestBody
import com.vega.domain.repository.create_event.CreateEventRepository

class CreateEventUseCase(
    private val createEventRepository: CreateEventRepository
) {
    suspend fun execute(event: CreateEventRequestBody) {
        createEventRepository.createEvent(event)
    }
}