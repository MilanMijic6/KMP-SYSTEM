package com.vega.domain.usecase.login

import com.vega.domain.repository.login.LoginRepository

class IsLoggedInUserUseCase(
    private val loginRepository: LoginRepository
) {

    suspend fun execute() = loginRepository.isLoggedIn()
}