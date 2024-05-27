package com.vega.domain.model.events

import kotlinx.serialization.Serializable

@Serializable
data class UpcomingEvent(
    val id: Int,
    val name: String,
    val startAt: String,
    val address: String,
    val price: Double,
    val type: String,
    val image: String
)