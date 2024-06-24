package main.myevents

import com.vega.domain.model.my_events.MyEvent

data class MyEventListScreenModel(
    val myEvents: List<MyEvent>,
    val activeEvents: List<MyEvent>,
    val pastEvents: List<MyEvent>,
    val errorMsg: String?,
    val id: String
)

fun setInitState(): MyEventListScreenModel = MyEventListScreenModel(
    myEvents = emptyList(),
    activeEvents = emptyList(),
    pastEvents = emptyList(),
    errorMsg = "",
    id = ""
)