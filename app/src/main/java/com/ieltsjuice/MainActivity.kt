package com.ieltsjuice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ieltsjuice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Bottom Navigation Controller
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)


        binding.navView.setOnItemReselectedListener { }  //Leave it - Empty tag

        // Day Night Switch
        binding.ieltsLogo.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ielts_juice_logo
            )
        )
        binding.DayNightSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.ieltsLogo.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ielts_juice_logo_dark
                    )
                )
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.ieltsLogo.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ielts_juice_logo
                    )
                )
            }
        }
    }
}