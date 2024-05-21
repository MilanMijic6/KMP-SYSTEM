package splash

import ViewEvent
import ViewSideEffect
import ViewState

class SplashContract {
    sealed class Event : ViewEvent

    class State : ViewState

    sealed class Effect : ViewSideEffect {
        data object NavigateToMainScreen : Effect()
        data object NavigateToRegisterScreen : Effect()
    }
}