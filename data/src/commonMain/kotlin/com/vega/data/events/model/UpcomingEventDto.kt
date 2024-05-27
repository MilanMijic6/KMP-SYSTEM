package com.vega.data.events.model

import com.vega.domain.model.events.UpcomingEvent
import kotlinx.serialization.Serializable

@Serializable
data class UpcomingEventDto(
    val id: Int,
    val name: String,
    val startAt: String,
    val address: String,
    val price: Double,
    val type: String,
    val image: String
)

fun UpcomingEventDto.toUpcomingEvent(): UpcomingEvent {
    return UpcomingEvent(
        id = id,
        name = name,
        startAt = startAt,
        address = address,
        price = price,
        type = type,
        image = image
    )
}