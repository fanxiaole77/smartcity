package com.example.myapplication.ui.mine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.Message
import com.example.myapplication.network.PersonalBean
import com.example.myapplication.network.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MineViewModel:ViewModel() {

    private val mineRepository = MineRepository()
    val userInfo = MutableLiveData<UserInfo>()
    var avatar = MutableLiveData<String>()

    val nickname = MutableLiveData<String>()

    val phoneNumber = MutableLiveData<String>()

    val idNumber = MutableLiveData<String>()

    suspend fun getUserInfo():UserInfo{

        return withContext(Dispatchers.IO){
            val user = mineRepository.getUserInfo()
            user
        }

    }
    suspend fun changUserInfo(bean: PersonalBean):Message{
        return withContext(Dispatchers.IO){
            val message = mineRepository.changePersonal(bean)
            message
        }
    }

}