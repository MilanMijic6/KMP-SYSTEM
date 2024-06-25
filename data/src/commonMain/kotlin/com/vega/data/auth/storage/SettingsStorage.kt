package com.vega.data.auth.storage

interface SettingsStorage {
    fun saveAnonymousUser(anonymous: Boolean)
    fun clearAnonymousUser()
    fun getAnonymousUser(): Boolean
    fun saveToken(token: String)
    fun getToken(): String
    fun removeToken()
    fun saveRole(role: String)
    fun getRole(): String
    fun removeRole()
}