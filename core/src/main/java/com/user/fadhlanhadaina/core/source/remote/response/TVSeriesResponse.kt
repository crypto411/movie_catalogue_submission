package com.user.fadhlanhadaina.core.source.remote.response

import com.google.gson.annotations.SerializedName
import com.user.fadhlanhadaina.core.model.TVSeries

data class TVSeriesResponse(
        @SerializedName("results")
        val tvSerieLists: ArrayList<TVSeries>
)
