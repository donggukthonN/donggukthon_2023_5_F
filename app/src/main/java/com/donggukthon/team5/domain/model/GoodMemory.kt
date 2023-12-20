package com.donggukthon.team5.domain.model

import kotlinx.serialization.SerialName

data class GoodMemory (
    val ornamentId: Int = 0,
    val isGoodMemory: Boolean = false,
    val memory: String = ""
)