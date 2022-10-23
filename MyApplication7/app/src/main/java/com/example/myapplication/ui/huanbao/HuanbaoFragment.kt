package com.example.myapplication.ui.huanbao

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.extensions.start
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import kotlinx.android.synthetic.main.fragment_huanbao.*
import kotlinx.android.synthetic.main.item_toudi.*

class HuanbaoFragment : Fragment() {

    private val array = arrayListOf(
        R.drawable.hospital1,
        R.drawable.hospital2,
        R.drawable.hospital3,
    )

    private var launchBanner: Banner<Int, BannerImageAdapter<Int>>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_huanbao, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        banner.adapter = object :BannerImageAdapter<Int>(array){
            override fun onBindView(p0: BannerImageHolder?, p1: Int?, p2: Int, p3: Int) {
                Glide.with(p0!!.imageView).load(array[p2]).into(p0.imageView)
            }

        }
        b1.setOnClickListener {
            context?.let { it1 -> start<DongtaiActivity>(it1) }
        }
        b2.setOnClickListener {
            context?.let { it1 -> start<DongtaiActivity>(it1) }
        }
        dongtai.setOnClickListener {
            context?.let { it1 -> start<DtActivity>(it1) }
        }
        xuexi.setOnClickListener {
            context?.let { it1 -> start<XuexiActivity>(it1) }
        }
        huodong.setOnClickListener {
            context?.let { it1 -> start<PaizhaoActivity>(it1) }
        }
        paizhao.setOnClickListener {
            context?.let { it1 -> start<PaizhaoActivity>(it1) }
        }
        xiace.setOnClickListener {
            context?.let { it1 -> start<XuexiActivity>(it1) }
        }
    }


}