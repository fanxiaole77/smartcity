package com.example.myapplication.base

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

abstract class BaseActivity:AppCompatActivity() {

    protected var activity:Activity? = null

    private var weakReference:WeakReference<Activity>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        weakReference = WeakReference(activity!!)
        ActivityCollector.pushTask(weakReference)
    }

    override fun onDestroy() {
        super.onDestroy()

        activity = null
        if (weakReference != null){
            ActivityCollector.removeTask(weakReference)
        }
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount != 0){
            supportFragmentManager.popBackStack()
        }
        super.onBackPressed()
    }
}