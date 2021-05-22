package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.movie.DetailMovieActivity
import com.user.fadhlanhadaina.core.model.Movie
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.RowDataBinding
import com.user.fadhlanhadaina.core.util.ExtFun.load

class MovieListAdapter(private val movieLists: ArrayList<Movie>): RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RowDataBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(movie: Movie) {
            binding.ivList.load(movie.posterUrl)
            binding.tvTitleList.text = movie.title

            val splittedDate = movie.date.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> movie.date.split("-")[0]
            }
            binding.tvYearList.text = "(${year})"
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_ID, movie.id)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieLists[position])
    }

    override fun getItemCount(): Int {
        return movieLists.size
    }
}