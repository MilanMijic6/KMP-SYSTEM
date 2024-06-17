package main.eventdetails

import BaseViewModel
import com.vega.domain.usecase.event_details.GetEventDetailsUseCase
import com.vega.domain.usecase.event_details.ReserveEventDetailsUseCase
import kotlinx.coroutines.launch

class EventDetailsViewModel(
    private val getEventDetailsUseCase: GetEventDetailsUseCase,
    private val reserveEventDetailsUseCase: ReserveEventDetailsUseCase
) : BaseViewModel<EventDetailsContract.Event, EventDetailsContract.State, EventDetailsContract.Effect>() {
    override fun setInitialState(): EventDetailsContract.State = EventDetailsContract.State.Init()

    override fun handleEvents(event: EventDetailsContract.Event) {
        when (event) {
            EventDetailsContract.Event.ClickOnReserveButton -> reserveEvent()
            is EventDetailsContract.Event.ShowEventDetails -> getEventDetails(id = event.id)
            EventDetailsContract.Event.ShowEventDetailsError -> showError()
            EventDetailsContract.Event.ClickBackButton -> navigateBack()
        }
    }

    private fun navigateBack() {
        viewModelScope.launch {
            setEffect {
                EventDetailsContract.Effect.NavigateBack
            }
        }
    }

    private fun showError() {
        setState {
            EventDetailsContract.State.Error(viewState.value.eventDetailsModel.copy(errorMsg = "Something went wrong"))
        }
    }

    private fun getEventDetails(
        id: String
    ) {
        viewModelScope.launch {
            runCatching {
                getEventDetailsUseCase.execute(
                    id = id
                )
            }.onSuccess {
                setState {
                    EventDetailsContract.State.LoadedSuccessEvent(
                        viewState.value.eventDetailsModel.copy(
                            eventDetails = it
                        )
                    )
                }
            }.onFailure {
                setState {
                    EventDetailsContract.State.Error(
                        viewState.value.eventDetailsModel.copy(
                            errorMsg = it.message
                        )
                    )
                }
            }
        }
    }

    private fun reserveEvent() {
        val id = viewState.value.eventDetailsModel.eventDetails.id
        if (id.isNotEmpty()) {
            viewModelScope.launch {
                runCatching {
                    reserveEventDetailsUseCase.execute(
                        eventId = id
                    )
                }.onSuccess {
                    setState {
                        EventDetailsContract.State.Reserve(
                            viewState.value.eventDetailsModel
                        )
                    }
                }.onFailure {
                    setState {
                        EventDetailsContract.State.Error(
                            viewState.value.eventDetailsModel.copy(
                                errorMsg = it.message
                            )
                        )
                    }
                }
            }
        }
    }
}