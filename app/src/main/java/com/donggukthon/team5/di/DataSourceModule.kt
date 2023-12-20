package com.donggukthon.team5.di

import com.donggukthon.team5.data.datasource.MemoDataSource
import com.donggukthon.team5.data.datasource.TreeDataSource
import com.donggukthon.team5.data.datasourceImpl.MemoDataSourceImpl
import com.donggukthon.team5.data.datasourceImpl.TreeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindTreeDataSource(treeDataSourceImpl: TreeDataSourceImpl): TreeDataSource

    @Singleton
    @Binds
    abstract fun bindMemoDataSource(memoDataSourceImpl: MemoDataSourceImpl): MemoDataSource
}