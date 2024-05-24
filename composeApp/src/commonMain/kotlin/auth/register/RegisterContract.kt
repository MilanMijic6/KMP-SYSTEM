package auth.register

import ViewEvent
import ViewSideEffect
import ViewState

class RegisterContract {

    sealed class Event : ViewEvent {

        data object RegisterUserEvent: Event()
        data object LoginScreenEvent: Event()
        data object LoginAnonymouslyEvent : Event()
        data class EmailEnterEvent(val emailAddress: String) : Event()
        data class PasswordEnterEvent(val password: String) : Event()
        data class NameEnterEvent(val name: String) : Event()
        data class RoleEnterEvent(val role: String) : Event()

    }

    sealed class State : ViewState {
        abstract val registerScreenModel: RegisterScreenModel

        data class Init(
            override val registerScreenModel: RegisterScreenModel = setInitState()
        ) : State()

        data class Error(
            override val registerScreenModel: RegisterScreenModel
        ) : State()
    }

    sealed class Effect : ViewSideEffect {
        data object NavigateToMainScreen : Effect()
        data object NavigateToLoginScreen : Effect()
    }
}