package com.vega.di

import com.vega.data.api.ApiClientImpl
import com.vega.data.auth.remote.login.LoginApiImpl
import com.vega.data.auth.remote.register.RegisterApiImpl
import com.vega.data.create_event.remote.CreateEventApiImpl
import com.vega.data.event_details.remote.EventDetailsApiIMpl
import com.vega.data.events.remote.UpcomingEventsApiImpl
import com.vega.data.my_events.remote.MyEventsApiImpl
import com.vega.data.profile.remote.ProfileApiImpl
import com.vega.data.update_event.remote.UpdateEventApiImpl
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
    single {
        EventDetailsApiIMpl(get())
    }
    single {
        UpdateEventApiImpl(get())
    }
    single {
        MyEventsApiImpl(get())
    }
    single {
        CreateEventApiImpl(get())
    }
}