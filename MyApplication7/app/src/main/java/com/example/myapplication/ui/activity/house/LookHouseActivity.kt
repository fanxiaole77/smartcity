package com.example.myapplication.ui.activity.house

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityLookHouseBinding
import com.example.myapplication.network.LookHouseBanner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_look_house.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LookHouseActivity : BaseActivity() {


    companion object{
        fun newsInstance() = LookHouseActivity()
    }

    private lateinit var binding:ActivityLookHouseBinding
    private lateinit var viewModel: LookHouseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //开启返回上一页
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        viewModel = ViewModelProvider(this).get(LookHouseViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_look_house)
        binding.data = viewModel
        binding.lifecycleOwner = this

        binding.ershou.setOnClickListener {
            ErshouActivity.start(this)
            finish()
        }
        binding.loupan.setOnClickListener {
            LoupanActivity.start(this)
            finish()
        }
        binding.zhongjie.setOnClickListener {
            ZhongjieActivity.start(this)
            finish()
        }
        binding.zufang.setOnClickListener {
            ZufangActivity.start(this)
            finish()
        }

        lifecycleScope.launch(Dispatchers.Main){
            val bannerPage = viewModel.getLookBanner()
            binding.LookhomeBanner.apply {
                adapter = object :BannerImageAdapter<String>(bannerPage){
                    override fun onBindView(p0: BannerImageHolder?, p1: String?, p2: Int, p3: Int) {
                        Glide.with(p0!!.imageView).load(bannerPage[p2]).into(p0.imageView)
                    }
                }
                indicator = CircleIndicator(this@LookHouseActivity)
                setIndicatorWidth(20,30)
                setIndicatorSelectedColor(Color.BLUE)
            }
        }

        val adapter = LookHouseAdapter(this)
        lifecycleScope.launchWhenCreated {
            val array = viewModel.getHouse()
            binding.rvcyclerview.layoutManager = LinearLayoutManager(this@LookHouseActivity,LinearLayoutManager.VERTICAL,false)
            adapter.setData(array)
            binding.rvcyclerview.adapter = adapter
        }


    }


}
