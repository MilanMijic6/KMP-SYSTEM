package com.vega.di

import com.vega.data.api.ApiClientImpl
import org.koin.dsl.module

val apiModule = module {
    single {
        ApiClientImpl(get())
    }
}