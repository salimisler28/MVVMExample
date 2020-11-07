package com.salimisler.mvvmexp.app.di

import com.salimisler.mvvmexp.app.data.remote.Service
import com.salimisler.mvvmexp.app.data.remote.ServiceDataSource
import com.salimisler.mvvmexp.app.repositories.ServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideServiceRepository(
        remoteDataSource: ServiceDataSource
    ): ServiceRepository = ServiceRepository(remoteDataSource)
}