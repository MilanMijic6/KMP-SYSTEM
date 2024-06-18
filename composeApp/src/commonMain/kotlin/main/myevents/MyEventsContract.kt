package main.myevents

import ViewEvent
import ViewSideEffect
import ViewState

class MyEventsContract {
    sealed class Event : ViewEvent {
        data class ShowMyEvents(val page: Int, val pageSize: Int) : Event()
        data object ShowMyEventsErrorMsg : Event()
        data class SelectMyEventItem(val eventId: String) : Event()

    }

    sealed class State : ViewState {
        abstract val myEventListScreenModel: MyEventListScreenModel

        data class Init(
            override val myEventListScreenModel: MyEventListScreenModel = setInitState()
        ) : State()

        data class Success(
            override val myEventListScreenModel: MyEventListScreenModel
        ) : State()

        data class Error(
            override val myEventListScreenModel: MyEventListScreenModel
        ) : State()
    }

    sealed class Effect : ViewSideEffect {
        data class NavigateToMyEventDetailsScreen(val eventId: String) : Effect()

    }
}