package com.vega.data.auth.storage

import com.russhwolf.settings.Settings
import com.vega.data.Constants.KEY_ANONYMOUS_TOKEN
import com.vega.data.Constants.KEY_TOKEN

class SettingsStorageImpl(
    private var settings: Settings
) : SettingsStorage {
    override fun saveAnonymousUser(anonymous: Boolean) = settings.putBoolean(KEY_ANONYMOUS_TOKEN, anonymous)

    override fun getAnonymousUser(): Boolean = settings.getBoolean(KEY_ANONYMOUS_TOKEN, false)
    override fun clearAnonymousUser() = settings.remove(KEY_ANONYMOUS_TOKEN)

    override fun saveToken(token: String) = settings.putString(KEY_TOKEN, token)

    override fun getToken(): String = settings.getString(KEY_TOKEN, "")

    override fun removeToken() = settings.remove(KEY_TOKEN)

}