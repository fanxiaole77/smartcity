package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.extensions.sharedPreferences
import com.example.myapplication.extensions.showToast
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {
    private var backPressTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navBottom: BottomNavigationView = findViewById(R.id.nav_bottom)
        val navContainer = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navBottom, navContainer)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStack()
        }else{
            processBackPressed()
        }
    }
    private fun processBackPressed() {
        val now = System.currentTimeMillis()
        if (now - backPressTime > 2000) {
            String.format(getString(R.string.press_again_to_exit), getString(R.string.app_name))
                .showToast()
            backPressTime = now
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}
