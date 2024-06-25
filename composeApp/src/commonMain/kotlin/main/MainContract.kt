package main

import ViewEvent
import ViewSideEffect
import ViewState

class MainContract {
    sealed class Event : ViewEvent {

        data object ClickOnHomeEvent : Event()
        data object ClickOnMyEventsEvent : Event()
        data object ClickOnAccountEvent : Event()
        data object ClickOnFilterEvent : Event()
        data object ClickOnScanEvent : Event()
        data object ClickOnLogoutEvent : Event()
        data object ClickOnDialogButtonEvent: Event()
    }

    sealed class State : ViewState {
        abstract val mainScreenModel: MainScreenModel

        data class LoggedIn(
            override val mainScreenModel: MainScreenModel = setInitState()
        ) : State()

        data class NotLoggedIn(
            override val mainScreenModel: MainScreenModel
        ) : State()

        data class IsCreator(
            override val mainScreenModel: MainScreenModel
        ) : State()
    }

    sealed class Effect : ViewSideEffect {
        data object NavigateToHomeScreen : Effect()

        data object NavigateToMyEventsScreen : Effect()

        data object NavigateToAccountScreen : Effect()

        data object NavigateToFilterScreen : Effect()

        data object NavigateToScanScreen: Effect()

        data object LogoutUser: Effect()

        data object ShowLoginDialog : Effect()

        data object NavigateToLoginScreen : Effect()
    }
}