package com.donggukthon.team5.domain.repository

import com.donggukthon.team5.domain.model.TreeOverview

interface TreeRepository {
    suspend fun getTreeOverView(treeId: Int): Result<TreeOverview>
}