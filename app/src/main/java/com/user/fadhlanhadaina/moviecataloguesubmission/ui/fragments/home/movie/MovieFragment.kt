package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.movie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.MovieFragmentBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.utils.ExtFun.show
import com.user.fadhlanhadaina.moviecataloguesubmission.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    companion object {
        fun newInstance() = MovieFragment()
    }

    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: MovieFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MovieFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
        showList()
    }

    private fun initViewModel() {
        val factory = ViewModelFactory.newInstance(requireActivity().application)
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
    }

    private fun showList() {
        binding.progressBarMovie.show(true)
        binding.rvMovieData.layoutManager = LinearLayoutManager(this.context)
        val movies = viewModel.getMovies()
        movies?.observe(viewLifecycleOwner) {
            binding.progressBarMovie.show(false)
            binding.rvMovieData.adapter = MovieListAdapter(it)
        }
    }
}