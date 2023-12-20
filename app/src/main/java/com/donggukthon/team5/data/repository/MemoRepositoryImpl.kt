package com.donggukthon.team5.data.repository

import com.donggukthon.team5.data.datasource.MemoDataSource
import com.donggukthon.team5.data.model.request.RequestMemoDto
import com.donggukthon.team5.domain.repository.MemoRepository
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor(
    private val memoDataSource: MemoDataSource
) : MemoRepository {
    override suspend fun postMemo(treeId: Int, memoType: String, memo: String): Result<Int> =
        kotlin.runCatching {
            memoDataSource.postMemo(
                RequestMemoDto(
                    treeId = treeId,
                    memoType = memoType,
                    memo = memo
                )
            ).data.ornamentId
        }
}