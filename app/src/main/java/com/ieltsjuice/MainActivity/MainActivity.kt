package com.ieltsjuice.MainActivity

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.messaging.FirebaseMessaging
import com.ieltsjuice.R
import com.ieltsjuice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Firebase Token - To send test Notification
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task.result
                Log.i("FMS_TOKEN",token)
            }
        }

        //Bottom Navigation Controller
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

        binding.navView.setOnItemReselectedListener { }  //Leave it - Empty tag

        binding.ieltsLogo.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ielts_juice_logo
            )
        )

        // Day Night Switch
        when (this.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {binding.ieltsLogo.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ielts_juice_logo_dark
                )
            )}
            Configuration.UI_MODE_NIGHT_NO -> {binding.ieltsLogo.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ielts_juice_logo
                )
            )}
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {binding.ieltsLogo.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ielts_juice_logo
                )
            )}
        }
/*
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
 */
    }
}