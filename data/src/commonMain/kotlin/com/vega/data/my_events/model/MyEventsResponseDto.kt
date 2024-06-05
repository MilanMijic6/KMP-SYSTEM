package com.vega.data.my_events.model

import com.vega.domain.model.my_events.MyEventsResponse
import kotlinx.serialization.Serializable

@Serializable
data class MyEventsResponseDto(
    val pageNumber: Int,
    val totalPages: Int,
    val data: List<MyEventDto>
)

fun MyEventsResponseDto.toMyEventsResponse(): MyEventsResponse {
    return MyEventsResponse(
        totalPages = totalPages,
        pageNumber = pageNumber,
        data = data.map { event-> event.toMyEvent() }
    )
}