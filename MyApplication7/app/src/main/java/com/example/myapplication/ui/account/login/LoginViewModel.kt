package com.example.myapplication.ui.account.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.SmartCityApplication.Companion.context
import com.example.myapplication.extensions.showToast
import com.example.myapplication.network.Message
import com.example.myapplication.network.Toudi
import com.example.myapplication.network.UserEntity

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginViewModel():ViewModel() {
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val loginRepository =LoginRepository()
    fun getLogin(){
        if (username.value == null){
            context.getString(R.string.username_not_null).showToast()
            return
        }
        if (password.value == null){
            context.getString(R.string.password_not_null).showToast()
            return
        }
    }
    suspend fun login():Message{
        getLogin()
        return withContext(Dispatchers.IO){
            val message = loginRepository.getLogin(username.value!!,password.value!!)
            message
        }
    }
}