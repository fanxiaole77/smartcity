package com.example.myapplication.ui.hoem

import androidx.lifecycle.ViewModel
import com.example.myapplication.network.NewsEntity
import com.example.myapplication.network.ServiceCreator
import com.example.myapplication.network.ServiceEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.security.Provider.Service

class HomeViewModel : ViewModel() {

    private val homeRepository = HomeRepository()

    var arrayList = mutableListOf<String>()

    suspend fun getBannerPage():ArrayList<String>{
        return withContext(Dispatchers.IO){
            val arrayList = ArrayList<String>()
            val baseBrl = ServiceCreator.BASE_URL
            val bannerPage = homeRepository.getHomeBanner()
            for (i in bannerPage.rows.indices){
                arrayList.add(baseBrl + bannerPage.rows[i].advImg)
            }
            arrayList
        }
    }
    suspend fun getNewsHostTheme():ArrayList<NewsEntity.Row>{
        return withContext(Dispatchers.IO){
            val arrayList = ArrayList<NewsEntity.Row>()
            val news = homeRepository.getNewsList()
            news.rows.forEach {
                arrayList.add(it)
            }
            arrayList
        }
    }
    suspend fun getServer(): ArrayList<ServiceEntity.Row> {
        return withContext(Dispatchers.IO) {
            val arrayList = ArrayList<ServiceEntity.Row>()
            val serviceEntity = homeRepository.getServer()
//            serviceEntity.rows.forEach {
//                arrayList.add(it)
//            }
            for (i in 0..8) {// 只获取前九个服务
                arrayList.add(serviceEntity.rows[i])
            }
            val data = ServiceEntity.Row(serviceName = "更多服务", imgUrl = arrayList[0].imgUrl)
            arrayList.add(data)
            arrayList
        }

    }

}