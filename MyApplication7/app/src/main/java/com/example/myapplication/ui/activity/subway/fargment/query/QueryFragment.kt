package com.example.myapplication.ui.activity.subway.fargment.query

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentQueryBinding

class QueryFragment : BaseFragmnet() {

    private lateinit var viewModel: QueryViewModel
    private  val binding:FragmentQueryBinding by lazy {
        FragmentQueryBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QueryViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = this
    }

}