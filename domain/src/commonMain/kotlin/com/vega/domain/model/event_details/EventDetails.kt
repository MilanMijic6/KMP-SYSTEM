package com.vega.domain.model.event_details

import kotlinx.serialization.Serializable

@Serializable
data class EventDetails(
    val id: String,
    val name: String,
    val description: String,
    val startAt: String,
    val address: String,
    val price: Double,
    val type: String,
    val place: String,
    val status: String,
    val image: String,
    val startDate: String,
    val startTime: String
)
