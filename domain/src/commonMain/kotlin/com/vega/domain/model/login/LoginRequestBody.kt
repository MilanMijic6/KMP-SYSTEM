package com.vega.domain.model.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestBody(
    @SerialName("Email") val email: String,
    @SerialName("Password") val password: String
)