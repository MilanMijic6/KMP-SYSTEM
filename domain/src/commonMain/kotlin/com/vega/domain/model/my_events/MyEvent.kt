package com.vega.domain.model.my_events

import kotlinx.serialization.Serializable

@Serializable
data class MyEvent(
    val id: Int,
    val name: String,
    val startAt: String,
    val dateDay: String,
    val dateMonth: String,
    val address: String,
    val price: Double,
    val type: String,
    val image: String,
    val status: String
)