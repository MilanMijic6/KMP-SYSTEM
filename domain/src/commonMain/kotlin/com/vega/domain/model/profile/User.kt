package com.vega.domain.model.profile

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String,
    val name: String,
    val profilePicture: String?
)