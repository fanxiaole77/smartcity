package com.example.myapplication.ui.activity.works

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityWorkContentBinding

class WorkContentActivity : BaseActivity() {

    private var Id:Int? = null
    private lateinit var binding:ActivityWorkContentBinding
    private lateinit var viewModel: WorkViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_work_content)
        viewModel = ViewModelProvider(this).get(WorkViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = this

        Id = viewModel.work.value!!.id
    }
    companion object {
        const val TAG = "NewsContentActivity"

        fun start(context: Context) {
            context.startActivity(Intent(context, WorkContentActivity::class.java))
        }
    }
}