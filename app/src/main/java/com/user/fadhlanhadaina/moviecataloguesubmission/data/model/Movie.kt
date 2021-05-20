package com.user.fadhlanhadaina.moviecataloguesubmission.data.model

import com.google.gson.annotations.SerializedName

data class Movie (
    var id: Int,

    @SerializedName("poster_path")
    var posterUrl: String,

    var title: String,

    @SerializedName("release_date")
    var date: String,

    var stringGenres: String,

    var genres: ArrayList<Genre>,

    @SerializedName("runtime")
    var duration: Int,

    var overview: String,
)
