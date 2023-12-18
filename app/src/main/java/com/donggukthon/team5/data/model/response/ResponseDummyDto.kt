package com.donggukthon.team5.data.model.response

import com.donggukthon.team5.domain.model.DummyData
import kotlinx.serialization.Serializable

data class ResponseDummyDto(
    val status: Int,
    val message: String,
    val data: ResponseData,
) {
    @Serializable
    data class ResponseData(
        val id: Int,
        val name: String,
        val email: String,
    ) {
        fun toDummyData() = DummyData(
            id = id.toString(),
            email = email,
            name = name
        )
    }
}
