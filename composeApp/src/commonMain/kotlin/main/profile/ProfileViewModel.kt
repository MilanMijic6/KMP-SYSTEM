package main.profile

import BaseViewModel
import com.vega.domain.usecase.profile.GetUserUseCase
import com.vega.domain.usecase.profile.UpdateUserUseCase
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase
) : BaseViewModel<ProfileUserContract.Event, ProfileUserContract.State, ProfileUserContract.Effect>() {
    override fun setInitialState(): ProfileUserContract.State = ProfileUserContract.State.Init()

    override fun handleEvents(event: ProfileUserContract.Event) {
        when (event) {
            ProfileUserContract.Event.ShowUserInfo -> getCurrentUser()
            ProfileUserContract.Event.ShowUserinfoError -> showError()
            is ProfileUserContract.Event.SubmitButtonClick -> event.updateUser()
            is ProfileUserContract.Event.UpdateEmailInput -> event.updateEmailInput()
            is ProfileUserContract.Event.UpdateNameInput -> event.updateNameInput()
            is ProfileUserContract.Event.UpdateProfilePicture -> event.updateProfilePicture()
        }
    }

    private fun showError() {
        setState {
            ProfileUserContract.State.Error(viewState.value.profilerUserModel.copy(errorMsg = "Something went wrong"))
        }
    }

    private fun getCurrentUser() {
        viewModelScope.launch {
            runCatching {
                getUserUseCase.execute()
            }.onSuccess {
                setState {
                    ProfileUserContract.State.Init(
                        viewState.value.profilerUserModel.copy(
                            user = it
                        )
                    )
                }
            }.onFailure {
                setState {
                    ProfileUserContract.State.Error(
                        viewState.value.profilerUserModel.copy(
                            errorMsg = it.message
                        )
                    )
                }
            }
        }
    }

    private fun ProfileUserContract.Event.UpdateNameInput.updateNameInput() {
        viewModelScope.launch {
            setState {
                ProfileUserContract.State.Init(
                    viewState.value.profilerUserModel.copy(
                        updateName = inputValue,
                        isEnabledButton = inputValue.isNotEmpty()
                    )
                )
            }
        }
    }

    private fun ProfileUserContract.Event.UpdateEmailInput.updateEmailInput() {
        viewModelScope.launch {
            setState {
                ProfileUserContract.State.Init(
                    viewState.value.profilerUserModel.copy(
                        updateEmail = inputValue,
                        isEnabledButton = inputValue.isNotEmpty()
                    )
                )
            }
        }
    }

    private fun ProfileUserContract.Event.UpdateProfilePicture.updateProfilePicture() {
        viewModelScope.launch {
            setState {
                ProfileUserContract.State.Init(
                    viewState.value.profilerUserModel.copy(
                        updatedProfilePicture = profilePicture,
                        isEnabledButton = profilePicture.isNotEmpty()
                    )
                )
            }
        }
    }

    private fun ProfileUserContract.Event.SubmitButtonClick.updateUser() {
        setState {
            ProfileUserContract.State.Loading(viewState.value.profilerUserModel)
        }
        viewModelScope.launch {
            runCatching {
                updateUserUseCase.execute(
                    name = name,
                    email = email,
                    profilePicture = profilePicture
                )
            }.onSuccess {
                setState {
                    ProfileUserContract.State.UpdateSuccess(viewState.value.profilerUserModel)
                }
            }.onFailure {
                setState {
                    ProfileUserContract.State.Error(viewState.value.profilerUserModel.copy(errorMsg = it.message.toString()))
                }
            }
        }
    }
}