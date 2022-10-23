package com.example.myapplication.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragment(type:Int) : BaseFragmnet() {

    private val _type = type
    private lateinit var binding:FragmentListBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        lifecycleScope.launch(Dispatchers.Main){
            val list = viewModel.getNewsList(_type)
            val adapter = NewsListAdapter(this@ListFragment.requireContext())
            adapter.setList(list)
            binding.rvNewsList.layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            binding.rvNewsList.adapter =adapter

        }
    }
    companion object{
        @JvmStatic
        fun newInstance(type:Int) = ListFragment(type)
    }
}