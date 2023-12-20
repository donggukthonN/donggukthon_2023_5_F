package com.donggukthon.team5.data.repository

import com.donggukthon.team5.data.model.request.RequestMemoDto
import com.donggukthon.team5.data.service.MemoService
import com.donggukthon.team5.domain.repository.MemoRepository
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor(
    private val memoService: MemoService
) : MemoRepository {
    override suspend fun postMemo(treeId: Int, memoType: String, memo: String): Result<Int> =
        kotlin.runCatching {
            memoService.postMemo(
                RequestMemoDto(
                    treeId = treeId,
                    memoType = memoType,
                    memo = memo
                )
            ).data.ornamentId
        }
}