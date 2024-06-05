package com.vega.domain.repository.update_event

import com.vega.domain.model.update_event.UpdateEventRequestBody

interface UpdateEventRepository {

    suspend fun updateEvent(
        eventRequestBody: UpdateEventRequestBody
    )
}