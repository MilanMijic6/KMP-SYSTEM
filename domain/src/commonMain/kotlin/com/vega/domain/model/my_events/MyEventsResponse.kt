package com.vega.domain.model.my_events

import kotlinx.serialization.Serializable

@Serializable
data class MyEventsResponse(
    val totalCount: Int,
    val results: List<MyEvent>
)