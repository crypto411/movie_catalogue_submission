package com.user.fadhlanhadaina.favorite_feature.fragment.tvseries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.favorite_feature.databinding.FavoriteTVSeriesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteTVSeriesFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteTVSeriesFragment()
    }

    private val viewModel: FavoriteTVSeriesViewModel by viewModels()
    private lateinit var binding: FavoriteTVSeriesFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FavoriteTVSeriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        showList()
    }

    private fun showList() {
        val favoriteTVSeriesAdapter = FavoriteTVSeriesAdapter()
        with(binding) {
            rvFavTVSeries.layoutManager =
                androidx.recyclerview.widget.LinearLayoutManager(context)
            rvFavTVSeries.adapter = favoriteTVSeriesAdapter
        }
        viewModel.getAllFavoriteTVSeries().observe(viewLifecycleOwner) {
            if(it != emptyList<PagedList<MovieFavoriteEntity>>())
                favoriteTVSeriesAdapter.submitList(it)
            else
                Toast.makeText(context, "Favorite TVSeries not found!", Toast.LENGTH_LONG).show()
        }
    }

}