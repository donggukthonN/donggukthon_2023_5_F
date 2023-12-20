package com.donggukthon.team5.data.model.response

import com.donggukthon.team5.domain.model.OrnamentList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseOrnamentList (
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Data>
) {
    @Serializable
    data class Data(
        @SerialName("ornamentId")
        val ornamentId: Int,
        @SerialName("isGoodMemory")
        val isGoodMemory: Boolean,
        @SerialName("memory")
        val memory: String
    )

    fun getOrnamentList() = data.map { data ->
        OrnamentList(
            ornamentId = data.ornamentId,
            isGoodMemory = data.isGoodMemory,
            memory = data.memory
        )
    }
}