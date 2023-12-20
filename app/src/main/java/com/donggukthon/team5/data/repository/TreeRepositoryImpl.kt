package com.donggukthon.team5.data.repository

import com.donggukthon.team5.data.datasource.TreeDataSource
import com.donggukthon.team5.domain.model.TreeOverview
import com.donggukthon.team5.domain.repository.TreeRepository
import javax.inject.Inject

class TreeRepositoryImpl @Inject constructor(
    private val treeDataSource: TreeDataSource,
) : TreeRepository {
    override suspend fun getTreeOverView(treeId: Int): Result<TreeOverview> =
        kotlin.runCatching { treeDataSource.getTreeOverview(treeId).toTreeOverview() }

}