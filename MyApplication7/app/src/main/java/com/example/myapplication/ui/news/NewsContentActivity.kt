package com.example.myapplication.ui.news

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityNewsContentBinding

class NewsContentActivity : BaseActivity() {

    private var newsId:Int? = null
    private val binding:ActivityNewsContentBinding by lazy {
        ActivityNewsContentBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = this

        newsId = viewModel.newsContent.value!!.id

    }
    companion object{
        fun start(context: Context){
            context.startActivity(Intent(context,NewsContentActivity::class.java))
        }
    }
}