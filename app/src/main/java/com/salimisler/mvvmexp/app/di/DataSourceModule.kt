package com.salimisler.mvvmexp.app.di

import com.salimisler.mvvmexp.app.data.remote.Service
import com.salimisler.mvvmexp.app.data.remote.ServiceDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideServiceDataSource(service: Service) = ServiceDataSource(service)
}