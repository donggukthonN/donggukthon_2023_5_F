package com.donggukthon.team5.data.model.response

import com.donggukthon.team5.domain.model.TreeOverview
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTreeOverviewDto(
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName("treeId")
        val treeId: Int,
        @SerialName("ornamentOverviewList")
        val ornamentOverviewList: List<Boolean>
    )

    fun toTreeOverview() = TreeOverview(
        treeId = this.data.treeId,
        ornamentOverviewList = this.data.ornamentOverviewList
    )
}