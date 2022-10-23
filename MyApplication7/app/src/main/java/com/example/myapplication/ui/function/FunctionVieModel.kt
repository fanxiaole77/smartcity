package com.example.myapplication.ui.function

import com.example.myapplication.network.ServiceEntity
import com.example.myapplication.network.SmartCitynetwork

class FunctionRepository {
    suspend fun getServer(): ServiceEntity {
        return SmartCitynetwork.getInstance().getServer()
    }
}