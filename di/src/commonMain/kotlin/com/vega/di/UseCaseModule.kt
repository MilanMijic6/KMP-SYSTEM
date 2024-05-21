package com.vega.di

import com.vega.data.auth.repository.login.LoginRepositoryImpl
import com.vega.domain.usecase.login.IsAnonymouslyLoggedInUserUseCase
import com.vega.domain.usecase.login.IsLoggedInUserUseCase
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
}