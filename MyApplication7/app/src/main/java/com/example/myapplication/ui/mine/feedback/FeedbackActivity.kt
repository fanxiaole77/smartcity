package com.example.myapplication.ui.mine.feedback

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityFeedbackBinding

class FeedbackActivity : BaseActivity() {

    private val binding:ActivityFeedbackBinding by lazy {
        ActivityFeedbackBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: FeedbackViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this).get(FeedbackViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = this
        var number = 0
        viewModel.textEditNumber.value = "$number/150"

        viewModel.editFeedback.observe(this) { value ->
            number = value?.length ?: 0
            viewModel.textEditNumber.value = "$number/150"
            if (number == 150) {
                binding.textEditNumber.setTextColor(Color.RED)
            } else {
                binding.textEditNumber.setTextColor(Color.BLACK)
            }
        }
    }
    companion object {
        const val TAG = "FeedbackActivity"
        fun start(context: Context) {
            context.startActivity(Intent(context, FeedbackActivity::class.java))
        }
    }
}