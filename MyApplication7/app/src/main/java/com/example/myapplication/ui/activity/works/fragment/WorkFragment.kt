package com.example.myapplication.ui.activity.works.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentWoekBinding
import com.example.myapplication.network.Recruitment
import com.example.myapplication.ui.activity.works.WorkViewModel
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_woek.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkFragment : BaseFragmnet() {

    private  val binding: FragmentWoekBinding by lazy {
        FragmentWoekBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: WorkViewModel
    private lateinit var adapter: WorkAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = WorkAdapter(this.requireActivity())
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(WorkViewModel::class.java)
        binding.rdata = viewModel
        binding.lifecycleOwner = this

        lifecycleScope.launchWhenCreated {
            val bannerPage = viewModel.getWorkBanner()
            viewModel.arrayList = bannerPage
            intData()

            binding.btnQuery.setOnClickListener {
                if (viewModel.name.value.isNullOrBlank()){
                    return@setOnClickListener
                }
                intData(viewModel.name.value!!)
            }
        }


        //轮播图
        viewModel.viewModelScope.launch(Dispatchers.Main){
            val bannerPage = viewModel.getWorkBanner()

            binding.workBanner.apply {
                adapter = object :BannerImageAdapter<String>(bannerPage){
                    override fun onBindView(p0: BannerImageHolder?, p1: String?, p2: Int, p3: Int) {
                        Glide.with(p0!!.imageView).load(bannerPage[p2]).into(p0.imageView)
                    }
                }
                indicator = CircleIndicator(this@WorkFragment.requireContext())
                setIndicatorWidth(20, 30)
                setIndicatorSelectedColor(Color.BLUE)
            }
        }
        //职位列表

        viewModel.viewModelScope.launch(Dispatchers.Main){
            val news = viewModel.getWork()
            val adapter = WorkAdapter(this@WorkFragment.requireActivity())
            adapter.setList(news)
            binding.rvwork.apply {
                layoutManager = LinearLayoutManager(this@WorkFragment.requireActivity(),LinearLayoutManager.VERTICAL,false)
                setAdapter(adapter)
                binding.rvwork.adapter = adapter
            }
        }

       binding.text1.setOnClickListener {
           viewModel.viewModelScope.launch(Dispatchers.Main){
               val news = viewModel.getWorkName()
               val adapter = WorkAdapter(this@WorkFragment.requireActivity())
               adapter.setList(news)
               binding.rvwork.apply {
                   layoutManager = LinearLayoutManager(this@WorkFragment.requireActivity(),LinearLayoutManager.VERTICAL,false)
                   setAdapter(adapter)
                   binding.rvwork.adapter = adapter
               }
           }
       }

    }
    private fun intData(name:String = ""){
        lifecycleScope.launch {
            var lineInfo = viewModel.getWorkInfo(name)
            viewModel.name.value = lineInfo?.rows?.get(0)?.name
            var arrayList = ArrayList<Recruitment.Row>()
            for (e in lineInfo?.rows!!){
                arrayList.add(e)
            }
            adapter.setList(arrayList)
            binding.rvwork.layoutManager = LinearLayoutManager(this@WorkFragment.requireContext())
            binding.rvwork.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }
}