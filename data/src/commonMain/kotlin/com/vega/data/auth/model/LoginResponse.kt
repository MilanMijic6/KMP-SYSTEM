package com.vega.data.auth.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val token: String,
    val role: String
)