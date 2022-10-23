package com.example.myapplication.ui.hoem

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.news.NewsListFragment
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BaseFragmnet() {

    companion object{
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }
    private lateinit var binding:FragmentHomeBinding
    private lateinit var viewModel:HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.coordinatorScrollview.post {
            val layoutParams = binding.rlNews.layoutParams
            layoutParams.width = resources.displayMetrics.widthPixels
            layoutParams.height =
                binding.coordinatorScrollview.height - 10
            binding.rlNews.layoutParams = layoutParams
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.homePage = viewModel
        binding.lifecycleOwner = getActivity()

        lifecycleScope.launchWhenCreated {
            val bannerPage = viewModel.getBannerPage()
            viewModel.arrayList = bannerPage
        }
        viewModel.viewModelScope.launch(Dispatchers.Main) {  // 这句话是切换主线程
            val bannerPage = viewModel.getBannerPage()
            binding.homeBanner.apply {
                adapter = object :BannerImageAdapter<String>(bannerPage){
                    override fun onBindView(p0: BannerImageHolder?, p1: String?, p2: Int, p3: Int) {
                        Glide.with(p0!!.imageView).load(bannerPage[p2])
                            .into(p0.imageView)
                    }
                }
                indicator = CircleIndicator(this@HomeFragment.requireActivity())
                setIndicatorWidth(20, 30)
                setIndicatorSelectedColor(Color.BLUE)
            }
        }
        viewModel.viewModelScope.launch(Dispatchers.Main){
            val news = viewModel.getNewsHostTheme()
            val adapter = HotNewsAdapter(this@HomeFragment.requireActivity())
            adapter.setList(news)
            binding.rvHotTopic.apply {
                layoutManager = GridLayoutManager(this@HomeFragment.requireActivity(), 2)
                setAdapter(adapter)
            }
        }
        viewModel.viewModelScope.launch(Dispatchers.Main){
            val service =viewModel.getServer()
            val adapter = ServiceAdapter(this@HomeFragment.requireActivity())
            adapter.setList(service)
            binding.rvRecommendedFunction.apply {
                layoutManager = GridLayoutManager(this@HomeFragment.requireActivity(),5)
                setAdapter(adapter)
            }
        }
        val newFragment = NewsListFragment.newsInstance()
        childFragmentManager.beginTransaction().replace(R.id.rlNews,newFragment).commit()

    }

}