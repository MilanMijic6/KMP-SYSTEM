package com.vega.data.update_event.repository

import com.vega.data.auth.storage.SettingsStorage
import com.vega.data.update_event.remote.UpdateEventApi
import com.vega.domain.model.update_event.UpdateEventRequestBody
import com.vega.domain.repository.update_event.UpdateEventRepository

class UpdateEventRepositoryImpl(
    private val api: UpdateEventApi,
    private val settingsStorage: SettingsStorage
) : UpdateEventRepository {
    override suspend fun updateEvent(eventRequestBody: UpdateEventRequestBody) {
        runCatching {
            settingsStorage.getToken()
        }.mapCatching {
            api.updateEvent(
                token = it,
                event = eventRequestBody
            )
        }
    }
}