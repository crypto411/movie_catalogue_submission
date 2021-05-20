package com.user.fadhlanhadaina.moviecataloguesubmission.data.model

import com.google.gson.annotations.SerializedName

data class TVSeries(
        var id: Int,

        @SerializedName("poster_path")
        var posterUrl: String,

        @SerializedName("name")
        var title: String,

        @SerializedName("first_air_date")
        var date: String,

        var stringGenres: String,

        var genres: ArrayList<Genre>,

        @SerializedName("episode_run_time")
        var durationArray: ArrayList<Int>,

        var duration: Int,

        var overview: String
)
