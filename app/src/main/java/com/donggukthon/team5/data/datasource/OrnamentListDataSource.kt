package com.donggukthon.team5.data.datasource

import com.donggukthon.team5.domain.model.OrnamentList

interface OrnamentListDataSource {

    suspend fun getOrnamentList(): OrnamentList
}