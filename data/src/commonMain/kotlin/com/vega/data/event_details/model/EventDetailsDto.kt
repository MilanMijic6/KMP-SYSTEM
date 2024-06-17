package com.vega.data.event_details.model

import com.vega.domain.model.event_details.EventDetails
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
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
        startDate = convertDateTime(startAt),
        startTime = convertStartTime(startAt)
    )
}

private fun convertDateTime(date: String): String {
    var input = date
    if (!date.endsWith("Z")) input += "Z"
    val instant = input.toInstant()
    val timeZone = TimeZone.currentSystemDefault()
    val localDateTime = instant.toLocalDateTime(timeZone)
    val day = localDateTime.dayOfMonth
    val month = localDateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }
    val year = localDateTime.year
    val formattedDate = "$day $month, $year"
    return formattedDate
}

private fun convertStartTime(date: String): String {
    var input = date
    if (!date.endsWith("Z")) input += "Z"
    val instant = input.toInstant()
    val timeZone = TimeZone.currentSystemDefault()
    val localDateTime = instant.toLocalDateTime(timeZone)
    val dayOfWeek = localDateTime.dayOfWeek.name.lowercase().replaceFirstChar { it.uppercase() }
    val hour = if (localDateTime.hour % 12 == 0) 12 else localDateTime.hour % 12
    val minute = localDateTime.minute
    val amPm = if (localDateTime.hour >= 12) "PM" else "AM"
    val formattedMinute = if (minute < 10) "0$minute" else minute.toString()
    val formattedHour = if (hour < 10) "0$hour" else hour.toString()
    val formattedTime = "$dayOfWeek, $formattedHour:$formattedMinute$amPm"
    return formattedTime
}