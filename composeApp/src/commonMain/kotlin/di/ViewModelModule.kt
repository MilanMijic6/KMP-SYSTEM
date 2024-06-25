package di

import auth.login.LoginViewModel
import auth.register.RegisterViewModel
import main.MainViewModel
import main.eventdetails.EventDetailsViewModel
import main.home.UpcomingEventsViewModel
import main.myevents.MyEventsViewModel
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
            getUpcomingEventsUseCase = get(),
            isLoggedInUserUseCase = get()
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
    factory {
        EventDetailsViewModel(
            getEventDetailsUseCase = get(),
            reserveEventDetailsUseCase = get(),
            deleteEventUseCase = get(),
            isUserCreatorUserCase = get()
        )
    }
    factory {
        MyEventsViewModel(
            getMyEventsUseCase = get()
        )
    }
}