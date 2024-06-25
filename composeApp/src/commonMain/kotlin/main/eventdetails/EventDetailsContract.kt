package main.eventdetails

import ViewEvent
import ViewSideEffect
import ViewState

class EventDetailsContract {
    sealed class Event : ViewEvent {
        data object ShowEventDetailsError : Event()
        data class ShowEventDetails(val id: String): Event()
        data object ClickOnReserveButton: Event()
        data object ClickBackButton: Event()
        data class ClickOnEditButton(val id: String): Event()
        data class ClickOnDeleteButton(val id: String): Event()
    }

    sealed class State : ViewState {
        abstract val eventDetailsModel: EventDetailsModel

        data class Init(
            override val eventDetailsModel: EventDetailsModel = setInitState()
        ) : State()

        data class LoadedSuccessEvent(
            override val eventDetailsModel: EventDetailsModel
        ) : State()

        data class Error(
            override val eventDetailsModel: EventDetailsModel
        ) : State()

        data class IsCreator(
            override val eventDetailsModel: EventDetailsModel
        ) : State()
    }

    sealed class Effect : ViewSideEffect {
        data object NavigateBack : Effect()
        data class NavigateToEditScreen(val id: String): Effect()
    }
}