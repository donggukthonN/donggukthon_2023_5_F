package com.donggukthon.team5.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestMemoDto(
    @SerialName("treeId")
    val treeId: Int,
    @SerialName("memoType")
    val memoType: String,
    @SerialName("memo")
    val memo: String
)