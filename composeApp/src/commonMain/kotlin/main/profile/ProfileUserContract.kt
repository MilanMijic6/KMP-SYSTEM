package main.profile

import ViewEvent
import ViewSideEffect
import ViewState

class ProfileUserContract {
    sealed class Event : ViewEvent {
        data object ShowUserInfo : Event()
        data object ShowUserinfoError : Event()
        data object SubmitButtonClick : Event()
        data class UpdateEmailInput(val inputValue: String) : Event()
        data class UpdateNameInput(val inputValue: String) : Event()
        data class UpdateProfilePicture(val profilePicture: String) : Event()

    }

    sealed class State : ViewState {
        abstract val profilerUserModel: ProfileUserScreenModel

        data class Init(
            override val profilerUserModel: ProfileUserScreenModel = setInitState()
        ) : State()

        data class Loading(
            override val profilerUserModel: ProfileUserScreenModel
        ) : State()

        data class Error(
            override val profilerUserModel: ProfileUserScreenModel
        ) : State()

        data class UpdateSuccess(
            override val profilerUserModel: ProfileUserScreenModel
        ) : State()
    }

    sealed class Effect : ViewSideEffect
}