package com.vega.di

import com.vega.data.auth.repository.login.LoginRepositoryImpl
import com.vega.data.auth.storage.SettingsStorageImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        LoginRepositoryImpl(
            get<SettingsStorageImpl>()
        )
    }
}