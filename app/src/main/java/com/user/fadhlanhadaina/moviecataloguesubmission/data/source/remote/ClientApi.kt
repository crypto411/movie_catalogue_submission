package com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote

import com.user.fadhlanhadaina.moviecataloguesubmission.BuildConfig
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