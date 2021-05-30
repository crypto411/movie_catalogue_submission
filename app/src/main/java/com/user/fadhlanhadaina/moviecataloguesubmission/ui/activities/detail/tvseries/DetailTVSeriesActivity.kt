package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.ActivityDetailBinding
import com.user.fadhlanhadaina.core.util.ExtFun.load
import com.user.fadhlanhadaina.core.util.ExtFun.show
import com.user.fadhlanhadaina.core.util.ExtFun.toggle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailTVSeriesActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "tv_series_id"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    private val detailTVSeriesViewModel: DetailTVSeriesViewModel by viewModels()
    private var favorited: Boolean = false
    private lateinit var tvSeries: TVSeries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initActivity()
        showDetails()
    }

    private fun initActivity() {
        supportActionBar?.title = "TV Series Detail"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    @SuppressLint("SetTextI18n")
    fun showDetails() {
        binding.progressBar.show(true)
        val id = intent.getIntExtra(EXTRA_ID, 0)
        val tvSeriesLiveData = detailTVSeriesViewModel.getTVSeries(id)
        tvSeriesLiveData.observe(this) {
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

            binding.btnFavorite.isEnabled = true
            binding.btnFavorite.setOnClickListener {
                favorited = when(favorited) {
                    true -> false
                    else -> true
                }
                setFavorite(favorited)
            }

            tvSeries = it
        }

        detailTVSeriesViewModel.isFavoriteTVSeries(id).observe(this, {
            if(it != null) {
                favorited = true
                binding.btnFavorite.toggle(favorited)
            }
        })
    }

    @SuppressLint("ShowToast")
    private fun setFavorite(boolean: Boolean) = lifecycleScope.launch {
        if (boolean) {
            detailTVSeriesViewModel.insertFavoriteTVSeries(tvSeries)
            Toast.makeText(this@DetailTVSeriesActivity, "Added to favorite!", Toast.LENGTH_SHORT).show()
        }
        else {
            detailTVSeriesViewModel.deleteFavoriteTVSeries(tvSeries)
            Toast.makeText(this@DetailTVSeriesActivity, "Removed from favorite!", Toast.LENGTH_SHORT).show()
        }
        binding.btnFavorite.toggle(boolean)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}