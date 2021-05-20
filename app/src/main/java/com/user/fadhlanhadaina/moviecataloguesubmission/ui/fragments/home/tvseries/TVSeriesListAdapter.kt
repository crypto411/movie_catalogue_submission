package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.fadhlanhadaina.moviecataloguesubmission.data.model.TVSeries
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.RowDataBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.detail.tvseries.DetailTVSeriesActivity
import com.user.fadhlanhadaina.moviecataloguesubmission.utils.ExtFun.load

class TVSeriesListAdapter(private val tvSerieLists: ArrayList<TVSeries>): RecyclerView.Adapter<TVSeriesListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RowDataBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(tvSeries: TVSeries) {
            binding.ivList.load(tvSeries.posterUrl)
            binding.tvTitleList.text = tvSeries.title

            val splittedDate = tvSeries.date.split("/")
            val year = when(splittedDate.size) {
                2 -> splittedDate[2]
                else -> tvSeries.date.split("-")[0]
            }
            binding.tvYearList.text = "(${year})"
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetailTVSeriesActivity::class.java)
                intent.putExtra(DetailTVSeriesActivity.EXTRA_ID, tvSeries.id)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvSerieLists[position])
    }

    override fun getItemCount(): Int {
        return tvSerieLists.size
    }
}