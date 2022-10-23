package com.example.myapplication.ui.activity.works.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentToudiBinding
import com.example.myapplication.ui.activity.works.WorkViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ToudiFragment : BaseFragmnet() {

    private lateinit var binding: FragmentToudiBinding
    private lateinit var viewModel: WorkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_toudi, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(WorkViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = getActivity()

        viewModel.viewModelScope.launch(Dispatchers.Main) {
            val toudi = viewModel.getToudi()
            val adapter = ToudiAdapter(this@ToudiFragment.requireActivity())
            adapter.setList(toudi)
            binding.rvtoudi.apply {
                layoutManager = LinearLayoutManager(this@ToudiFragment.requireActivity())
                setAdapter(adapter)
                binding.rvtoudi.adapter = adapter
            }
        }
    }

}