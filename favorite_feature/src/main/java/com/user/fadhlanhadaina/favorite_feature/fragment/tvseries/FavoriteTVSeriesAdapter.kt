package com.user.fadhlanhadaina.favorite_feature.fragment.tvseries

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.user.fadhlanhadaina.core.domain.model.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.RowDataBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries.DetailTVSeriesActivity
import com.user.fadhlanhadaina.core.util.ExtFun.load

class FavoriteTVSeriesAdapter: PagedListAdapter<TVSeriesFavoriteEntity, FavoriteTVSeriesAdapter.ViewHolder>(DIFFERENT_CALLBACK) {

    companion object {
        private val DIFFERENT_CALLBACK: DiffUtil.ItemCallback<TVSeriesFavoriteEntity> = object : DiffUtil.ItemCallback<TVSeriesFavoriteEntity>() {
            override fun areItemsTheSame(oldTVSeriesFavoriteEntity: TVSeriesFavoriteEntity, newTVSeriesFavoriteEntity: TVSeriesFavoriteEntity): Boolean {
                return oldTVSeriesFavoriteEntity.title == newTVSeriesFavoriteEntity.title && oldTVSeriesFavoriteEntity.date == newTVSeriesFavoriteEntity.date
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldTVSeriesFavoriteEntity: TVSeriesFavoriteEntity, newTVSeriesFavoriteEntity: TVSeriesFavoriteEntity): Boolean {
                return oldTVSeriesFavoriteEntity == newTVSeriesFavoriteEntity
            }
        }
    }

    inner class ViewHolder(private val binding: RowDataBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(movieFavoriteEntity: TVSeriesFavoriteEntity) {
            binding.ivList.load(movieFavoriteEntity.posterUrl)
            binding.tvTitleList.text = movieFavoriteEntity.title

            val splittedDate = movieFavoriteEntity.date.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> movieFavoriteEntity.date.split("-")[0]
            }
            binding.tvYearList.text = "(${year})"
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetailTVSeriesActivity::class.java)
                intent.putExtra(DetailTVSeriesActivity.EXTRA_ID, movieFavoriteEntity.id)
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