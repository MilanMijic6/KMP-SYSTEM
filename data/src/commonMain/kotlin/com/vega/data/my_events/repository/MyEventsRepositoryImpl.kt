package com.vega.data.my_events.repository

import com.vega.data.auth.storage.SettingsStorage
import com.vega.data.my_events.model.MyEventsResponseDto
import com.vega.data.my_events.model.toMyEventsResponse
import com.vega.data.my_events.remote.MyEventsApi
import com.vega.domain.model.my_events.MyEventsResponse
import com.vega.domain.repository.my_events.MyEventsRepository
import io.ktor.client.call.body

class MyEventsRepositoryImpl(
    private val api: MyEventsApi,
    private val storage: SettingsStorage
) : MyEventsRepository {
    override suspend fun getMyEvents(page: Int, pageSize: Int): MyEventsResponse =
        runCatching {
            storage.getToken()
        }.mapCatching {
            api.getMyEvents(
                token = it,
                page = page,
                pageSize = pageSize
            )
        }.mapCatching {
            it.body<MyEventsResponseDto>().toMyEventsResponse()
        }.getOrThrow()
}