package com.donggukthon.team5.di

import com.donggukthon.team5.data.service.DummyService
import com.donggukthon.team5.data.service.MemoService
import com.donggukthon.team5.data.service.TreeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Singleton
    @Provides
    fun provideDummyService(retrofit: Retrofit): DummyService =
        retrofit.create(DummyService::class.java)

    @Singleton
    @Provides
    fun provideTreeService(retrofit: Retrofit): TreeService =
        retrofit.create(TreeService::class.java)

    @Singleton
    @Provides
    fun provideMemoService(retrofit: Retrofit): MemoService =
        retrofit.create(MemoService::class.java)
}
