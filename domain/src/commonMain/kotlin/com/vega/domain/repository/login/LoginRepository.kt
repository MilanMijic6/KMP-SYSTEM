package com.vega.domain.repository.login

interface LoginRepository {
    suspend fun isLoggedIn(): Boolean

    suspend fun isLoggedInAnonymously(): Boolean

    suspend fun loginUser(/*credentials: LoginRequestBody*/)
}