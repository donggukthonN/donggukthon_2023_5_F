package com.donggukthon.team5.data.datasource

import com.donggukthon.team5.data.model.request.RequestDummyDto
import com.donggukthon.team5.data.model.response.ResponseDummyDto
import com.donggukthon.team5.data.service.DummyService
import javax.inject.Inject

class DummyDataSource @Inject constructor(
    private val dummyService: DummyService,
) {
    suspend fun uploadDummy(requestDummy: RequestDummyDto): ResponseDummyDto =
        dummyService.uploadDummy(requestDummy)
}
