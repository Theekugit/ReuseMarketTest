package com.example.reusemarkettest.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.reusemarkettest.R
import com.example.reusemarkettest.common.viewBinding
import com.example.reusemarkettest.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityHomeBinding::inflate)

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setSupportActionBar(findViewById(R.id.topAppBar))
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}