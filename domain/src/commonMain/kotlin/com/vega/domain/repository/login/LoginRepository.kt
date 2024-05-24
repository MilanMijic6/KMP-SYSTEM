package com.vega.domain.repository.login

import com.vega.domain.model.login.LoginRequestBody

interface LoginRepository {
    suspend fun isLoggedIn(): Boolean

    suspend fun isLoggedInAnonymously(): Boolean

    suspend fun loginUser(credentials: LoginRequestBody)

    suspend fun loginUserAnonymously()
}