package com.example.myapplication.ui.account.register

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.SmartCityApplication
import com.example.myapplication.extensions.showToast
import com.example.myapplication.network.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterViewModel:ViewModel() {
    val username = MutableLiveData<String>()
    val nickname = MutableLiveData<String>()
    val phonenumber = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val registerRepository = RegisterRepository()

    fun getRegister(){
        if (TextUtils.isEmpty(username.value)){
            SmartCityApplication.context.getString(R.string.username_not_null).showToast()
                return
            }
        if (TextUtils.isEmpty(nickname.value)) {
            nickname.value = username.value
        }
        if (TextUtils.isEmpty(phonenumber.value)) {
            SmartCityApplication.context.getString(R.string.phone_number_not_null).showToast()
            return
        } else if (phonenumber.value!!.length != 11) {
            SmartCityApplication.context.getString(R.string.phone_number_format_error).showToast()
            return
        }
        if (TextUtils.isEmpty(password.value)) {
            SmartCityApplication.context.getString(R.string.password_not_null).showToast()
            return
        }
    }
    suspend fun register():Message{
        getRegister()
        return withContext(Dispatchers.IO){
            val message = registerRepository.getRegister(username.value!!,nickname.value!!,phonenumber.value!!,password.value!!)
            message
        }
    }
}