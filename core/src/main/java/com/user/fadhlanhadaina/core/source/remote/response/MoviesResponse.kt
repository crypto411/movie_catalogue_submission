package com.user.fadhlanhadaina.core.source.remote.response

import com.google.gson.annotations.SerializedName
import com.user.fadhlanhadaina.core.model.Movie

data class MoviesResponse(
    @SerializedName("results")
    val movieLists: ArrayList<Movie>
)
