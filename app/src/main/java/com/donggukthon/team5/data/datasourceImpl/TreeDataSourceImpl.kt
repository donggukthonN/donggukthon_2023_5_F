package com.donggukthon.team5.data.datasourceImpl

import com.donggukthon.team5.data.datasource.TreeDataSource
import com.donggukthon.team5.data.model.response.ResponseTreeOverviewDto
import com.donggukthon.team5.data.service.TreeService
import javax.inject.Inject

class TreeDataSourceImpl @Inject constructor(
    private val treeService: TreeService,
) : TreeDataSource {
    override suspend fun getTreeOverview(treeId: Int): ResponseTreeOverviewDto =
        treeService.getTreeOverview(treeId)

}