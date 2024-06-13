package com.vega.domain.model.profile

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserRequestBody(
    val name: String,
    val email: String,
    val profilePicture: String
)