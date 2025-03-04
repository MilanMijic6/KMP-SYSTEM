package com.vega.data.create_event.repository

import com.vega.data.auth.storage.SettingsStorage
import com.vega.data.create_event.remote.CreateEventApi
import com.vega.domain.model.create_event.CreateEventRequestBody
import com.vega.domain.repository.create_event.CreateEventRepository

class CreateEventRepositoryImpl(
    private val api: CreateEventApi,
    private val settingsStorage: SettingsStorage
) : CreateEventRepository {
    override suspend fun createEvent(event: CreateEventRequestBody) {
        runCatching {
            settingsStorage.getToken()
        }.mapCatching {
            api.createEvent(
                token = it,
                event = event
            )
        }
    }
}