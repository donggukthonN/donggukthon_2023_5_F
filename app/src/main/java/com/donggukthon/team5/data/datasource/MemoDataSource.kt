package com.donggukthon.team5.data.datasource

import com.donggukthon.team5.data.model.request.RequestMemoDto
import com.donggukthon.team5.data.model.response.ResponseMemoDto

interface MemoDataSource {
    suspend fun postMemo(requestMemoDto: RequestMemoDto): ResponseMemoDto
}