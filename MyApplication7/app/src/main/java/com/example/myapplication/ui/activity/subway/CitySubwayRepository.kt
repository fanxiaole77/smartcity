package com.example.myapplication.ui.activity.subway

import com.example.myapplication.network.LineContentEntity
import com.example.myapplication.network.LineEntity
import com.example.myapplication.network.LineInfoEntity
import com.example.myapplication.network.SmartCitynetwork

object CitySubwayRepository {
    suspend fun getLineInfo(currentName: String): LineInfoEntity {
        return SmartCitynetwork.getInstance().getLineInfo(currentName)
    }
    suspend fun getLineContent(id :Int): LineContentEntity {
        return SmartCitynetwork.getInstance().getLineContent(id)
    }
    suspend fun getLine(): LineEntity {
        return SmartCitynetwork.getInstance().getLine()
    }
}