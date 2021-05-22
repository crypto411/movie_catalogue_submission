package com.user.fadhlanhadaina.favorite_feature.fragment.movie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.user.fadhlanhadaina.core.model.MovieFavorite
import com.user.fadhlanhadaina.favorite_feature.databinding.FavoriteMovieFragmentBinding
import com.user.fadhlanhadaina.favorite_feature.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteMovieFragment()
    }

    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var binding: FavoriteMovieFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FavoriteMovieFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        showList()
    }

    private fun initViewModel() {
        val factory = ViewModelFactory.newInstance(requireActivity().application)
        viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]
    }

    private fun showList() {
        val favoriteMovieAdapter = FavoriteMovieAdapter()
        with(binding) {
            rvFavMovie.layoutManager = LinearLayoutManager(context)
            rvFavMovie.adapter = favoriteMovieAdapter
        }
        viewModel.getAllFavoriteMovie().observe(viewLifecycleOwner) {
            if(it != emptyList<PagedList<MovieFavorite>>())
                favoriteMovieAdapter.submitList(it)
            else
                Toast.makeText(context, "Favorite Movie not found!", Toast.LENGTH_LONG).show()
        }
    }

}