package com.example.myapplication.ui.mine.changePassword

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.extensions.showToast
import com.example.myapplication.network.Message
import com.example.myapplication.ui.account.AccountActivity
import com.example.myapplication.ui.mine.MineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChangePasswordViewModel:ViewModel() {

    private var mineRepository = MineRepository()

    val oldPassword = MutableLiveData<String>()

    val newPassword = MutableLiveData<String>()

    val suerPassword = MutableLiveData<String>()

    private suspend fun changePwd(oldPassword:String,newPassword:String):Message{
        return withContext(Dispatchers.IO){
            val message = mineRepository.changePwd(oldPassword,newPassword)
            message
        }
    }
    fun changePassword(context: Context){
        if (oldPassword.value.isNullOrEmpty()) {
            "旧密码不能为空！".showToast()
            return
        }
        if (newPassword.value.isNullOrEmpty()) {
            "新密码不能为空！".showToast()
            return
        }

        if (newPassword.value!!.length < 6) {
            "密码最少六位！".showToast()
            return
        }
        if (!newPassword.value.equals(suerPassword.value)) {
            "两次密码不一致！".showToast()
            return
        }

        viewModelScope.launch(Dispatchers.Main){
            val message = changePwd(oldPassword.value!!,newPassword.value!!)
            if (message.code == 200){
                message.msg.showToast()
                oldPassword.value = ""
                newPassword.value = ""
                suerPassword.value = ""
                delay(1000)
                AccountActivity.start(context)
                "修改成功为确保数据异常需要用户重新登录".showToast()
            }else {
                message.msg.showToast()
            }
        }
    }

}