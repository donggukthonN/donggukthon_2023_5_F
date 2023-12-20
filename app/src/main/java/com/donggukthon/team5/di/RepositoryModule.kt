package com.donggukthon.team5.di

import com.donggukthon.team5.data.repository.DummyRepositoryImpl
import com.donggukthon.team5.data.repository.MemoRepositoryImpl
import com.donggukthon.team5.data.repository.TreeRepositoryImpl
import com.donggukthon.team5.domain.repository.DummyRepository
import com.donggukthon.team5.domain.repository.MemoRepository
import com.donggukthon.team5.domain.repository.TreeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Singleton
    @Binds
    fun bindDummyRepository(
        userRepositoryImpl: DummyRepositoryImpl
    ): DummyRepository

    @Singleton
    @Binds
    fun bindTreeRepository(
        treeRepositoryImpl: TreeRepositoryImpl
    ): TreeRepository

    @Singleton
    @Binds
    fun bindMemoRepository(
        memoRepositoryImpl: MemoRepositoryImpl
    ): MemoRepository
}
