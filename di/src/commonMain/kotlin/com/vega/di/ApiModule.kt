package com.vega.di

import com.vega.data.api.ApiClientImpl
import com.vega.data.auth.remote.login.LoginApiImpl
import com.vega.data.auth.remote.register.RegisterApiImpl
import com.vega.data.events.remote.UpcomingEventsApiImpl
import com.vega.data.profile.remote.ProfileApiImpl
import org.koin.dsl.module

val apiModule = module {
    single {
        ApiClientImpl(get())
    }
    single {
        LoginApiImpl(get())
    }
    single {
        RegisterApiImpl(get())
    }
    single {
        UpcomingEventsApiImpl(get())
    }
    single {
        ProfileApiImpl(get())
    }
}