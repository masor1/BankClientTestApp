package com.masorone.bankclienttestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.MaterialToolbar
import com.masorone.bankclienttestapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var appBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        appBar = findViewById(R.id.topAppBar)
        appBar.setNavigationOnClickListener {
            navController.navigate(R.id.action_cardsFragment_to_mainFragment)
        }
    }
}