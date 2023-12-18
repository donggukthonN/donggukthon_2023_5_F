package com.donggukthon.team5.data.repository

import com.donggukthon.team5.data.datasource.DummyDataSource
import com.donggukthon.team5.data.model.request.RequestDummyDto
import com.donggukthon.team5.domain.model.DummyData
import com.donggukthon.team5.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyDataSource: DummyDataSource,
) : DummyRepository {
    override suspend fun uploadDummy(name: String, email: String): Result<DummyData> =
        runCatching {
            dummyDataSource.uploadDummy(RequestDummyDto(name, email)).data.toDummyData()
        }
}
