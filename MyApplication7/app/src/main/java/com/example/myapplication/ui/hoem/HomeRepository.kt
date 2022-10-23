package com.example.myapplication.ui.hoem

import com.example.myapplication.network.BannerEntity
import com.example.myapplication.network.NewsEntity
import com.example.myapplication.network.ServiceEntity
import com.example.myapplication.network.SmartCitynetwork

class HomeRepository {
    suspend fun getHomeBanner():BannerEntity{
        return SmartCitynetwork.getInstance().getHomeBanner()
    }

    suspend fun getServer():ServiceEntity{
        return SmartCitynetwork.getInstance().getServer()
    }

    suspend fun getNewsList(): NewsEntity {
        return SmartCitynetwork.getInstance().getNewsList()
    }
}