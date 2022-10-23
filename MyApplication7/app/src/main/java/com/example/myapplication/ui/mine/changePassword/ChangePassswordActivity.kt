package com.example.myapplication.ui.mine.changePassword

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityChangePassswordBinding

class ChangePassswordActivity : BaseActivity() {

    private val binding:ActivityChangePassswordBinding by lazy {
        ActivityChangePassswordBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: ChangePasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ChangePasswordViewModel::class.java)
        binding.data= viewModel
        binding.lifecycleOwner = this

        binding.btnChange.setOnClickListener {
            viewModel.changePassword(this)
        }
    }
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ChangePassswordActivity::class.java))
        }
    }
}