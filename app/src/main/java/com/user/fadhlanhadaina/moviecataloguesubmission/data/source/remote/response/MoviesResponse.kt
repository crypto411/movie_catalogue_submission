package com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.Movie

data class MoviesResponse(
    @SerializedName("results")
    val movieLists: ArrayList<Movie>
)
