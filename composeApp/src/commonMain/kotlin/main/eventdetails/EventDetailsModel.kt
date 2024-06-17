package main.eventdetails

import com.vega.domain.model.event_details.EventDetails

data class EventDetailsModel(
    val eventDetails: EventDetails,
    val errorMsg: String?
)

fun setInitState(): EventDetailsModel = EventDetailsModel(
    eventDetails = EventDetails(
        id = "",
        startAt = "",
        address = "",
        price = 0.0,
        type = "",
        name = "",
        description = "",
        image = "",
        status = "",
        place = ""
    ),
    errorMsg = ""
)