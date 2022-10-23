package com.example.myapplication.ui.activity.subway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityCitySubwayBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class CitySubwayActivity : BaseActivity() {

    private val binding:ActivityCitySubwayBinding by lazy {
        ActivityCitySubwayBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "城市地铁"

        val navBottom: BottomNavigationView = findViewById(R.id.nav_bottom)
        val navContainer = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navBottom, navContainer)
    }
}