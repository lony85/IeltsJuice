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
            }
            "Correction" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentCorrection()
                )
                transaction.commit()
            }
            "Consultation" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentConsultation()
                )
                transaction.commit()
            }
            "OneToOne" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentOneToOne()
                )
                transaction.commit()
            }
            "selfPaced" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentSelfPaced()
                )
                transaction.commit()
            }
            "placementQuestions" ->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.fragment_container_withoutNavigationActivity,
                    FragmentPlacementQuestions()
                )
                transaction.commit()
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
        binding.collapsingBarMain.title = "IELTS Score Calculator" //todo set toolbar names
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