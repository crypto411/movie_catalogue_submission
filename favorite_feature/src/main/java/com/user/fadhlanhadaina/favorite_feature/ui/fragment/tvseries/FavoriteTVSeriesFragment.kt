package com.user.fadhlanhadaina.favorite_feature.ui.fragment.tvseries

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.user.fadhlanhadaina.core.domain.model.Movie
import com.user.fadhlanhadaina.favorite_feature.databinding.FavoriteTVSeriesFragmentBinding
import com.user.fadhlanhadaina.favorite_feature.ui.di.DaggerAppComponent
import com.user.fadhlanhadaina.favorite_feature.ui.viewmodel.ViewModelFactory
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.di.AppDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteTVSeriesFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteTVSeriesFragment()
    }

    private val binding: FavoriteTVSeriesFragmentBinding by lazy {
        FavoriteTVSeriesFragmentBinding.inflate(layoutInflater)
    }
    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: FavoriteTVSeriesViewModel by viewModels { factory }
    private lateinit var favoriteTVSeriesAdapter: FavoriteTVSeriesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        showList()
    }

    private fun initRecyclerView() {
        favoriteTVSeriesAdapter = FavoriteTVSeriesAdapter()
        with(binding) {
            rvFavTVSeries.layoutManager = LinearLayoutManager(context)
            rvFavTVSeries.adapter = favoriteTVSeriesAdapter
        }
    }

    private fun showList() {
        with(binding) {
            viewModel.getAllFavoriteTVSeries().observe(viewLifecycleOwner) {
                if(it != emptyList<Movie>()) {
                    favoriteTVSeriesAdapter.setData(it)
                    rvFavTVSeries.visibility = View.VISIBLE
                    favoriteTVSeriesInfo.visibility = View.GONE
                }
                else {
                    rvFavTVSeries.visibility = View.GONE
                    favoriteTVSeriesInfo.visibility = View.VISIBLE
                }
            }
        }
    }

}