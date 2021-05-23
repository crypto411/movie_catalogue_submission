package com.user.fadhlanhadaina.favorite_feature.fragment.tvseries

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.favorite_feature.databinding.FavoriteTVSeriesFragmentBinding
import com.user.fadhlanhadaina.favorite_feature.di.DaggerAppComponent
import com.user.fadhlanhadaina.favorite_feature.viewmodel.ViewModelFactory
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.di.AppDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteTVSeriesFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteTVSeriesFragment()
    }

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: FavoriteTVSeriesViewModel by viewModels { factory }
    private lateinit var binding: FavoriteTVSeriesFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FavoriteTVSeriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerAppComponent.builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context.applicationContext,
                    AppDependencies::class.java
                )
            )
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            if(it != emptyList<MovieFavoriteEntity>())
                favoriteTVSeriesAdapter.setData(it)
            else
                Toast.makeText(context, "Favorite TVSeries not found!", Toast.LENGTH_LONG).show()
        }
    }

}