package com.vega.domain.model.events

import kotlinx.serialization.Serializable

@Serializable
data class UpcomingEventsResponse(
    val pageNumber: Int,
    val totalPages: Int,
    val data: List<UpcomingEvent>
)