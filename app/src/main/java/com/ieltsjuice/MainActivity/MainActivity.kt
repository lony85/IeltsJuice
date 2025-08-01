package com.ieltsjuice.MainActivity

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.messaging.FirebaseMessaging
import com.ieltsjuice.R
import com.ieltsjuice.databinding.ActivityMainBinding
import androidx.core.net.toUri


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var isFabOpen = false

    @SuppressLint("UseCompatLoadingForDrawables")
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

        //fab icon
        var isFABExpened=false


        binding.floatingActionButton.setOnClickListener {
            toggleFab()
        }

        binding.floatingActionButtonEmail.setOnClickListener {
            val email = Intent(Intent.ACTION_SENDTO)
                .setData("mailto:support@ieltsjuice.freshdesk.com".toUri())
            startActivity(email)

//            val email = Intent(Intent.ACTION_VIEW)
//                .setData(Uri.parse("support@ieltsjuice.freshdesk.com"))
//                .setPackage("com.google.android.gm")
//            startActivity(email)
        }
        binding.floatingActionButtonTelegram.setOnClickListener {
            val telegramUri = "https://telegram.me/ieltsjuice".toUri()
            val iTelegram = Intent(Intent.ACTION_VIEW, telegramUri)
            iTelegram.setPackage("com.telegram")
            try {
                startActivity(iTelegram)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        "https://telegram.me/ieltsjuice".toUri()
                    )
                )
            }

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

    private fun toggleFab() {
        if (isFabOpen) {
            binding.floatingActionButtonEmail.hide()
            binding.floatingActionButtonTelegram.hide()
        } else {
            binding.floatingActionButtonEmail.show()
            binding.floatingActionButtonTelegram.show()
        }
        isFabOpen = !isFabOpen    }

    private fun collapseFABMenu() {

        val fabEmail = TranslateAnimation(
            0f,
            0f,
            0f,
            0f
        )
        val fabTelegram = TranslateAnimation(
            0f,
            0f,
            0f,
            0f
        )
        fabEmail.fillAfter = true
        fabEmail.duration = 300
        fabTelegram.fillAfter = true
        fabTelegram.duration = 300
        binding.floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_contact_us))
        binding.floatingActionButtonEmail.startAnimation(fabEmail)
        binding.floatingActionButtonTelegram.startAnimation(fabTelegram)

    }


    private fun expendFABMenu() {

        val fabEmail = TranslateAnimation(
            0f,
            0f,
            0f,
            -200f
        )
        val fabTelegram = TranslateAnimation(
            0f,
            0f,
            0f,
            -350f
        )
        fabEmail.fillAfter = true
        fabEmail.duration = 200
        fabTelegram.fillAfter = true
        fabTelegram.duration = 200

        binding.floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_cross))
        binding.floatingActionButtonEmail.startAnimation(fabEmail)
        binding.floatingActionButtonTelegram.startAnimation(fabTelegram)    }
}







