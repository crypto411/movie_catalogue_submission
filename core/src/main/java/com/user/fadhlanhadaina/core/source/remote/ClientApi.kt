package com.user.fadhlanhadaina.core.source.remote

import com.user.fadhlanhadaina.core.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientApi {
    private const val baseUrl = BuildConfig.TMDB_API_BASE_URL

    private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val client: ApiResource = retrofit.create(ApiResource::class.java)
}