package com.donggukthon.team5.di

import com.donggukthon.team5.data.service.DummyService
import com.donggukthon.team5.data.service.OrnamentListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
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
    fun provideOrnamentListService(retrofit: Retrofit): OrnamentListService =
        retrofit.create(OrnamentListService::class.java)
}
