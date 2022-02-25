package com.ieltsjuice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat

import com.ieltsjuice.databinding.ActivityWithoutBottomNavigationBarBinding
import com.ieltsjuice.placement_test.FragmentPlacementQuestions
import com.ieltsjuice.self_paced.FragmentOneToOne
import com.ieltsjuice.self_paced.FragmentSelfPaced

class WithoutBottomNavigationBarActivity : AppCompatActivity() {
    lateinit var binding : ActivityWithoutBottomNavigationBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithoutBottomNavigationBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (intent.getStringExtra(PAGE_NAME_KEY)){
            "calculator" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,FragmentScoreCalculator())
                transaction.commit()
                binding.collapsingBarMain.title = "IELTS Score Calculator" //todo set toolbar names

            }
            "Correction" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentCorrection()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "IELTS Writing Correction" //todo set toolbar names

            }
            "Consultation" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentConsultation()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Consultation" //todo set toolbar names
            }
            "OneToOne" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentOneToOne()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Online Private Courses" //todo set toolbar names

            }
            "selfPaced" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentSelfPaced()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "self-Paced Courses" //todo set toolbar names

            }
            "placementQuestions" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentPlacementQuestions()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Test Your English" //todo set toolbar names
            }

        }


        // Toolbar
        setSupportActionBar(binding.toolbarMain)
        binding.collapsingBarMain.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }
}