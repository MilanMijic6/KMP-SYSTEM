package di

import org.koin.dsl.module
import splash.SplashViewModel

val viewModelModule = module {
    factory {
        SplashViewModel(
            isLoggedInUserUseCase = get(),
            isAnonymouslyLoggedInUserUseCase = get()
        )
    }
}