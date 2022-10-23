package com.example.myapplication.ui.activity.works

import com.example.myapplication.network.*
import kotlinx.coroutines.Job


class WorkRepository {

    suspend fun getWorkBanner():WorkBanner{
        return SmartCitynetwork.getInstance().getWorkBanner()
    }

    suspend fun getWork(): Recruitment{
        return SmartCitynetwork.getInstance().getWork()
    }

    suspend fun getWorkName(name:String):Recruitment{
        return SmartCitynetwork.getInstance().getWorknName(name)
    }

    suspend fun getToudi():Toudi{
        return SmartCitynetwork.getInstance().getToudi()
    }

    suspend fun getWorkInfo(name:String):  Recruitment{
        return SmartCitynetwork.getInstance().getWorkInfo(name)
    }
}