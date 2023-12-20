package com.donggukthon.team5.data.datasource

import com.donggukthon.team5.data.model.response.ResponseTreeOverviewDto

interface TreeDataSource {
    suspend fun getTreeOverview(treeId: Int): ResponseTreeOverviewDto
}