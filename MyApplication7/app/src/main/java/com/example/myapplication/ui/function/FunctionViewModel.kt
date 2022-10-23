package com.example.myapplication.ui.function

import androidx.lifecycle.ViewModel
import com.example.myapplication.network.ServiceEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FunctionViewModel:ViewModel() {
    private val functionRepository = FunctionRepository()
    var arrayList = mutableListOf<String>()

    suspend fun getServer(): ArrayList<ServiceEntity.Row> {
        return withContext(Dispatchers.IO) {
            val arrayList = ArrayList<ServiceEntity.Row>()
            val serviceEntity = functionRepository.getServer()
//            serviceEntity.rows.forEach {
//                arrayList.add(it)
//            }
            for (i in 0..23) {// 只获取前23个服务
                arrayList.add(serviceEntity.rows[i])
            }
            val data = ServiceEntity.Row(serviceName = "更多服务", imgUrl = arrayList[0].imgUrl)
            arrayList.add(data)
            arrayList
        }

    }
}