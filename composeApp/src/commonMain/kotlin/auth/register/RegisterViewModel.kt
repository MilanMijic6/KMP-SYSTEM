package auth.register

import BaseViewModel
import com.vega.domain.model.login.LoginRequestBody
import com.vega.domain.model.register.RegisterRequestBody
import com.vega.domain.usecase.login.LoginUserAnonymouslyUseCase
import com.vega.domain.usecase.login.LoginUserUseCase
import com.vega.domain.usecase.register.RegisterUserUseCase
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUserUseCase,
    private val loginUseCase: LoginUserUseCase,
    private val loginUserAnonymouslyUseCase: LoginUserAnonymouslyUseCase
) : BaseViewModel<RegisterContract.Event, RegisterContract.State, RegisterContract.Effect>() {

    override fun setInitialState(): RegisterContract.State = RegisterContract.State.Init()

    override fun handleEvents(event: RegisterContract.Event) {
        when (event) {
            is RegisterContract.Event.EmailEnterEvent -> event.updateEmailInput()
            is RegisterContract.Event.PasswordEnterEvent -> event.updatePasswordInput()
            is RegisterContract.Event.NameEnterEvent -> event.updateNameInput()
            is RegisterContract.Event.RoleEnterEvent -> event.updateRole()
            is RegisterContract.Event.LoginScreenEvent -> navigateToLoginScreen()
            is RegisterContract.Event.RegisterUserEvent -> registerUser()
            is RegisterContract.Event.LoginAnonymouslyEvent -> loginUserAnonymously()
        }
    }

    private fun loginUserAnonymously() {
        viewModelScope.launch {
            runCatching {
                loginUserAnonymouslyUseCase.execute()
            }.onSuccess {
                setEffect {
                    RegisterContract.Effect.NavigateToMainScreen
                }
            }
        }
    }

    private fun navigateToLoginScreen() {
        viewModelScope.launch {
            setEffect {
                RegisterContract.Effect.NavigateToLoginScreen
            }
        }
    }

    private fun RegisterContract.Event.EmailEnterEvent.updateEmailInput() {
        viewModelScope.launch {
            setState {
                RegisterContract.State.Init(viewState.value.registerScreenModel.copy(email = emailAddress))
            }
        }
    }

    private fun RegisterContract.Event.PasswordEnterEvent.updatePasswordInput() {
        viewModelScope.launch {
            setState {
                RegisterContract.State.Init(viewState.value.registerScreenModel.copy(password = password))
            }
        }
    }

    private fun RegisterContract.Event.NameEnterEvent.updateNameInput() {
        viewModelScope.launch {
            setState {
                RegisterContract.State.Init(viewState.value.registerScreenModel.copy(name = name))
            }
        }
    }

    private fun RegisterContract.Event.RoleEnterEvent.updateRole() {
        viewModelScope.launch {
            setState {
                RegisterContract.State.Init(viewState.value.registerScreenModel.copy(role = role))
            }
        }
    }

    private fun registerUser() {
        viewModelScope.launch {
            runCatching {
                with(viewState.value.registerScreenModel) {
                    RegisterRequestBody(
                        email = email,
                        password = password,
                        name = name,
                        role = role
                    )
                }
            }.mapCatching {
                registerUseCase.execute(it)
            }.onSuccess {
                runCatching {
                    with(viewState.value.registerScreenModel) {
                        LoginRequestBody(
                            email = email,
                            password = password
                        )
                    }
                }.mapCatching {
                    loginUseCase.execute(it)
                }.onSuccess {
                    setEffect {
                        RegisterContract.Effect.NavigateToMainScreen
                    }
                }.onFailure {
                    setState {
                        RegisterContract.State.Error(
                            viewState.value.registerScreenModel.copy(
                                errorMsg = "Error with loading"
                            )
                        )
                    }
                }
            }.onFailure {
                setState {
                    RegisterContract.State.Error(viewState.value.registerScreenModel.copy(errorMsg = it.message.toString()))
                }
            }
        }
    }
}