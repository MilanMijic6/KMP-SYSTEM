package com.vega.domain.model.create_event

import kotlinx.serialization.Serializable

@Serializable
data class CreateEventRequestBody(
    val name: String,
    val startAt: String,
    val address: String,
    val price: Double,
    val type: String,
    val image: String
)