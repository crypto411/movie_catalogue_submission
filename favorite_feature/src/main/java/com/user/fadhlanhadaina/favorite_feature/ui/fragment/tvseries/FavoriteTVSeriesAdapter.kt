package com.user.fadhlanhadaina.favorite_feature.ui.fragment.tvseries

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.fadhlanhadaina.core.domain.model.TVSeries
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.RowDataBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries.DetailTVSeriesActivity
import com.user.fadhlanhadaina.core.util.ExtFun.load

class FavoriteTVSeriesAdapter: RecyclerView.Adapter<FavoriteTVSeriesAdapter.ViewHolder>(){
    private var favoriteTVSeries: List<TVSeries> = mutableListOf()

    fun setData(favoriteTVSeries: List<TVSeries>) {
        this.favoriteTVSeries = favoriteTVSeries
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RowDataBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(tvSeries: TVSeries) {
            binding.ivList.load(tvSeries.posterUrl)
            binding.tvTitleList.text = tvSeries.title

            val splittedDate = tvSeries.releaseDate.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> tvSeries.releaseDate.split("-")[0]
            }
            binding.tvYearList.text = "(${year})"
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetailTVSeriesActivity::class.java)
                intent.putExtra(DetailTVSeriesActivity.EXTRA_ID, tvSeries.id)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvSeriesFavorite = favoriteTVSeries[position]
        if(tvSeriesFavorite != null)
            holder.bind(tvSeriesFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = favoriteTVSeries.size
}