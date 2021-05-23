package com.user.fadhlanhadaina.favorite_feature.fragment.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.user.fadhlanhadaina.core.domain.model.entity.MovieFavoriteEntity
import com.user.fadhlanhadaina.favorite_feature.databinding.FavoriteMovieFragmentBinding
import com.user.fadhlanhadaina.core.di.AppDependencies
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors

@AndroidEntryPoint
class FavoriteMovieFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteMovieFragment()
    }

    private val viewModel: FavoriteMovieViewModel by viewModels<FavoriteMovieViewModel>()
    private lateinit var binding: FavoriteMovieFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FavoriteMovieFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        DaggerAppComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context,
                    AppDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onActivityCreated(savedInstanceState)

        showList()
    }

    private fun showList() {
        val favoriteMovieAdapter = FavoriteMovieAdapter()
        with(binding) {
            rvFavMovie.layoutManager = LinearLayoutManager(context)
            rvFavMovie.adapter = favoriteMovieAdapter
        }
        viewModel.getAllFavoriteMovie().observe(viewLifecycleOwner) {
            if(it != emptyList<PagedList<MovieFavoriteEntity>>())
                favoriteMovieAdapter.submitList(it)
            else
                Toast.makeText(context, "Favorite Movie not found!", Toast.LENGTH_LONG).show()
        }
    }

}