package com.donggukthon.team5.domain.model

data class OrnamentList (
    val data: List<OrnamentListData>
) {
    data class OrnamentListData(
        val ornamentId: Int = 0,
        val isGoodMemory: Boolean = false,
        val memory: String = ""
    )
}