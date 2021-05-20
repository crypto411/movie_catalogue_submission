package com.user.fadhlanhadaina.moviecataloguesubmission.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.user.fadhlanhadaina.moviecataloguesubmission.BuildConfig
import com.user.fadhlanhadaina.moviecataloguesubmission.R

object ExtFun {
    fun ImageView.load(url: String) {
        Glide.with(this.context)
            .load(BuildConfig.TMDB_API_IMG_BASE_URL + url)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_error_24))
            .into(this)
    }

    fun ProgressBar.show(boolean: Boolean) {
        if(boolean)
            this.visibility = View.VISIBLE
        else
            this.visibility = View.INVISIBLE
    }
}