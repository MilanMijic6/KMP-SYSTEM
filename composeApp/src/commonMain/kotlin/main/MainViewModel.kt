package main

import BaseViewModel
import com.vega.domain.usecase.login.IsLoggedInUserUseCase
import com.vega.domain.usecase.login.IsUserCreatorUserCase
import com.vega.domain.usecase.profile.LogoutUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val isLoggedInUserUseCase: IsLoggedInUserUseCase,
    private val logoutUserUseCase: LogoutUseCase,
    private val isUserCreatorUserCase: IsUserCreatorUserCase
) : BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    override fun setInitialState(): MainContract.State = MainContract.State.LoggedIn()

    override fun handleEvents(event: MainContract.Event) {
        when (event) {
            MainContract.Event.ClickOnAccountEvent -> clickOnAccount()
            MainContract.Event.ClickOnFilterEvent -> clickOnFilter()
            MainContract.Event.ClickOnMyEventsEvent -> clickOnMyEvents()
            MainContract.Event.ClickOnHomeEvent -> clickOnHome()
            MainContract.Event.ClickOnLogoutEvent -> logout()
            MainContract.Event.ClickOnScanEvent -> clickOnScan()
            MainContract.Event.ClickOnDialogButtonEvent -> clickOnDialogButton()
        }
    }

    init {
        isUserLoggedIn()
        isUserCreator()
    }

    private fun isUserCreator() {
        viewModelScope.launch {
            runCatching {
                isUserCreatorUserCase.execute()
            }.onSuccess {
                when (it) {
                    true -> {
                        setState {
                            MainContract.State.IsCreator(
                                viewState.value.mainScreenModel.copy(
                                    isCreator = true
                                )
                            )
                        }
                    }
                    false -> {
                        MainContract.State.IsCreator(
                            viewState.value.mainScreenModel.copy(
                                isCreator = false
                            )
                        )
                    }
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
                            MainContract.State.LoggedIn(
                                viewState.value.mainScreenModel.copy(
                                    isLoggedIn = true
                                )
                            )
                        }
                    }
                    false -> {
                        MainContract.State.NotLoggedIn(
                            viewState.value.mainScreenModel.copy(
                                isLoggedIn = false
                            )
                        )
                    }
                }
            }
        }
    }

    private fun clickOnAccount() {
        viewModelScope.launch {
            setEffect {
                if (viewState.value.mainScreenModel.isLoggedIn) {
                    MainContract.Effect.NavigateToAccountScreen
                } else {
                    MainContract.Effect.ShowLoginDialog
                }
            }
        }
    }

    private fun clickOnMyEvents() {
        viewModelScope.launch {
            setEffect {
                if (viewState.value.mainScreenModel.isLoggedIn) {
                    MainContract.Effect.NavigateToMyEventsScreen
                } else {
                    MainContract.Effect.ShowLoginDialog
                }
            }
        }
    }

    private fun clickOnFilter() {
        viewModelScope.launch {
            setEffect {
                if (viewState.value.mainScreenModel.isLoggedIn) {
                    MainContract.Effect.NavigateToFilterScreen
                } else {
                    MainContract.Effect.ShowLoginDialog
                }
            }
        }
    }

    private fun clickOnHome() {
        viewModelScope.launch {
            setEffect {
                if (viewState.value.mainScreenModel.isLoggedIn) {
                    MainContract.Effect.NavigateToHomeScreen
                } else {
                    MainContract.Effect.ShowLoginDialog
                }
            }
        }
    }

    private fun logout() {
        viewModelScope.launch {
            runCatching {
                logoutUserUseCase.execute()
            }.onSuccess {
                setEffect {
                    MainContract.Effect.LogoutUser
                }
            }.onFailure {
                setEffect {
                    MainContract.Effect.ShowLoginDialog
                }
            }
        }
    }

    private fun clickOnScan() {
        viewModelScope.launch {
            setEffect {
                if (viewState.value.mainScreenModel.isLoggedIn) {
                    MainContract.Effect.NavigateToScanScreen
                } else {
                    MainContract.Effect.ShowLoginDialog
                }
            }
        }
    }

    private fun clickOnDialogButton() {
        viewModelScope.launch {
            setEffect {
                MainContract.Effect.NavigateToLoginScreen
            }
        }
    }
}