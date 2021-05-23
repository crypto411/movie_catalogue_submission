package com.user.fadhlanhadaina.core.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.user.fadhlanhadaina.core.BuildConfig
import com.user.fadhlanhadaina.core.R

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

    fun FloatingActionButton.toggle(state: Boolean) {
        if(state)
            this.setImageResource(R.drawable.ic_baseline_favorite_24_red)
        else
            this.setImageResource(R.drawable.ic_baseline_favorite_border_24)
    }
}