package com.example.myapplication.ui.huanbao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_dt.*

class DtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dt)

        t1.setOnClickListener {
            startActivity(Intent(this,DongtaiActivity::class.java))
            finish()
        }
        t2.setOnClickListener {
            startActivity(Intent(this,DongtaiActivity::class.java))
            finish()
        }
        t3.setOnClickListener {
            startActivity(Intent(this,DongtaiActivity::class.java))
            finish()
        }
        t4.setOnClickListener {
            startActivity(Intent(this,DongtaiActivity::class.java))
            finish()
        }
    }
}