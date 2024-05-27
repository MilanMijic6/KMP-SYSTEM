package main.home

import BaseViewModel
import com.vega.domain.usecase.events.GetUpcomingEventsUseCase
import kotlinx.coroutines.launch

class UpcomingEventsViewModel(
    private val getUpcomingEventsUseCase: GetUpcomingEventsUseCase
) : BaseViewModel<UpcomingEventsContract.Event, UpcomingEventsContract.State, UpcomingEventsContract.Effect>() {

    private var currentPage = 0

    override fun setInitialState(): UpcomingEventsContract.State = UpcomingEventsContract.State.Init()

    override fun handleEvents(event: UpcomingEventsContract.Event) {
        when (event) {
            is UpcomingEventsContract.Event.SelectUpcomingEventItem -> event.passEventId()
            is UpcomingEventsContract.Event.ShowUpcomingEvents -> event.getUpcomingEvents()
            is UpcomingEventsContract.Event.ShowUpcomingEventsErrorMsg -> TODO()
        }
    }

    private fun UpcomingEventsContract.Event.ShowUpcomingEvents.getUpcomingEvents() {
        viewModelScope.launch {
            runCatching {
                getUpcomingEventsUseCase.execute(currentPage, pageSize)
            }.onSuccess {
                currentPage++
                setState {
                    UpcomingEventsContract.State.Success(
                        viewState.value.upcomingEventListScreenModel.copy(
                            upcomingEvents = it
                        )
                    )
                }
            }.onFailure {
                setState {
                    UpcomingEventsContract.State.Error(
                        viewState.value.upcomingEventListScreenModel.copy(
                            errorMsg = it.message
                        )
                    )
                }
            }
        }
    }

    private fun UpcomingEventsContract.Event.SelectUpcomingEventItem.passEventId() {
        viewModelScope.launch {
            setEffect {
                UpcomingEventsContract.Effect.NavigateToEventDetailsScreen(eventId)
            }
        }
    }
}