package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.MovieFragmentBinding
import com.user.fadhlanhadaina.core.util.ExtFun.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    companion object {
        fun newInstance() = MovieFragment()
    }

    private val viewModel: MovieViewModel by viewModels()
    private lateinit var binding: MovieFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MovieFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        showList()
    }

    private fun showList() {
        binding.progressBarMovie.show(true)
        binding.rvMovieData.layoutManager = LinearLayoutManager(this.context)
        val movies = viewModel.getMovies()
        movies.observe(viewLifecycleOwner) {
            binding.progressBarMovie.show(false)
            binding.rvMovieData.adapter = MovieListAdapter(it)
        }
    }
}