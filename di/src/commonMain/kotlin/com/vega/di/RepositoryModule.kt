package com.vega.di

import com.vega.data.auth.remote.login.LoginApiImpl
import com.vega.data.auth.remote.register.RegisterApiImpl
import com.vega.data.auth.repository.login.LoginRepositoryImpl
import com.vega.data.auth.repository.register.RegisterRepositoryImpl
import com.vega.data.auth.storage.SettingsStorageImpl
import com.vega.data.events.remote.UpcomingEventsApiImpl
import com.vega.data.events.repository.UpcomingEventsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        LoginRepositoryImpl(
            get<LoginApiImpl>(),
            get<SettingsStorageImpl>()
        )
    }
    single {
        RegisterRepositoryImpl(
            get<RegisterApiImpl>()
        )
    }
    single {
        UpcomingEventsRepositoryImpl(
            get<UpcomingEventsApiImpl>()
        )
    }
}