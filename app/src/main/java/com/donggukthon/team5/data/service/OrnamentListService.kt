package com.donggukthon.team5.data.service

import com.donggukthon.team5.data.model.response.ResponseOrnamentList
import retrofit2.http.GET
import retrofit2.http.Query

interface OrnamentListService {

    @GET("/ornament/getlist/1")
    suspend fun getOrnamentList(
    ): ResponseOrnamentList
}