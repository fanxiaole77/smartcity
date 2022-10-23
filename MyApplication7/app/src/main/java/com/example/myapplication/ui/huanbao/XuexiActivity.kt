package com.example.myapplication.ui.huanbao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_xuexi.*

class XuexiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xuexi)
        title = "党员学习"
        i1.setOnClickListener {
            startActivity(Intent(this,ShipinActivity::class.java))
        }
        i2.setOnClickListener {
            startActivity(Intent(this,ShipinActivity::class.java))
        }
        i3.setOnClickListener {
            startActivity(Intent(this,ShipinActivity::class.java))
        }
        i4.setOnClickListener {
            startActivity(Intent(this,ShipinActivity::class.java))
        }
    }
}