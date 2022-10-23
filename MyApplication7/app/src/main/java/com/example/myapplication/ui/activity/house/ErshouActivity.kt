package com.example.myapplication.ui.activity.house

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityErshouBinding

class ErshouActivity : BaseActivity() {

    private lateinit var binding:ActivityErshouBinding
    private lateinit var viewModel: LookHouseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(LookHouseViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_ershou)
        binding.data = viewModel
        binding.lifecycleOwner = this

        val adapter = LookHouseAdapter(this)
        lifecycleScope.launchWhenCreated {
            val array = viewModel.getHouseershou()
            binding.rv1.layoutManager = LinearLayoutManager(this@ErshouActivity,LinearLayoutManager.VERTICAL,false)
            adapter.setData(array)
            binding.rv1.adapter =adapter
        }
    }
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ErshouActivity::class.java))
        }
    }
}