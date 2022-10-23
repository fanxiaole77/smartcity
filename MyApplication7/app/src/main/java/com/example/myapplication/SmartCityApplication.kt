package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import com.example.myapplication.extensions.sharedPreferences

class SmartCityApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        TOKEN = sharedPreferences.getString("token","").toString()
        userid = sharedPreferences.getString("userId","").toString()
        Log.d("userid","$userid")
        Log.d("userid","$TOKEN")
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        lateinit var TOKEN:String
        lateinit var userid:String
    }

}