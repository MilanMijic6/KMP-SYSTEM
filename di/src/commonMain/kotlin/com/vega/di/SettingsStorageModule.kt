package com.vega.di

import com.russhwolf.settings.Settings
import com.vega.data.auth.storage.SettingsStorageImpl
import org.koin.dsl.module

val settingsStorageModule = module {
    single {
        Settings()
    }
    single {
        SettingsStorageImpl(get())
    }
}