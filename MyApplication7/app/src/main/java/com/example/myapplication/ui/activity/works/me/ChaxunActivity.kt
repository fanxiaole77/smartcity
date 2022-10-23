package com.example.myapplication.ui.activity.works.me

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityChaxunBinding
import com.example.myapplication.ui.activity.works.WorkViewModel

class ChaxunActivity : BaseActivity() {

    private val binding:ActivityChaxunBinding by lazy {
        ActivityChaxunBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: WorkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(WorkViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = this
        Log.d("name","${binding.most.text}")
    }
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ChaxunActivity::class.java))
        }
    }
}