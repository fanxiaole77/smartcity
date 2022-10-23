package com.example.myapplication.ui.activity.house

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityZufangBinding

class ZufangActivity : BaseActivity(){

    private lateinit var binding:ActivityZufangBinding
    private lateinit var viewModel: LookHouseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LookHouseViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_zufang)
        binding.data = viewModel
        binding.lifecycleOwner = this

        val adapter = LookHouseAdapter(this)
        lifecycleScope.launchWhenCreated {
            val array = viewModel.getHOuseZufang()
            binding.rv4.layoutManager = LinearLayoutManager(this@ZufangActivity,LinearLayoutManager.VERTICAL,false)
            adapter.setData(array)
            binding.rv4.adapter =adapter
        }
    }
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ZufangActivity::class.java))
        }
    }
}