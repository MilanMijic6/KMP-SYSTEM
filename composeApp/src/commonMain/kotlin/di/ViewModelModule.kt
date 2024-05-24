package di

import auth.login.LoginViewModel
import org.koin.dsl.module
import splash.SplashViewModel

val viewModelModule = module {
    factory {
        SplashViewModel(
            isLoggedInUserUseCase = get(),
            isAnonymouslyLoggedInUserUseCase = get()
        )
    }
    factory {
        LoginViewModel(
            loginUseCase = get(),
            loginUserAnonymouslyUseCase = get()
        )
    }
}