package com.user.fadhlanhadaina.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("results")
    val results: ArrayList<DetailMovieResponse>
)
