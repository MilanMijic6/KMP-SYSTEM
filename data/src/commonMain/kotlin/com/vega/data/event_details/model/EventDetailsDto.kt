package com.vega.data.event_details.model

import com.vega.domain.model.event_details.EventDetails
import kotlinx.serialization.Serializable

@Serializable
data class EventDetailsDto(
    val id: String,
    val description: String,
    val startAt: String,
    val address: String,
    val price: Double,
    val type: String,
    val place: String,
    val status: String
)

fun EventDetailsDto.toEvent(): EventDetails {
    return EventDetails(
        id = id,
        description = description,
        startAt = startAt,
        address = address,
        price = price,
        type = type,
        place = place,
        status = status
    )
}