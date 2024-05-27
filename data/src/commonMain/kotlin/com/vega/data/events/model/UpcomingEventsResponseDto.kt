package com.vega.data.events.model

import com.vega.domain.model.events.UpcomingEventsResponse
import kotlinx.serialization.Serializable

@Serializable
data class UpcomingEventsResponseDto(
    val pageNumber: Int,
    val totalPages: Int,
    val data: List<UpcomingEventDto>
)

fun UpcomingEventsResponseDto.toUpcomingEventsResponse(): UpcomingEventsResponse {
    return UpcomingEventsResponse(
        totalPages = totalPages,
        pageNumber = pageNumber,
        data = data.map { event-> event.toUpcomingEvent() }
    )
}