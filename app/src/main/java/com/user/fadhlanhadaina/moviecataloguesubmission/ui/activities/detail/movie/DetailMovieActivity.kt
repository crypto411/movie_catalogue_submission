package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.user.fadhlanhadaina.moviecataloguesubmission.R
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.MovieFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.ActivityDetailBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.utils.ExtFun.load
import com.user.fadhlanhadaina.moviecataloguesubmission.utils.ExtFun.show
import com.user.fadhlanhadaina.moviecataloguesubmission.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "movie_id"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private var favorited: Boolean = false
    private var movieFavorite: MovieFavorite? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActivity()
        initViewModel()
        showDetails()
    }

    private fun initActivity() {
        supportActionBar?.title = "Movie Detail"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViewModel() {
        val factory = ViewModelFactory.newInstance(application)
        detailMovieViewModel = ViewModelProvider(this, factory).get(DetailMovieViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    private fun showDetails() {
        binding.progressBar.show(true)
        binding.btnFavorite.isEnabled = false
        val id = intent.getIntExtra(EXTRA_ID, 0)
        val movieLiveData = detailMovieViewModel.getMovie(id)
        movieLiveData?.observe(this) { it ->
            binding.progressBar.show(false)
            binding.ivMovieDetail.load(it.posterUrl)

            val splittedDate = it.date.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> it.date.split("-")[0]
            }
            binding.tvTitleDetail.text = "${it.title} ($year)"
            binding.tvDurationDetail.text = "${it.duration} minute(s)"
            binding.tvOverviewDetail.text = it.overview
            binding.tvGenreDetail.text = "Genre: ${it.stringGenres}"

            movieFavorite = MovieFavorite(it.id, it.posterUrl, it.title, it.date, it.stringGenres)
            binding.btnFavorite.isEnabled = true
            binding.btnFavorite.setOnClickListener {
                favorited = when(favorited) {
                    true -> false
                    else -> true
                }
                setFavorite(favorited)
            }
        }
        if(detailMovieViewModel.isFavoriteMovie(id)) {
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
        if(movieFavorite != null) {
            if (boolean) {
                detailMovieViewModel.insertFavoriteMovie(movieFavorite!!)
                Toast.makeText(this, "Added to favorite!", Toast.LENGTH_SHORT).show()
            }
            else {
                detailMovieViewModel.deleteFavoriteMovie(movieFavorite!!)
                Toast.makeText(this, "Removed to favorite!", Toast.LENGTH_SHORT).show()
            }

            binding.btnFavorite.toggle(boolean)
        }
        Log.d("boolFavorite", boolean.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}