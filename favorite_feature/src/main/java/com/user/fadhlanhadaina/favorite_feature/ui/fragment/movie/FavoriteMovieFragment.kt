package com.user.fadhlanhadaina.favorite_feature.ui.fragment.movie

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
import com.user.fadhlanhadaina.favorite_feature.databinding.FavoriteMovieFragmentBinding
import com.user.fadhlanhadaina.favorite_feature.ui.di.DaggerAppComponent
import com.user.fadhlanhadaina.favorite_feature.ui.viewmodel.ViewModelFactory
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.di.AppDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteMovieFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteMovieFragment()
    }

    private val binding: FavoriteMovieFragmentBinding by lazy {
        FavoriteMovieFragmentBinding.inflate(layoutInflater)
    }
    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: FavoriteMovieViewModel by viewModels { factory }
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter

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
        favoriteMovieAdapter = FavoriteMovieAdapter()
        with(binding) {
            rvFavMovie.layoutManager = LinearLayoutManager(context)
            rvFavMovie.adapter = favoriteMovieAdapter
        }
    }

    private fun showList() {
        with(binding) {
            viewModel.getAllFavoriteMovie().observe(viewLifecycleOwner) {
                if(it != emptyList<Movie>()) {
                    rvFavMovie.visibility = View.VISIBLE
                    favoriteMovieAdapter.setData(it)
                    favoriteMovieInfo.visibility = View.GONE
                }
                else {
                    rvFavMovie.visibility = View.GONE
                    favoriteMovieInfo.visibility = View.VISIBLE
                }
            }
        }
    }

}