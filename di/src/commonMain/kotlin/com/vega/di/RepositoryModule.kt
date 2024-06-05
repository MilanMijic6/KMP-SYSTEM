package com.vega.di

import com.vega.data.auth.remote.login.LoginApiImpl
import com.vega.data.auth.remote.register.RegisterApiImpl
import com.vega.data.auth.repository.login.LoginRepositoryImpl
import com.vega.data.auth.repository.register.RegisterRepositoryImpl
import com.vega.data.auth.storage.SettingsStorageImpl
import com.vega.data.create_event.remote.CreateEventApiImpl
import com.vega.data.create_event.repository.CreateEventRepositoryImpl
import com.vega.data.event_details.remote.EventDetailsApiIMpl
import com.vega.data.event_details.repository.EventDetailsRepositoryImpl
import com.vega.data.events.remote.UpcomingEventsApiImpl
import com.vega.data.events.repository.UpcomingEventsRepositoryImpl
import com.vega.data.my_events.remote.MyEventsApiImpl
import com.vega.data.my_events.repository.MyEventsRepositoryImpl
import com.vega.data.profile.remote.ProfileApiImpl
import com.vega.data.profile.repository.ProfileRepositoryImpl
import com.vega.data.update_event.remote.UpdateEventApiImpl
import com.vega.data.update_event.repository.UpdateEventRepositoryImpl
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
    single {
        ProfileRepositoryImpl(
            get<ProfileApiImpl>(),
            get<SettingsStorageImpl>()
        )
    }
    single {
        EventDetailsRepositoryImpl(
            get<EventDetailsApiIMpl>(),
            get<SettingsStorageImpl>()
        )
    }
    single {
        UpdateEventRepositoryImpl(
            get<UpdateEventApiImpl>(),
            get<SettingsStorageImpl>()
        )
    }
    single {
        MyEventsRepositoryImpl(
            get<MyEventsApiImpl>(),
            get<SettingsStorageImpl>()
        )
    }
    single {
        CreateEventRepositoryImpl(
            get<CreateEventApiImpl>(),
            get<SettingsStorageImpl>()
        )
    }
}