package auth.login

import BaseViewModel
import com.vega.domain.model.login.LoginRequestBody
import com.vega.domain.usecase.login.LoginUserAnonymouslyUseCase
import com.vega.domain.usecase.login.LoginUserUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUserUseCase,
    private val loginUserAnonymouslyUseCase: LoginUserAnonymouslyUseCase
) : BaseViewModel<LoginContract.Event, LoginContract.State, LoginContract.Effect>() {

    override fun setInitialState(): LoginContract.State = LoginContract.State.Init()

    override fun handleEvents(event: LoginContract.Event) {
        when (event) {
            is LoginContract.Event.EmailEnterEvent -> event.updateEmailInput()
            LoginContract.Event.LoginUserEvent -> loginUser()
            is LoginContract.Event.PasswordEnterEvent -> event.updatePasswordInput()
            LoginContract.Event.LoginAnonymouslyEvent -> loginUserAnonymously()
        }
    }

    private fun LoginContract.Event.EmailEnterEvent.updateEmailInput() {
        viewModelScope.launch {
            setState {
                LoginContract.State.Init(viewState.value.loginScreenModel.copy(email = emailAddress))
            }
        }
    }

    private fun LoginContract.Event.PasswordEnterEvent.updatePasswordInput() {
        viewModelScope.launch {
            setState {
                LoginContract.State.Init(viewState.value.loginScreenModel.copy(password = password))
            }
        }
    }

    private fun loginUserAnonymously() {
        viewModelScope.launch {
            runCatching {
                loginUserAnonymouslyUseCase.execute()
            }.onSuccess {
                setEffect {
                    LoginContract.Effect.NavigateToMainScreen
                }
            }
        }
    }

    private fun loginUser() {
        viewModelScope.launch {
            runCatching {
                with(viewState.value.loginScreenModel) {
                    LoginRequestBody(
                        email = email,
                        password = password
                    )
                }
            }.mapCatching {
                loginUseCase.execute(it)
            }.onSuccess {
                setEffect {
                    LoginContract.Effect.NavigateToMainScreen
                }
            }.onFailure {
                setState {
                    LoginContract.State.Error(
                        viewState.value.loginScreenModel.copy(
                            errorMsg = it.message.toString()
                        )
                    )
                }
            }
        }
    }
}