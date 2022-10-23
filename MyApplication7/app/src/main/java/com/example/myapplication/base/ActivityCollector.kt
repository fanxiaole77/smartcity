package com.example.myapplication.base

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.Stack

object ActivityCollector {
    private val activitys = Stack<WeakReference<Activity>>()

    // 将activity 压入Application栈
    fun pushTask(task: WeakReference<Activity>?) {
        activitys.push(task)
    }
    fun removeTask(task: WeakReference<Activity>?){
        activitys.remove(task)
    }
}