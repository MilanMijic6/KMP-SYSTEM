package com.vega.domain.repository.register

import com.vega.domain.model.register.RegisterRequestBody

interface RegisterRepository {

    suspend fun registerUser(userBody: RegisterRequestBody)
}