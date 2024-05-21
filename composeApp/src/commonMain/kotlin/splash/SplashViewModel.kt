package splash

import BaseViewModel
import com.vega.domain.usecase.login.IsAnonymouslyLoggedInUserUseCase
import com.vega.domain.usecase.login.IsLoggedInUserUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(
    private val isLoggedInUserUseCase: IsLoggedInUserUseCase,
    private val isAnonymouslyLoggedInUserUseCase: IsAnonymouslyLoggedInUserUseCase
) : BaseViewModel<SplashContract.Event, SplashContract.State, SplashContract.Effect>() {

    init {
        isUserLoggedIn()
    }

    override fun setInitialState(): SplashContract.State = SplashContract.State()

    override fun handleEvents(event: SplashContract.Event) {
        //for this case there is no event
    }

    private fun isUserLoggedIn() {
        viewModelScope.launch {
            runCatching {
                delay(800L)
                isLoggedInUserUseCase.execute() || isAnonymouslyLoggedInUserUseCase.execute()
            }.onSuccess {
                when (it) {
                    true -> {
                        setEffect {
                            SplashContract.Effect.NavigateToMainScreen
                        }
                    }
                    false -> {
                        setEffect {
                            SplashContract.Effect.NavigateToRegisterScreen
                        }
                    }
                }
            }
        }
    }
}