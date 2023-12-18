package com.donggukthon.team5.domain.repository

import com.donggukthon.team5.domain.model.DummyData

interface DummyRepository {
    suspend fun uploadDummy(name: String, email: String): Result<DummyData>
}
