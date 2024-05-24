package com.vega.domain.usecase.login

import com.vega.domain.repository.login.LoginRepository

class LoginUserAnonymouslyUseCase (
    private val repository: LoginRepository
) {
    suspend fun execute() = repository.loginUserAnonymously()
}