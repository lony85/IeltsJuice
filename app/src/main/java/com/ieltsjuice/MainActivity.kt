package com.ieltsjuice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment

import com.ieltsjuice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val FragmentHome = FragmentHome()
    private val FragmentAboutUs = FragmentAboutUs()
    private val FragmentOnlineCourses = FragmentOnlineCourses()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(FragmentHome)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_fragment_home -> replaceFragment(FragmentHome)
                R.id.ic_fragment_aboutUs -> replaceFragment(FragmentAboutUs)
                R.id.ic_fragment_studyOnline -> replaceFragment(FragmentOnlineCourses)
            }
            true
        }


    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transacion = supportFragmentManager.beginTransaction()
            transacion.replace(R.id.fragment_container,fragment)
            transacion.commit()
        }

    }
}