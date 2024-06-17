package com.vega.data.events.model

import com.vega.domain.model.events.UpcomingEvent
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
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
        image = image,
        dateMonth = formatDateMonth(startAt),
        dateDay = formatDateDay(startAt)
    )
}

private fun formatDateDay(date: String): String {
    var input = date
    if (!date.endsWith("Z")) input += "Z"
    val instant = input.toInstant()
    val dateTime = instant.toLocalDateTime(TimeZone.UTC)
    return dateTime.dayOfMonth.toString()
}

private fun formatDateMonth(date: String): String {
    var input = date
    if (!date.endsWith("Z")) input += "Z"
    val instant = input.toInstant()
    val dateTime = instant.toLocalDateTime(TimeZone.UTC)
    return dateTime.month.name.take(3)
}