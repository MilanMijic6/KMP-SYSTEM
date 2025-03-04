package main.myevents

import BaseViewModel
import com.vega.domain.model.my_events.MyEvent
import com.vega.domain.usecase.my_events.GetMyEventsUseCase
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class MyEventsViewModel(
    private val getMyEventsUseCase: GetMyEventsUseCase
) : BaseViewModel<MyEventsContract.Event, MyEventsContract.State, MyEventsContract.Effect>() {

    private var currentPage = 0
    override fun setInitialState(): MyEventsContract.State =
        MyEventsContract.State.Init()

    override fun handleEvents(event: MyEventsContract.Event) {
        when (event) {
            is MyEventsContract.Event.SelectMyEventItem -> event.passEventId()
            is MyEventsContract.Event.ShowMyEvents -> event.getMyEvents()
            MyEventsContract.Event.ShowMyEventsErrorMsg -> TODO()
        }
    }

    private fun MyEventsContract.Event.ShowMyEvents.getMyEvents() {
        viewModelScope.launch {
            runCatching {
                getMyEventsUseCase.execute(currentPage, pageSize)
            }.onSuccess {
                currentPage++
                setState {
                    MyEventsContract.State.Success(
                        viewState.value.myEventListScreenModel.copy(
                            myEvents = it.results
                        )
                    )
                }
            }.onFailure {
                setState {
                    MyEventsContract.State.Error(
                        viewState.value.myEventListScreenModel.copy(
                            errorMsg = it.message
                        )
                    )
                }
            }
        }
    }

    private fun MyEventsContract.Event.SelectMyEventItem.passEventId() {
        viewModelScope.launch {
            setEffect {
                MyEventsContract.Effect.NavigateToMyEventDetailsScreen(eventId)
            }
        }
    }

    fun splitEvents(events: List<MyEvent>): Pair<List<MyEvent>, List<MyEvent>> {
        val now = Clock.System.now()

        val (pastEvents, activeEvents) = events.partition {
            var date = it.startAt
            if (!it.startAt.endsWith("Z")) date += "Z"
            val eventDate = Instant.parse(date)
            eventDate < now
        }

        return pastEvents to activeEvents
    }
}