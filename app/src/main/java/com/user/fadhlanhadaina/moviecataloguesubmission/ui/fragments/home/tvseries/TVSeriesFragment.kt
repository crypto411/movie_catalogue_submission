package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.TVSeriesFragmentBinding
import com.user.fadhlanhadaina.core.util.ExtFun.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TVSeriesFragment : Fragment() {

    companion object {
        fun newInstance() = TVSeriesFragment()
    }

    private val viewModel: TVSeriesViewModel by viewModels()
    private lateinit var binding: TVSeriesFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = TVSeriesFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        showList()
    }

    private fun showList() {
        binding.progressBarTV.show(true)
        binding.rvTVSeriesData.layoutManager = LinearLayoutManager(this.context)
        viewModel.getTVSeries().observe(viewLifecycleOwner) {
            binding.progressBarTV.show(false)
            binding.rvTVSeriesData.adapter = TVSeriesListAdapter(it)
        }
    }

}