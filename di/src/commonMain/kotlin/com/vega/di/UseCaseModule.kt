package com.vega.di

import com.vega.data.auth.repository.login.LoginRepositoryImpl
import com.vega.data.auth.repository.register.RegisterRepositoryImpl
import com.vega.domain.usecase.login.IsAnonymouslyLoggedInUserUseCase
import com.vega.domain.usecase.login.IsLoggedInUserUseCase
import com.vega.domain.usecase.login.LoginUserAnonymouslyUseCase
import com.vega.domain.usecase.login.LoginUserUseCase
import com.vega.domain.usecase.register.RegisterUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        IsLoggedInUserUseCase(
            get<LoginRepositoryImpl>()
        )
    }
    single {
        IsAnonymouslyLoggedInUserUseCase(
            get<LoginRepositoryImpl>()
        )
    }
    single {
        LoginUserUseCase(
            get<LoginRepositoryImpl>()
        )
    }
    single {
        LoginUserAnonymouslyUseCase(
            get<LoginRepositoryImpl>()
        )
    }
    single {
        RegisterUserUseCase(
            get<RegisterRepositoryImpl>()
        )
    }
}