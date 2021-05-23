package com.user.fadhlanhadaina.core.di

import com.user.fadhlanhadaina.core.BuildConfig
import com.user.fadhlanhadaina.core.data.source.remote.network.ApiResource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideClientAPI(): ApiResource =
        Retrofit.Builder()
            .baseUrl(BuildConfig.TMDB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiResource::class.java)
}