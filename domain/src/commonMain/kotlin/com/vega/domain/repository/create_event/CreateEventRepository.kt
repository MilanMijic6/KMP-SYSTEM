package com.vega.domain.repository.create_event

import com.vega.domain.model.create_event.CreateEventRequestBody

interface CreateEventRepository {

    suspend fun createEvent(event: CreateEventRequestBody)

}