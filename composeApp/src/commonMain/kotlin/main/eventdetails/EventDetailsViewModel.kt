package main.eventdetails

import BaseViewModel
import com.vega.domain.usecase.event_details.DeleteEventUseCase
import com.vega.domain.usecase.event_details.GetEventDetailsUseCase
import com.vega.domain.usecase.event_details.ReserveEventDetailsUseCase
import com.vega.domain.usecase.login.IsUserCreatorUserCase
import kotlinx.coroutines.launch

class EventDetailsViewModel(
    private val getEventDetailsUseCase: GetEventDetailsUseCase,
    private val reserveEventDetailsUseCase: ReserveEventDetailsUseCase,
    private val deleteEventUseCase: DeleteEventUseCase,
    private val isUserCreatorUserCase: IsUserCreatorUserCase
) : BaseViewModel<EventDetailsContract.Event, EventDetailsContract.State, EventDetailsContract.Effect>() {
    override fun setInitialState(): EventDetailsContract.State = EventDetailsContract.State.Init()

    override fun handleEvents(event: EventDetailsContract.Event) {
        when (event) {
            EventDetailsContract.Event.ClickOnReserveButton -> reserveEvent()
            is EventDetailsContract.Event.ShowEventDetails -> getEventDetails(id = event.id)
            EventDetailsContract.Event.ShowEventDetailsError -> showError()
            EventDetailsContract.Event.ClickBackButton -> navigateBack()
            is EventDetailsContract.Event.ClickOnDeleteButton -> deleteEvent()
            is EventDetailsContract.Event.ClickOnEditButton -> navigateToEditScreen(id = event.id)
        }
    }

    init {
        isUserCreator()
    }

    private fun isUserCreator() {
        viewModelScope.launch {
            runCatching {
                isUserCreatorUserCase.execute()
            }.onSuccess {
                when (it) {
                    true -> {
                        setState {
                            EventDetailsContract.State.IsCreator(
                                viewState.value.eventDetailsModel.copy(
                                    isUserCreator = true
                                )
                            )
                        }
                    }
                    false -> {
                        EventDetailsContract.State.IsCreator(
                            viewState.value.eventDetailsModel.copy(
                                isUserCreator = false
                            )
                        )
                    }
                }
            }
        }
    }

    private fun navigateToEditScreen(id: String) {
        setEffect {
            EventDetailsContract.Effect.NavigateToEditScreen(id = id)
        }
    }

    private fun deleteEvent() {
        val id = viewState.value.eventDetailsModel.eventDetails.id
        if (id.isNotEmpty()) {
            viewModelScope.launch {
                runCatching {
                    deleteEventUseCase.execute(
                        eventId = id
                    )
                }.onSuccess {
                    setEffect {
                        EventDetailsContract.Effect.NavigateBack
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
                    setEffect {
                        EventDetailsContract.Effect.NavigateBack
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