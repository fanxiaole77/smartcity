package com.example.myapplication.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragmnet
import com.example.myapplication.databinding.FragmentNewsListBinding
import com.example.myapplication.ui.hoem.HomeFragment.Companion.newInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsListFragment : BaseFragmnet() {

    companion object{
        fun newsInstance() = NewsListFragment()
    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var binding:FragmentNewsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)

        binding.constraintLayout.post {
            val layoutParams = binding.viewpager.layoutParams
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutParams.height = binding.constraintLayout.height - binding.tabLayout.height
            binding.viewpager.layoutParams = layoutParams
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)


        val adapter = NewsPagerAdapter(childFragmentManager)
        viewModel.viewModelScope.launch(Dispatchers.Main) {
            val classify = viewModel.getNewsClassify()
            val titles = mutableListOf<String>()
            val data = mutableListOf<Fragment>()
            classify.forEach {
                titles.add(it.name)
                data.add(ListFragment.newInstance(it.id))
            }
            adapter.apply {
                setData(data as ArrayList<Fragment>)
                setTitle(titles as ArrayList<String>)
            }
            binding.viewpager.adapter = adapter
            binding.tabLayout.setupWithViewPager(binding.viewpager)
        }


    }
}