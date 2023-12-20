package com.donggukthon.team5.data.service

import com.donggukthon.team5.data.model.request.RequestMemoDto
import com.donggukthon.team5.data.model.response.ResponseMemoDto
import retrofit2.http.Body
import retrofit2.http.POST

interface MemoService {
    @POST("tree/memo")
    suspend fun postMemo(
        @Body requestMemoDto: RequestMemoDto
    ): ResponseMemoDto
}