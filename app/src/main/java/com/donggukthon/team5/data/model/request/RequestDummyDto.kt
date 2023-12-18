package com.donggukthon.team5.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestDummyDto(
    val name: String,
    val email: String,
)
