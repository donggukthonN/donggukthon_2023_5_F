package com.donggukthon.team5.data.service

import com.donggukthon.team5.data.model.request.RequestDummyDto
import com.donggukthon.team5.data.model.response.ResponseDummyDto
import retrofit2.http.Body
import retrofit2.http.POST

interface DummyService {
    @POST("api/dummy")
    suspend fun uploadDummy(@Body request: RequestDummyDto): ResponseDummyDto
}
