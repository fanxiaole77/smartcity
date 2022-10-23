package com.example.myapplication.ui.activity.house

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityHousecontentBinding

class HousecontentActivity : BaseActivity() {

    private val binder:ActivityHousecontentBinding by lazy {
        ActivityHousecontentBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: LookHouseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binder.root)
        viewModel = ViewModelProvider(this).get(LookHouseViewModel::class.java)
        binder.data = viewModel
        binder.lifecycleOwner = this

        binder.Tel.setOnClickListener {
         val intent = Intent(Intent.ACTION_DIAL)
            val tel = viewModel.house.value?.tel
            intent.data = Uri.parse("tel:$tel")
            startActivity(intent)
        }
        binder.home.setOnClickListener {
            val intent = Intent(this,LookHouseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}