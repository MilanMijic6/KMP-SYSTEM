package com.vega.di

import com.vega.data.auth.repository.login.LoginRepositoryImpl
import com.vega.data.auth.repository.register.RegisterRepositoryImpl
import com.vega.data.create_event.repository.CreateEventRepositoryImpl
import com.vega.data.event_details.repository.EventDetailsRepositoryImpl
import com.vega.data.events.repository.UpcomingEventsRepositoryImpl
import com.vega.data.my_events.repository.MyEventsRepositoryImpl
import com.vega.data.profile.repository.ProfileRepositoryImpl
import com.vega.data.update_event.repository.UpdateEventRepositoryImpl
import com.vega.domain.usecase.create_event.CreateEventUseCase
import com.vega.domain.usecase.event_details.DeleteEventUseCase
import com.vega.domain.usecase.event_details.GetEventDetailsUseCase
import com.vega.domain.usecase.event_details.ReserveEventDetailsUseCase
import com.vega.domain.usecase.events.GetUpcomingEventsUseCase
import com.vega.domain.usecase.login.IsAnonymouslyLoggedInUserUseCase
import com.vega.domain.usecase.login.IsLoggedInUserUseCase
import com.vega.domain.usecase.login.LoginUserAnonymouslyUseCase
import com.vega.domain.usecase.login.LoginUserUseCase
import com.vega.domain.usecase.my_events.GetMyEventsUseCase
import com.vega.domain.usecase.profile.GetUserUseCase
import com.vega.domain.usecase.profile.LogoutUseCase
import com.vega.domain.usecase.profile.UpdateUserUseCase
import com.vega.domain.usecase.register.RegisterUserUseCase
import com.vega.domain.usecase.update_event.UpdateEventUseCase
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
    single {
        GetUpcomingEventsUseCase(
            get<UpcomingEventsRepositoryImpl>()
        )
    }
    single {
        GetUserUseCase(
            get<ProfileRepositoryImpl>()
        )
    }
    single {
        GetEventDetailsUseCase(
            get<EventDetailsRepositoryImpl>()
        )
    }
    single {
        ReserveEventDetailsUseCase(
            get<EventDetailsRepositoryImpl>()
        )
    }
    single {
        LogoutUseCase(
            get<ProfileRepositoryImpl>()
        )
    }
    single {
        UpdateUserUseCase(
            get<ProfileRepositoryImpl>()
        )
    }
    single {
        DeleteEventUseCase(
            get<EventDetailsRepositoryImpl>()
        )
    }
    single {
        UpdateEventUseCase(
            get<UpdateEventRepositoryImpl>()
        )
    }
    single {
        GetMyEventsUseCase(
            get<MyEventsRepositoryImpl>()
        )
    }
    single {
        CreateEventUseCase(
            get<CreateEventRepositoryImpl>()
        )
    }
}