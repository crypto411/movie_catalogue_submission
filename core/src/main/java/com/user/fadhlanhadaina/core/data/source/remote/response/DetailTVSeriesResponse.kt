package com.user.fadhlanhadaina.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailTVSeriesResponse(
    var id: Int,

    @SerializedName("poster_path")
    var posterPath: String,

    @SerializedName("name")
    var title: String,

    @SerializedName("first_air_date")
    var releaseDate: String,

    var genres: ArrayList<GenreResponse>,

    @SerializedName("episode_run_time")
    var durationArray: ArrayList<Int>,

    var overview: String
)
