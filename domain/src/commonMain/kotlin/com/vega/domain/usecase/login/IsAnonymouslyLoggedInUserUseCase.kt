package com.vega.domain.usecase.login

import com.vega.domain.repository.login.LoginRepository

class IsAnonymouslyLoggedInUserUseCase(
    private val loginRepository: LoginRepository
) {

    suspend fun execute() = loginRepository.isLoggedInAnonymously()
}