package com.vega.domain.usecase.update_event

import com.vega.domain.model.update_event.UpdateEventRequestBody
import com.vega.domain.repository.update_event.UpdateEventRepository

class UpdateEventUseCase(
    private val repository: UpdateEventRepository
) {
    suspend fun execute(parameter: UpdateEventRequestBody) =
        repository.updateEvent(eventRequestBody = parameter)
}