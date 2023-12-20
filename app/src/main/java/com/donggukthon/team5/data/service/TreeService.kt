package com.donggukthon.team5.data.service

import com.donggukthon.team5.data.model.response.ResponseTreeOverviewDto
import retrofit2.http.GET
import retrofit2.http.Path

interface TreeService {
    @GET("tree/overview/{treeId}")
    suspend fun getTreeOverview(
        @Path("treeId") treeId: Int = 1
    ): ResponseTreeOverviewDto
}