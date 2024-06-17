package com.vega.data.event_details.model

import com.vega.domain.model.event_details.EventDetails
import kotlinx.serialization.Serializable

@Serializable
data class EventDetailsDto(
    val id: Int,
    val name: String,
    val description: String?,
    val startAt: String,
    val address: String,
    val price: Double,
    val type: String,
    val place: String?,
    val status: String?,
    val image: String,
)

fun EventDetailsDto.toEvent(): EventDetails {
    return EventDetails(
        id = id.toString(),
        description = if (description.isNullOrEmpty()) "" else description,
        startAt = startAt,
        address = address,
        price = price,
        type = type,
        place = if (place.isNullOrEmpty()) "" else place,
        status = if (status.isNullOrEmpty()) "" else status,
        image = image,
        name = name,
        startDate = "",
        startTime = ""
    )
}