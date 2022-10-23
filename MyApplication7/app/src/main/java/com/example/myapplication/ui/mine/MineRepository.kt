package com.example.myapplication.ui.mine

import com.example.myapplication.network.*

class MineRepository {

    suspend fun getUserInfo():UserInfo{
        return SmartCitynetwork.getInstance().getUserInfo()
    }
    suspend fun changePersonal(bean: PersonalBean): Message {
        return SmartCitynetwork.getInstance().changePersonal(bean)
    }
    suspend fun getAllOrders(orderStatus: Boolean): OrderEntity {
        return SmartCitynetwork.getInstance().getAllOrders(orderStatus)
    }
    suspend fun changePwd(oldPassword: String, newPassword: String): Message {
        return SmartCitynetwork.getInstance().changePwd(PasswordBean(oldPassword, newPassword))
    }
    suspend fun feedback(bean: Feed): Message {
        return SmartCitynetwork.getInstance().feedback(bean)
    }
}