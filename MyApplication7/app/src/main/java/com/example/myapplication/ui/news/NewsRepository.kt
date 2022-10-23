package com.example.myapplication.ui.news

import com.example.myapplication.network.*

class NewsRepository {

    suspend fun getHomeBanner():BannerEntity{
        return SmartCitynetwork.getInstance().getHomeBanner()
    }

   suspend fun getNewsList(type:Int):NewsEntity{
       return SmartCitynetwork.getInstance().getNewsList(type)
   }
    suspend fun getNewsClassify():NewsClassifyEntity{
        return SmartCitynetwork.getInstance().getNewsClassify()
    }
    suspend fun getNewsComments(newsId:Int):NewsCommentsEntity{
        return SmartCitynetwork.getInstance().getNewsComments(newsId)
    }
    suspend fun pressComments(bean: CommentsBean): Message {
        return SmartCitynetwork.getInstance().pressComments(bean)
    }
}