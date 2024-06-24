package com.vega.data.my_events.model

import com.vega.data.events.model.formatDateDay
import com.vega.data.events.model.formatDateMonth
import com.vega.domain.model.my_events.MyEvent
import kotlinx.serialization.Serializable

@Serializable
data class MyEventDto(
    val id: Int,
    val name: String,
    val place: String?,
    val description: String?,
    val startAt: String,
    val address: String,
    val price: Double,
    val type: String,
    val image: String,
    val status: String,
)

fun MyEventDto.toMyEvent(): MyEvent {
    return MyEvent(
        id = id,
        name = name,
        startAt = startAt,
        address = address,
        price = price,
        type = type,
        image = image,
        status = status,
        dateMonth = formatDateMonth(startAt),
        dateDay = formatDateDay(startAt),
        description = if (description.isNullOrEmpty()) "" else description,
        place = if (place.isNullOrEmpty()) "" else place
    )
}