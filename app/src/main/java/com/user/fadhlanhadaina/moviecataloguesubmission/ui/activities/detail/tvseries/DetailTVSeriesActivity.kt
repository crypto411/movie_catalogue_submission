package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.user.fadhlanhadaina.moviecataloguesubmission.R
import com.user.fadhlanhadaina.core.domain.model.TVSeriesFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.ActivityDetailBinding
import com.user.fadhlanhadaina.core.util.ExtFun.load
import com.user.fadhlanhadaina.core.util.ExtFun.show
import com.user.fadhlanhadaina.moviecataloguesubmission.viewmodel.ViewModelFactory

class DetailTVSeriesActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "tv_series_id"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailTVSeriesViewModel: DetailTVSeriesViewModel
    private var favorited: Boolean = false
    private var tvSeriesFavorite: TVSeriesFavorite? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActivity()
        initViewModel()
        showDetails()
    }

    private fun initActivity() {
        supportActionBar?.title = "TV Series Detail"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViewModel() {
        val factory = ViewModelFactory.newInstance(application)
        detailTVSeriesViewModel = ViewModelProvider(this, factory).get(DetailTVSeriesViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    fun showDetails() {
        binding.progressBar.show(true)
        val id = intent.getIntExtra(EXTRA_ID, 0)
        val tvSeries = detailTVSeriesViewModel.getTVSeries(id)
        tvSeries?.observe(this) { it ->
            binding.progressBar.show(false)
            binding.ivMovieDetail.load(it.posterUrl)

            val splittedDate = it.releaseDate.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> it.releaseDate.split("-")[0]
            }
            binding.tvTitleDetail.text = "${it.title} ($year)"
            val duration = if(it.duration > 0) it.duration else "-"
            binding.tvDurationDetail.text = "$duration minute(s)"
            binding.tvOverviewDetail.text = it.overview
            binding.tvGenreDetail.text = "Genre: ${it.genres}"

            tvSeriesFavorite = TVSeriesFavorite(it.id, it.posterUrl, it.title, it.releaseDate, it.genres)
            binding.btnFavorite.isEnabled = true
            binding.btnFavorite.setOnClickListener {
                favorited = when(favorited) {
                    true -> false
                    else -> true
                }
                setFavorite(favorited)
            }
        }
        if(detailTVSeriesViewModel.isFavoriteTVSeries(id)) {
            favorited = true
            binding.btnFavorite.toggle(favorited)
        }
    }

    private fun FloatingActionButton.toggle(state: Boolean) {
        if(state)
            this.setImageResource(R.drawable.ic_baseline_favorite_24_red)
        else
            this.setImageResource(R.drawable.ic_baseline_favorite_border_24)
    }

    @SuppressLint("ShowToast")
    private fun setFavorite(boolean: Boolean) {
        if(tvSeriesFavorite != null) {
            if (boolean) {
                detailTVSeriesViewModel.insertFavoriteTVSeries(tvSeriesFavorite!!)
                Toast.makeText(this, "Added to favorite!", Toast.LENGTH_SHORT).show()
            }
            else {
                detailTVSeriesViewModel.deleteFavoriteTVSeries(tvSeriesFavorite!!)
                Toast.makeText(this, "Removed to favorite!", Toast.LENGTH_SHORT).show()
            }

            binding.btnFavorite.toggle(boolean)
        }
        Log.d("boolFavorite tvseries", boolean.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}