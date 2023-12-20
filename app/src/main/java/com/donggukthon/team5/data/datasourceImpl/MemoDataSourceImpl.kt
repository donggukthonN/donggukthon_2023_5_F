package com.donggukthon.team5.data.datasourceImpl

import com.donggukthon.team5.data.datasource.MemoDataSource
import com.donggukthon.team5.data.model.request.RequestMemoDto
import com.donggukthon.team5.data.model.response.ResponseMemoDto
import com.donggukthon.team5.data.service.MemoService
import javax.inject.Inject

class MemoDataSourceImpl @Inject constructor(
    private val memoService: MemoService
) : MemoDataSource {
    override suspend fun postMemo(requestMemoDto: RequestMemoDto): ResponseMemoDto =
        memoService.postMemo(requestMemoDto)
}