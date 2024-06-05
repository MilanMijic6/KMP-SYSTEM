package com.vega.domain.repository.my_events

import com.vega.domain.model.my_events.MyEventsResponse

interface MyEventsRepository {

    suspend fun getMyEvents(page: Int, pageSize: Int): MyEventsResponse

}