package com.user.fadhlanhadaina.favorite_feature.ui.fragment.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.fadhlanhadaina.core.data.source.local.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.RowDataBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie.DetailMovieActivity
import com.user.fadhlanhadaina.core.util.ExtFun.load

class FavoriteMovieAdapter: RecyclerView.Adapter<FavoriteMovieAdapter.ViewHolder>() {
    private var favoriteMovies: List<MovieFavoriteEntity> = mutableListOf()

    fun setData(favoriteMovies: List<MovieFavoriteEntity>) {
        this.favoriteMovies = favoriteMovies
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RowDataBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(movieFavoriteEntity: MovieFavoriteEntity) {
            binding.ivList.load(movieFavoriteEntity.posterUrl)
            binding.tvTitleList.text = movieFavoriteEntity.title

            val splittedDate = movieFavoriteEntity.date.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> movieFavoriteEntity.date.split("-")[0]
            }
            binding.tvYearList.text = "(${year})"
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_ID, movieFavoriteEntity.id)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieFavorite = favoriteMovies.get(position)
        if(movieFavorite != null)
            holder.bind(movieFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return favoriteMovies.size
    }
}