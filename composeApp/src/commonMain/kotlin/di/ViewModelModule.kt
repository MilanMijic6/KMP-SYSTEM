package di

import auth.login.LoginViewModel
import auth.register.RegisterViewModel
import main.MainViewModel
import main.home.UpcomingEventsViewModel
import main.profile.ProfileViewModel
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
    factory {
        RegisterViewModel(
            registerUseCase = get(),
            loginUseCase = get(),
            loginUserAnonymouslyUseCase = get()
        )
    }
    factory {
        UpcomingEventsViewModel(
            getUpcomingEventsUseCase = get()
        )
    }
    factory {
        MainViewModel(
            isLoggedInUserUseCase = get(),
            logoutUserUseCase = get()
        )
    }
    factory {
        ProfileViewModel(
            getUserUseCase = get(),
            updateUserUseCase = get()
        )
    }
}