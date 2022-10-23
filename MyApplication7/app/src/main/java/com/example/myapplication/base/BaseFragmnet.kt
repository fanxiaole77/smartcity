package com.example.myapplication.base

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragmnet:Fragment() {

    lateinit var activity: Activity

    override fun onAttach(context: Context) {
        super.onAttach(context)

        activity = requireActivity()
    }

}