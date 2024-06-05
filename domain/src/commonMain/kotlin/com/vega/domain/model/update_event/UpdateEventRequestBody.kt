package com.vega.domain.model.update_event

import kotlinx.serialization.Serializable

@Serializable
data class UpdateEventRequestBody(
    val id: String,
    val name: String,
    val description: String,
    val address: String,
    val price: Double,
    val type: String,
    val status: String,
    val image: String,
    val place: String
)