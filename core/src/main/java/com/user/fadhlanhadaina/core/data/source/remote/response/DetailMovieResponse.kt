package com.user.fadhlanhadaina.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailMovieResponse(
    val id: Int,

    @SerializedName("poster_path")
    val posterPath: String,

    var title: String,

    @SerializedName("release_date")
    var releaseDate: String,

    var genres: ArrayList<GenreResponse>,

    @SerializedName("runtime")
    var duration: Int,

    var overview: String,
)
