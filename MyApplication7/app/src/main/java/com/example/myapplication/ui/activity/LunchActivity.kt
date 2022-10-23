package com.example.myapplication.ui.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.View.OnClickListener
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.extensions.sharedPreferences
import com.example.myapplication.extensions.start
import com.example.myapplication.ui.account.AccountActivity
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnPageChangeListener

class LunchActivity : BaseActivity(),View.OnClickListener {
    private val array = arrayListOf(
        R.drawable.launch01,
        R.drawable.launch05,
        R.drawable.launch03,
        R.drawable.launch04,
        R.drawable.launch05,
    )

    private var launchBanner: Banner<Int, BannerImageAdapter<Int>>? = null
    private var btnImmediately: Button? = null
    private var tvIpPortSetting: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)

        supportActionBar?.hide()

        launchBanner = findViewById(R.id.launchBanner)
        btnImmediately = findViewById(R.id.btnImmediately)
        tvIpPortSetting = findViewById(R.id.tvIpPortSetting)

        btnImmediately?.setOnClickListener(this)
        tvIpPortSetting?.setOnClickListener(this)
        launchBanner?.apply {
            setAdapter(object : BannerImageAdapter<Int>(array) {
                override fun onBindView(
                    holder: BannerImageHolder?,
                    data: Int?,
                    position: Int,
                    size: Int,
                ) {
                    Glide.with(holder!!.imageView).load(array[position]).into(holder.imageView)
                }
            }, false)
            isAutoLoop(false)  // 不需要自动循环

        addOnPageChangeListener(object:OnPageChangeListener{
            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                if (p0 == array.size -1){
                    tvIpPortSetting!!.visibility = View.VISIBLE
                    btnImmediately!!.visibility = View.VISIBLE
                }else{
                    tvIpPortSetting!!.visibility = View.GONE
                    btnImmediately!!.visibility =View.GONE
                }
            }

            override fun onPageSelected(p0: Int) {
            }

            override fun onPageScrollStateChanged(p0: Int) {

            }

        })
            //设置指示器及其颜色和大小
            indicator = CircleIndicator(this@LunchActivity)
            setIndicatorSelectedColor(Color.BLUE)
            setIndicatorNormalColor(Color.WHITE)
            setIndicatorMargins(IndicatorConfig.Margins(0, 0, 0, 50))
            setIndicatorWidth(20, 30)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnImmediately -> {
             val token = sharedPreferences.getString("token","")
                if (TextUtils.isEmpty(token)){
                AccountActivity.start(this)
                    finish()
                }else{
                    start<MainActivity>(this)
                    finish()
                }
            }
        }
    }
}