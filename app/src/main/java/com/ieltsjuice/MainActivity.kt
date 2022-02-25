package com.ieltsjuice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate

import androidx.fragment.app.Fragment

import com.ieltsjuice.databinding.ActivityMainBinding
import com.ieltsjuice.placement_test.FragmentPlacementQuiz


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val fragmentHome = FragmentHome()
    private val fragmentAboutUs = com.ieltsjuice.about_us.FragmentAboutUs()
    private val fragmentOnlineCourses = FragmentOnlineCourses()
    private val fragmentPlacementQuiz = FragmentPlacementQuiz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(fragmentHome)

        binding.bottomNavigation.setOnItemSelectedListener  {
            when (it.itemId){
                R.id.ic_fragment_home -> replaceFragment(fragmentHome)
                R.id.ic_fragment_aboutUs -> replaceFragment(fragmentAboutUs)
                R.id.ic_fragment_studyOnline -> replaceFragment(fragmentOnlineCourses)
                R.id.ic_fragment_placement_quiz -> replaceFragment(fragmentPlacementQuiz)
            }
            true
        }
            binding.bottomNavigation.setOnItemReselectedListener {  }  //Empty tag
        
       // Day Night Switch
        binding.DayNightSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()

    }
}