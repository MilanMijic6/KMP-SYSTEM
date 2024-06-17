package main.home

import ViewEvent
import ViewSideEffect
import ViewState
import main.MainContract

class UpcomingEventsContract {
    sealed class Event : ViewEvent {
        data class ShowUpcomingEvents(val page: Int, val pageSize: Int) : Event()
        data object ShowUpcomingEventsErrorMsg : Event()
        data class SelectUpcomingEventItem(val eventId: String) : Event()
        data object ClickOnDialogButtonEvent: Event()

    }

    sealed class State : ViewState {
        abstract val upcomingEventListScreenModel: UpcomingEventListScreenModel

        data class Init(
            override val upcomingEventListScreenModel: UpcomingEventListScreenModel = setInitState()
        ) : State()

        data class Success(
            override val upcomingEventListScreenModel: UpcomingEventListScreenModel
        ) : State()

        data class Error(
            override val upcomingEventListScreenModel: UpcomingEventListScreenModel
        ) : State()
    }

    sealed class Effect : ViewSideEffect {
        data class NavigateToEventDetailsScreen(val eventId: String) : Effect()

        data object ShowLoginDialog : Effect()

        data object NavigateToLoginScreen: Effect()

    }
}
