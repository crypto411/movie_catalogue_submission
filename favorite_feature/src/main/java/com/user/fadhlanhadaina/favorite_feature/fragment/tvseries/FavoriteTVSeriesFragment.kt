package com.user.fadhlanhadaina.favorite_feature.fragment.tvseries

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.paging.PagedList
import com.user.fadhlanhadaina.core.model.MovieFavorite
import com.user.fadhlanhadaina.favorite_feature.databinding.FavoriteTVSeriesFragmentBinding
import com.user.fadhlanhadaina.favorite_feature.viewmodel.ViewModelFactory

class FavoriteTVSeriesFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteTVSeriesFragment()
    }

    private lateinit var viewModel: FavoriteTVSeriesViewModel
    private lateinit var binding: FavoriteTVSeriesFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FavoriteTVSeriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        showList()
    }

    private fun initViewModel() {
        val factory = ViewModelFactory.newInstance(requireActivity().application)
        viewModel = ViewModelProvider(this, factory)[FavoriteTVSeriesViewModel::class.java]
    }

    private fun showList() {
        val favoriteTVSeriesAdapter = FavoriteTVSeriesAdapter()
        with(binding) {
            rvFavTVSeries.layoutManager =
                androidx.recyclerview.widget.LinearLayoutManager(context)
            rvFavTVSeries.adapter = favoriteTVSeriesAdapter
        }
        viewModel.getAllFavoriteTVSeries().observe(viewLifecycleOwner) {
            if(it != emptyList<PagedList<MovieFavorite>>())
                favoriteTVSeriesAdapter.submitList(it)
            else
                Toast.makeText(context, "Favorite TVSeries not found!", Toast.LENGTH_LONG).show()
        }
    }

}