package com.example.myapplication.ui.activity.subway.fargment.query

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.ServiceCreator
import com.example.myapplication.ui.activity.subway.CitySubwayRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QueryViewModel:ViewModel() {

    val imhUrl = MutableLiveData<String>()

    init {

        viewModelScope.launch {
            imhUrl.value = getLine()!!
        }
    }
    private suspend fun getLine():String{
        return withContext(Dispatchers.IO){
            val entity = CitySubwayRepository.getLine()
            val imgRrl = ServiceCreator.BASE_URL + entity.data.imgUrl
            imgRrl
        }
    }

}