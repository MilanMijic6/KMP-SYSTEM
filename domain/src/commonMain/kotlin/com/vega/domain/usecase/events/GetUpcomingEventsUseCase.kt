package com.vega.domain.usecase.events

import com.vega.domain.repository.events.UpcomingEventsRepository

class GetUpcomingEventsUseCase (
    private val repository: UpcomingEventsRepository
) {
    suspend fun execute(page: Int, pageSize: Int) =
        repository.getUpcomingEvents(
            page = page,
            pageSize = pageSize
        )
}