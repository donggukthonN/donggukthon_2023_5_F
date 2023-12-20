package com.donggukthon.team5.domain.repository

import com.donggukthon.team5.domain.model.OrnamentList

interface OrnamentListRepository {

    suspend fun getOrnamentList(): Result<OrnamentList>
}