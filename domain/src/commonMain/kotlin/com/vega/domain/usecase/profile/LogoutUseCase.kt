package com.vega.domain.usecase.profile

import com.vega.domain.repository.profile.ProfileRepository

class LogoutUseCase (
    private val repository: ProfileRepository
) {
    suspend fun execute() = repository.logout()
}