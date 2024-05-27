package main.home

import com.vega.domain.model.events.UpcomingEvent

data class UpcomingEventListScreenModel(
    val upcomingEvents: List<UpcomingEvent>,
    val errorMsg: String?,
    val id: String
)

fun setInitState(): UpcomingEventListScreenModel = UpcomingEventListScreenModel(
    upcomingEvents = emptyList(),
    errorMsg = "",
    id = ""
)