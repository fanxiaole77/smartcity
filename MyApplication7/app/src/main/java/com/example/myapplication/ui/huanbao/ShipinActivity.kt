package com.example.myapplication.ui.huanbao

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_shipin.*

class ShipinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipin)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.video02}")
        video.setVideoURI(uri)
    }
}