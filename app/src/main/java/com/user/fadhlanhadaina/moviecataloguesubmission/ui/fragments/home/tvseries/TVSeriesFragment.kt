package com.user.fadhlanhadaina.moviecataloguesubmission.ui.fragments.home.tvseries

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.TVSeriesFragmentBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.utils.ExtFun.show
import com.user.fadhlanhadaina.moviecataloguesubmission.viewmodel.ViewModelFactory

class TVSeriesFragment : Fragment() {

    companion object {
        fun newInstance() = TVSeriesFragment()
    }

    private lateinit var viewModel: TVSeriesViewModel
    private lateinit var binding: TVSeriesFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = TVSeriesFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        showList()
    }

    private fun initViewModel() {
        val factory = ViewModelFactory.newInstance(requireActivity().application)
        viewModel = ViewModelProvider(this, factory).get(TVSeriesViewModel::class.java)
    }

    private fun showList() {
        binding.progressBarTV.show(true)
        binding.rvTVSeriesData.layoutManager = LinearLayoutManager(this.context)
        viewModel.getTVSeries()?.observe(viewLifecycleOwner) {
            binding.progressBarTV.show(false)
            binding.rvTVSeriesData.adapter = TVSeriesListAdapter(it)
        }
    }

}