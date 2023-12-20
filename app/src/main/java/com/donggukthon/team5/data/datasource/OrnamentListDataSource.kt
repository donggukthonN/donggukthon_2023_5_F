package com.donggukthon.team5.data.datasource

import com.donggukthon.team5.data.service.OrnamentListService
import com.donggukthon.team5.domain.model.OrnamentList
import javax.inject.Inject

class OrnamentListDataSource @Inject constructor(
    private val ornamentListService: OrnamentListService
) {

    suspend fun getOrnamentList(): OrnamentList =
        OrnamentList(ornamentListService.getOrnamentList().getOrnamentList())
}