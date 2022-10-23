package com.example.myapplication.ui.account.login

import com.example.myapplication.network.Message
import com.example.myapplication.network.SmartCitynetwork
import com.example.myapplication.network.UserEntity

class LoginRepository() {
    suspend fun getLogin(username:String,password:String): Message {
        return SmartCitynetwork.getInstance().getLogin(username, password)
    }

}