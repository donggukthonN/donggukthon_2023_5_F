package com.donggukthon.team5.domain.repository

interface MemoRepository {
    suspend fun postMemo(
        treeId: Int,
        memoType: String,
        memo: String
    ): Result<Int>
}