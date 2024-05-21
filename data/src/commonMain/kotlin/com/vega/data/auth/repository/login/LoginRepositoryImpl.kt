package com.vega.data.auth.repository.login

import com.vega.data.auth.storage.SettingsStorage
import com.vega.domain.repository.login.LoginRepository

class LoginRepositoryImpl(
    private val settingsStorage: SettingsStorage
): LoginRepository {
    override suspend fun isLoggedIn(): Boolean = settingsStorage.getToken().isNotEmpty()

    override suspend fun isLoggedInAnonymously(): Boolean = settingsStorage.getAnonymousUser()

    override suspend fun loginUser() {

    }
}