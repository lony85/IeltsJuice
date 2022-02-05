package com.ieltsjuice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment

import com.ieltsjuice.databinding.ActivityMainBinding
import com.ieltsjuice.placement_test.FragmentPlacementQuiz
import com.ieltsjuice.self_paced.FragmentOnlineCourses


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val FragmentHome = FragmentHome()
    private val FragmentAboutUs = com.ieltsjuice.about_us.FragmentAboutUs()
    private val FragmentOnlineCourses = FragmentOnlineCourses()
    private val FragmentPlacementQuiz = FragmentPlacementQuiz()

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
                R.id.ic_fragment_placement_quiz -> replaceFragment(FragmentPlacementQuiz)
            }
            true
        }


    }
    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()

    }
}