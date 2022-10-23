package com.example.myapplication.ui.activity.subway.fargment.city

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.extensions.showToast
import com.example.myapplication.network.LineContentEntity
import com.example.myapplication.network.LineInfoEntity
import com.example.myapplication.ui.activity.subway.CitySubwayRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CitySubwayViewModel:ViewModel() {

    var currentName = MutableLiveData<String>()

    var name = MutableLiveData<String>()


    var firstName = MutableLiveData<String>()
    var endName = MutableLiveData<String>()
    var km = MutableLiveData<String>()
    var time = MutableLiveData<String>()


    suspend fun getLineInfo(currentName: String = "建国门"): LineInfoEntity? {
        return withContext(Dispatchers.IO) {
            val lineInfo = CitySubwayRepository.getLineInfo(currentName)
            if (lineInfo.code != 200 || lineInfo.data.isEmpty()) {
                "没有站点信息".showToast()
                return@withContext null
            }
            lineInfo
        }
    }
    suspend fun getLineContent(id: Int): LineContentEntity {
        return withContext(Dispatchers.IO) {
            CitySubwayRepository.getLineContent(id)
        }
    }


}