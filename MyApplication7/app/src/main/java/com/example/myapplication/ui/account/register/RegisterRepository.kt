package com.example.myapplication.ui.account.register

import com.example.myapplication.network.Message
import com.example.myapplication.network.SmartCitynetwork

class RegisterRepository {

    suspend fun getRegister(
        username:String,
        nickname:String,
        phonenumber: String,
        password:String): Message {
        return  SmartCitynetwork.getInstance().getRegister(username, nickname, phonenumber, password)
    }
}