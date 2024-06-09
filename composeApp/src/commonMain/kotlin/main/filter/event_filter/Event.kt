package main.filter.event_filter

import org.jetbrains.compose.resources.DrawableResource

data class Event(
    val type: String,
    val iconRes: DrawableResource
)