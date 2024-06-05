package com.vega.domain.model.my_events

import kotlinx.serialization.Serializable

@Serializable
data class MyEventsResponse(
    val pageNumber: Int,
    val totalPages: Int,
    val data: List<MyEvent>
)