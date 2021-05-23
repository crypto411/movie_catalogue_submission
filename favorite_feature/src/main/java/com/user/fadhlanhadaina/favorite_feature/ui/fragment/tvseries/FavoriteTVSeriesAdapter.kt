package com.user.fadhlanhadaina.favorite_feature.ui.fragment.tvseries

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.fadhlanhadaina.core.data.source.local.entity.TVSeriesFavoriteEntity
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.RowDataBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries.DetailTVSeriesActivity
import com.user.fadhlanhadaina.core.util.ExtFun.load

class FavoriteTVSeriesAdapter: RecyclerView.Adapter<FavoriteTVSeriesAdapter.ViewHolder>(){
    private var favoriteTVSeries: List<TVSeriesFavoriteEntity> = mutableListOf()

    fun setData(favoriteTVSeries: List<TVSeriesFavoriteEntity>) {
        this.favoriteTVSeries = favoriteTVSeries
        notifyDataSetChanged()
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
        val movieFavorite = favoriteTVSeries.get(position)
        if(movieFavorite != null)
            holder.bind(movieFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = favoriteTVSeries.size
}