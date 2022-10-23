package com.example.myapplication.ui.activity.subway.fargment.city

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCityBinding
import com.example.myapplication.network.LineInfoEntity
import kotlinx.coroutines.launch


class CityFragment : Fragment() {
    private lateinit var viewModel: CitySubwayViewModel
    private val binding:FragmentCityBinding by lazy{
        FragmentCityBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: LineInfoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = LineInfoAdapter(this.requireActivity())
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CitySubwayViewModel::class.java)
        binding.cdata = viewModel
        binding.lifecycleOwner = this
        initData()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initData(name: String = "建国门") {

        lifecycleScope.launch {
            var lineInfo = viewModel.getLineInfo(name)
            viewModel.name.value = lineInfo?.data?.get(0)?.currentName
            val arrayLine = ArrayList<LineInfoEntity.Data>()
            for (e in lineInfo?.data!!) {
                arrayLine.add(e)
            }
            adapter.setData(arrayLine)
            binding.recyclerview.layoutManager =
                LinearLayoutManager(this@CityFragment.requireContext())
            binding.recyclerview.adapter = adapter
            adapter.notifyDataSetChanged()

        }
    }
}