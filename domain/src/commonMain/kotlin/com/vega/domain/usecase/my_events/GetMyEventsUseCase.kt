package com.vega.domain.usecase.my_events

import com.vega.domain.repository.my_events.MyEventsRepository

class GetMyEventsUseCase(
    private val repository: MyEventsRepository
) {
    suspend fun execute(page: Int, pageSize: Int) =
        repository.getMyEvents(
            page = page,
            pageSize = pageSize
        )
}