package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.user.fadhlanhadaina.core.data.source.local.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.ActivityDetailBinding
import com.user.fadhlanhadaina.core.util.ExtFun.load
import com.user.fadhlanhadaina.core.util.ExtFun.show
import com.user.fadhlanhadaina.core.util.ExtFun.toggle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "movie_id"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()
    private var favorited: Boolean = false
    private var movieFavoriteEntity: MovieFavoriteEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initActivity()
        showDetails()
    }

    private fun initActivity() {
        supportActionBar?.title = "Movie Detail"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    @SuppressLint("SetTextI18n")
    private fun showDetails() {
        binding.progressBar.show(true)
        binding.btnFavorite.isEnabled = false
        val id = intent.getIntExtra(EXTRA_ID, 0)
        val movieLiveData = detailMovieViewModel.getMovie(id)
        movieLiveData.observe(this) { it ->
            binding.progressBar.show(false)
            binding.ivMovieDetail.load(it.posterUrl)

            val splittedDate = it.releaseDate.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> it.releaseDate.split("-")[0]
            }
            binding.tvTitleDetail.text = "${it.title} ($year)"
            binding.tvDurationDetail.text = "${it.duration} minute(s)"
            binding.tvOverviewDetail.text = it.overview
            binding.tvGenreDetail.text = "Genre: ${it.genres}"

            movieFavoriteEntity = MovieFavoriteEntity(it.id, it.posterUrl, it.title, it.releaseDate, it.genres)
            binding.btnFavorite.isEnabled = true
            binding.btnFavorite.setOnClickListener {
                favorited = when(favorited) {
                    true -> false
                    else -> true
                }
                setFavorite(favorited)
            }
        }
        detailMovieViewModel.isFavoriteMovie(id).observe(this, {
            if(it != null) {
                favorited = true
                binding.btnFavorite.toggle(favorited)
            }
        })
    }

    @SuppressLint("ShowToast")
    private fun setFavorite(boolean: Boolean) {
        if(movieFavoriteEntity != null) {
            if (boolean) {
                detailMovieViewModel.insertFavoriteMovie(movieFavoriteEntity!!)
                Toast.makeText(this, "Added to favorite!", Toast.LENGTH_SHORT).show()
            }
            else {
                detailMovieViewModel.deleteFavoriteMovie(movieFavoriteEntity!!)
                Toast.makeText(this, "Removed to favorite!", Toast.LENGTH_SHORT).show()
            }

            binding.btnFavorite.toggle(boolean)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}