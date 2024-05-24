package auth.login

import ViewEvent
import ViewSideEffect
import ViewState

class LoginContract {
    sealed class Event : ViewEvent {

        data object LoginUserEvent : Event()
        data object LoginAnonymouslyEvent : Event()
        data class EmailEnterEvent(val emailAddress: String) : Event()
        data class PasswordEnterEvent(val password: String) : Event()

    }

    sealed class State : ViewState {
        abstract val loginScreenModel: LoginScreenModel

        data class Init(
            override val loginScreenModel: LoginScreenModel = setInitState()
        ) : State()

        data class Error(
            override val loginScreenModel: LoginScreenModel
        ) : State()
    }

    sealed class Effect : ViewSideEffect {
        data object NavigateToMainScreen : Effect()

    }
}