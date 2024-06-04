package com.vega.data.event_details.repository

import com.vega.data.auth.storage.SettingsStorage
import com.vega.data.event_details.model.EventDetailsDto
import com.vega.data.event_details.model.toEvent
import com.vega.data.event_details.remote.EventDetailsApi
import com.vega.domain.model.event_details.EventDetails
import com.vega.domain.repository.event_details.EventDetailsRepository
import io.ktor.client.call.body

class EventDetailsRepositoryImpl(
    private val api: EventDetailsApi,
    private val storage: SettingsStorage
) : EventDetailsRepository {
    override suspend fun getEventDetails(id: String): EventDetails =
        runCatching {
            storage.getToken()
        }.mapCatching {
            api.getEvent(
                id = id,
                token = it
            )
        }.mapCatching {
            it.body<EventDetailsDto>().toEvent()
        }.getOrThrow()

    override suspend fun reserveEvent(eventId: String) {
        runCatching {
            storage.getToken()
        }.mapCatching {
            api.reserveEvent(
                eventId = eventId,
                token = it
            )
        }
    }
}