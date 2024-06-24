package main.home

import BaseViewModel
import com.vega.domain.usecase.events.GetUpcomingEventsUseCase
import com.vega.domain.usecase.login.IsLoggedInUserUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import main.MainContract
import splash.SplashContract

class UpcomingEventsViewModel(
    private val getUpcomingEventsUseCase: GetUpcomingEventsUseCase,
    private val isLoggedInUserUseCase: IsLoggedInUserUseCase
) : BaseViewModel<UpcomingEventsContract.Event, UpcomingEventsContract.State, UpcomingEventsContract.Effect>() {

    private var currentPage = 0

    init {
        isUserLoggedIn()
    }

    override fun setInitialState(): UpcomingEventsContract.State = UpcomingEventsContract.State.Init()

    override fun handleEvents(event: UpcomingEventsContract.Event) {
        when (event) {
            is UpcomingEventsContract.Event.SelectUpcomingEventItem -> event.passEventId()
            is UpcomingEventsContract.Event.ShowUpcomingEvents -> event.getUpcomingEvents()
            is UpcomingEventsContract.Event.ShowUpcomingEventsErrorMsg -> {
                //todo handle later
            }
            UpcomingEventsContract.Event.ClickOnDialogButtonEvent -> clickOnDialogButton()
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
                            upcomingEvents = it.data
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
                if (viewState.value.upcomingEventListScreenModel.isLoggedIn) {
                    UpcomingEventsContract.Effect.NavigateToEventDetailsScreen(eventId)
                } else {
                    UpcomingEventsContract.Effect.ShowLoginDialog
                }
            }
        }
    }

    private fun isUserLoggedIn() {
        viewModelScope.launch {
            runCatching {
                isLoggedInUserUseCase.execute()
            }.onSuccess {
                when (it) {
                    true -> {
                        setState {
                            UpcomingEventsContract.State.Init(
                                viewState.value.upcomingEventListScreenModel.copy(
                                    isLoggedIn = true
                                )
                            )
                        }
                    }
                    false -> {
                        setState {
                            UpcomingEventsContract.State.Init(
                                viewState.value.upcomingEventListScreenModel.copy(
                                    isLoggedIn = false
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    private fun clickOnDialogButton() {
        viewModelScope.launch {
            setEffect {
                UpcomingEventsContract.Effect.NavigateToLoginScreen
            }
        }
    }
}