package com.vega.data.auth.repository.login

import com.vega.data.auth.model.LoginResponse
import com.vega.data.auth.remote.login.LoginApi
import com.vega.data.auth.storage.SettingsStorage
import com.vega.domain.model.login.LoginRequestBody
import com.vega.domain.repository.login.LoginRepository
import io.ktor.client.call.body

class LoginRepositoryImpl(
    private val loginApi: LoginApi,
    private val settingsStorage: SettingsStorage
): LoginRepository {
    override suspend fun isLoggedIn(): Boolean = settingsStorage.getToken().isNotEmpty()

    override suspend fun isLoggedInAnonymously(): Boolean = settingsStorage.getAnonymousUser()

    override suspend fun loginUser(credentials: LoginRequestBody) {
        runCatching {
            loginApi.login(credentials)
        }.mapCatching {
            it.body<LoginResponse>().token
        }.mapCatching {
            settingsStorage.saveToken(it)
        }.getOrThrow()
    }
}