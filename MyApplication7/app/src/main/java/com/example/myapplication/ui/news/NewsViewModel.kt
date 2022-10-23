package com.example.myapplication.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.NewsClassifyEntity
import com.example.myapplication.network.NewsEntity
import com.example.myapplication.network.ServiceCreator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsViewModel:ViewModel() {

    private val newsRepository = NewsRepository()

    var newsContent = MutableLiveData<NewsEntity.Row>()

    init {

        newsContent.value = news
    }

    suspend fun getBanner():ArrayList<String>{
        return withContext(Dispatchers.IO){
            val arrayList = ArrayList<String>()
            val basebrl = ServiceCreator.BASE_URL
            val bannerPage = newsRepository.getHomeBanner()
            for (i in bannerPage.rows.indices){
                arrayList.add(basebrl + bannerPage.rows[i].advImg)
            }
            arrayList
        }
    }

    suspend fun getNewsClassify():ArrayList<NewsClassifyEntity.Data>{
        return withContext(Dispatchers.IO){
            val arrayList = ArrayList<NewsClassifyEntity.Data>()
            val classify = newsRepository.getNewsClassify()
            classify.data.forEach {
                arrayList.add(it)
            }
            arrayList
        }
    }
    suspend fun getNewsList(type:Int):ArrayList<NewsEntity.Row>{
        return withContext(Dispatchers.IO){
            val arrayList = ArrayList<NewsEntity.Row>()
            val news = newsRepository.getNewsList(type)
            news.rows.forEach {
                arrayList.add(it)
            }
            arrayList
        }
    }

    companion object {

        @JvmStatic
        var news=NewsEntity.Row()

    }
}