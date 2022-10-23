package com.example.myapplication.ui.activity.house

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.HouseInfoEntity
import com.example.myapplication.network.ServiceCreator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LookHouseViewModel:ViewModel() {

    private val lookHouseRePository = LookHouseRePository()

    var arrayList = mutableListOf<String>()
    var house = MutableLiveData<HouseInfoEntity.Row>()

    init {
        house.value = houseEntity
    }

    suspend fun getLookBanner():ArrayList<String>{
        return withContext(Dispatchers.IO){
            val  arrayList = ArrayList<String>()
            val baseBrl = ServiceCreator.BASE_URL
            val bannerPage = lookHouseRePository.getLookHousebanner()
            for (i in bannerPage.rows.indices){
                arrayList.add(baseBrl+bannerPage.rows[i].advImg)
            }
            arrayList
        }
    }

    suspend fun getHouse():ArrayList<HouseInfoEntity.Row>{
        return withContext(Dispatchers.IO){
            var house = lookHouseRePository.getHouse()
            val array = arrayListOf<HouseInfoEntity.Row>()
            for (e in house.rows){
                array.add(e)
            }
            array
        }
    }

    suspend fun getHouseershou(houseType:String = "二手"):ArrayList<HouseInfoEntity.Row>{
        return withContext(Dispatchers.IO){
            var houseershou = lookHouseRePository.getHouseershou(houseType)
            val array = arrayListOf<HouseInfoEntity.Row>()
            for (e in houseershou.rows){
                array.add(e)
            }
            array
        }
    }

    suspend fun getHOuseLoupan(houseType:String = "楼盘"):ArrayList<HouseInfoEntity.Row>{
        return withContext(Dispatchers.IO){
            var houseloupan = lookHouseRePository.getHouseloupan(houseType)
            val  array = arrayListOf<HouseInfoEntity.Row>()
            for (e in houseloupan.rows){
                array.add(e)
            }
            array
        }
    }
    suspend fun getHOuseZhongjie(houseType:String = "中介"):ArrayList<HouseInfoEntity.Row>{
        return withContext(Dispatchers.IO){
            var housezhongjie = lookHouseRePository.getHousezhongjie(houseType)
            val  array = arrayListOf<HouseInfoEntity.Row>()
            for (e in housezhongjie.rows){
                array.add(e)
            }
            array
        }
    }
    suspend fun getHOuseZufang(houseType:String = "租房"):ArrayList<HouseInfoEntity.Row>{
        return withContext(Dispatchers.IO){
            var housezufang = lookHouseRePository.getHousezufang(houseType)
            val  array = arrayListOf<HouseInfoEntity.Row>()
            for (e in housezufang.rows){
                array.add(e)
            }
            array
        }
    }

    companion object {

        @JvmStatic
        var houseEntity: HouseInfoEntity.Row? = null
    }
}