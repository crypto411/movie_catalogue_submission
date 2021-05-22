package com.user.fadhlanhadaina.favorite_feature.fragment.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.user.fadhlanhadaina.core.domain.model.MovieFavorite
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.RowDataBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie.DetailMovieActivity
import com.user.fadhlanhadaina.core.util.ExtFun.load

class FavoriteMovieAdapter: PagedListAdapter<MovieFavorite, FavoriteMovieAdapter.ViewHolder>(DIFFERENT_CALLBACK) {

    companion object {
        private val DIFFERENT_CALLBACK: DiffUtil.ItemCallback<MovieFavorite> = object : DiffUtil.ItemCallback<MovieFavorite>() {
            override fun areItemsTheSame(oldMovieFavorite: MovieFavorite, newMovieFavorite: MovieFavorite): Boolean {
                return oldMovieFavorite.title == newMovieFavorite.title && oldMovieFavorite.date == newMovieFavorite.date
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldMovieFavorite: MovieFavorite, newMovieFavorite: MovieFavorite): Boolean {
                return oldMovieFavorite == newMovieFavorite
            }
        }
    }

    inner class ViewHolder(private val binding: RowDataBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(movieFavorite: MovieFavorite) {
            binding.ivList.load(movieFavorite.posterUrl)
            binding.tvTitleList.text = movieFavorite.title

            val splittedDate = movieFavorite.date.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> movieFavorite.date.split("-")[0]
            }
            binding.tvYearList.text = "(${year})"
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_ID, movieFavorite.id)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieFavorite = getItem(position)
        if(movieFavorite != null)
            holder.bind(movieFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}