package com.vega.data.my_events.model

import com.vega.domain.model.my_events.MyEventsResponse
import kotlinx.serialization.Serializable

@Serializable
data class MyEventsResponseDto(
    val totalCount: Int,
    val results: List<MyEventDto>
)

fun MyEventsResponseDto.toMyEventsResponse(): MyEventsResponse {
    return MyEventsResponse(
        totalCount = totalCount,
        results = results.map { event-> event.toMyEvent() }
    )
}