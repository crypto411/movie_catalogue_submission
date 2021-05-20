package com.user.fadhlanhadaina.moviecataloguesubmission.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeries

data class TVSeriesResponse(
        @SerializedName("results")
        val tvSerieLists: ArrayList<TVSeries>
)
