package com.donggukthon.team5.data.repository

import android.util.Log
import com.donggukthon.team5.data.datasource.OrnamentListDataSource
import com.donggukthon.team5.domain.model.OrnamentList
import com.donggukthon.team5.domain.repository.OrnamentListRepository
import javax.inject.Inject

class OrnamentListRepositoryImpl @Inject constructor(
    private val ornamentListDataSource: OrnamentListDataSource
): OrnamentListRepository {

    override suspend fun getOrnamentList()
    : Result<OrnamentList> = runCatching {
        ornamentListDataSource.getOrnamentList()
    }.fold(
        onSuccess = {
            Result.success(ornamentListDataSource.getOrnamentList())
        },
        onFailure = {
            Result.failure(it)
        }
    )

}