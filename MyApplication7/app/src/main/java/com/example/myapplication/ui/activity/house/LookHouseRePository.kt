package com.example.myapplication.ui.activity.house

import com.example.myapplication.network.HouseInfoEntity
import com.example.myapplication.network.LookHouseBanner
import com.example.myapplication.network.SmartCitynetwork

class LookHouseRePository {

    suspend fun getLookHousebanner():LookHouseBanner{
        return SmartCitynetwork.getInstance().getLookHouse()
    }

    suspend fun getHouse(): HouseInfoEntity {
        return SmartCitynetwork.getInstance().getHouse()
    }
    suspend fun getHouseershou(houseType:String):HouseInfoEntity{
        return SmartCitynetwork.getInstance().getHouseershou(houseType)
    }

    suspend fun getHouseloupan(houseType: String):HouseInfoEntity{
        return SmartCitynetwork.getInstance().getHoueloupan(houseType)
    }

    suspend fun getHousezhongjie(houseType: String):HouseInfoEntity{
        return SmartCitynetwork.getInstance().getHouezhongjie(houseType)
    }

    suspend fun getHousezufang(houseType: String):HouseInfoEntity{
        return SmartCitynetwork.getInstance().getHouseZufang(houseType)
    }
}