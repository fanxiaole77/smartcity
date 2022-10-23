package com.example.myapplication.ui.activity.works

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityWork2Binding
import com.google.android.material.bottomnavigation.BottomNavigationView

class WorkActivity : BaseActivity() {

    private val binding:ActivityWork2Binding by lazy {
        ActivityWork2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        val navBottom: BottomNavigationView = findViewById(R.id.nav_bottom)
        val navContainer = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navBottom,navContainer)
    }
}