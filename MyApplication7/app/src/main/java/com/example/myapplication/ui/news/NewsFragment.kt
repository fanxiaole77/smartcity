package com.example.myapplication.ui.news

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentNewsBinding
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsFragment : BaseFragmnet() {

    companion object {
        fun newsInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)

        binding.coordinatorScrollview.post {
            val layoutParams = binding.rlNews.layoutParams
            layoutParams.width = resources.displayMetrics.widthPixels
            layoutParams.height = binding.coordinatorScrollview.height
            binding.rlNews.layoutParams = layoutParams
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        val newsFragment = NewsListFragment.newsInstance()

        viewModel.viewModelScope.launch(Dispatchers.Main) {
            val bannerPage = viewModel.getBanner()
            binding.newsBanner.apply {
                adapter = object :BannerImageAdapter<String>(bannerPage){
                    override fun onBindView(p0: BannerImageHolder?, p1: String?, p2: Int, p3: Int) {
                        Glide.with(p0!!.imageView).load(bannerPage[p2]).into(p0.imageView)
                    }

                }
                indicator = CircleIndicator(this@NewsFragment.requireContext())
                setIndicatorWidth(20, 30)
                setIndicatorSelectedColor(Color.BLUE)
            }
        }
        childFragmentManager.beginTransaction().replace(R.id.rlNews,newsFragment).commit()
    }

}