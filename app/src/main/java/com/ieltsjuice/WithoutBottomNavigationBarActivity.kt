package com.ieltsjuice

import android.app.AlertDialog
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.ieltsjuice.consultation.FragmentConsultation
import com.ieltsjuice.correction.FragmentCorrection
import com.ieltsjuice.about_us.*
import com.ieltsjuice.databinding.ActivityWithoutBottomNavigationBarBinding
import com.ieltsjuice.databinding.TemplaterAlertDialogBackTestPlacementBinding
import com.ieltsjuice.dictionary.FragmentDictionary
import com.ieltsjuice.dictionary.FragmentFavoriteWords
import com.ieltsjuice.placement_test.FragmentPlacementQuestions
import com.ieltsjuice.score_calculator.FragmentScoreCalculator
import com.ieltsjuice.self_paced.FragmentOneToOne
import com.ieltsjuice.self_paced.FragmentSelfPaced
import com.ieltsjuice.util.*
import com.ieltsjuice.youtube.FragmentYoutubePlayer

class WithoutBottomNavigationBarActivity : AppCompatActivity() {
    lateinit var binding: ActivityWithoutBottomNavigationBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithoutBottomNavigationBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Day Night Switch
        when (this.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                binding.ieltsLogo.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ielts_juice_logo_dark
                    )
                )
            }

            Configuration.UI_MODE_NIGHT_NO -> {
                binding.ieltsLogo.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ielts_juice_logo
                    )
                )
            }

            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                binding.ieltsLogo.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ielts_juice_logo
                    )
                )
            }
        }

        // Fill the fragment_container of current Activity
        when (intent.getStringExtra(PAGE_NAME_KEY)) {
            "AboutUs" -> {

                val teacherName = intent.getStringExtra("KEY_teacherName")
                val teacherFamily = intent.getStringExtra("KEY_teacherFamily")
                val teacherTitle = intent.getStringExtra("KEY_teacherTitle")
                val teacherDesc = intent.getStringExtra("KEY_teacherDesc")
                val teacherImage = intent.getStringExtra("KEY_teacherImage")
                val teacherFacebook = intent.getStringExtra("KEY_teacherFacebook")
                val teacherLinkedin = intent.getStringExtra("KEY_teacherLinkedin")
                val teacherInstagram = intent.getStringExtra("KEY_teacherInstagram")
                val teacherWebpage = intent.getStringExtra("KEY_teacherWebpage")
                val teacherSkype = intent.getStringExtra("KEY_teacherSkype")

                val bundle = Bundle()
                bundle.putString(KEY_teacherName, teacherName)
                bundle.putString(KEY_teacherFamily, teacherFamily)
                bundle.putString(KEY_teacherTitle, teacherTitle)
                bundle.putString(KEY_teacherDesc, teacherDesc)
                bundle.putString(KEY_teacherImage, teacherImage)
                bundle.putString(KEY_teacherFacebook, teacherFacebook)
                bundle.putString(KEY_teacherLinkedin, teacherLinkedin)
                bundle.putString(KEY_teacherInstagram, teacherInstagram)
                bundle.putString(KEY_teacherWebpage, teacherWebpage)
                bundle.putString(KEY_teacherSkype, teacherSkype)
                val fragment = FragmentAboutUsDetails()
                fragment.arguments = bundle

                val replaceTransaction = supportFragmentManager.beginTransaction()
                replaceTransaction.add(R.id.fragment_container_withoutNavigationActivity, fragment)
                replaceTransaction.commit()


//                binding.collapsingBarMain.title = "IELTS Score Calculator" // set toolbar names
            }

            "Dictionary" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    FragmentDictionary()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Dictionary" // set toolbar names
            }

            "favoriteWords" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    FragmentFavoriteWords()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Favorite Words" // set toolbar names
            }

            "calculator" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    FragmentScoreCalculator()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "IELTS Score Calculator" // set toolbar names

            }

            "Correction" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    FragmentCorrection()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "IELTS Writing Correction" // set toolbar names

            }

            "Consultation" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    FragmentConsultation()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Consultation" // set toolbar names
            }

            "OneToOne" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    FragmentOneToOne()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Online Private Courses" // set toolbar names

            }

            "selfPaced" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    FragmentSelfPaced()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "self-Paced Courses" // set toolbar names

            }

            "placementQuestions" -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    FragmentPlacementQuestions()
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Test Your English" // set toolbar names
            }

            "youtube" -> {

//                binding.collapsingBarMain.title = "IELTS Juice youtube channel" // set toolbar names

                val transaction = supportFragmentManager.beginTransaction()
                val videoId = intent.getStringExtra("videoId")
                val videoTitle = intent.getStringExtra("videoTitle")
                val videoDesc = intent.getStringExtra("videoDesc")
                val bundle = Bundle()
                bundle.putString("videoId", videoId)
                bundle.putString("videoTitle",videoTitle)
                bundle.putString("videoDesc",videoDesc)
                val fragment = FragmentYoutubePlayer()
                fragment.arguments = bundle
                transaction.add(
                    R.id.fragment_container_withoutNavigationActivity,
                    fragment
                )
                transaction.commit()
                binding.collapsingBarMain.title = "Youtube Player" // set toolbar names

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

    override fun onBackPressed() {

        if (intent.getStringExtra(PAGE_NAME_KEY) == "placementQuestions") {    // To avoid loosing test process , User must confirm exit button
            val alertDialog = AlertDialog.Builder(this).create()
            val dialogBinding = TemplaterAlertDialogBackTestPlacementBinding.inflate(layoutInflater)
            alertDialog.setView(dialogBinding.root)
            alertDialog.setCancelable(true)
            alertDialog.create()
            alertDialog.show()

            dialogBinding.continueBtn.setOnClickListener {
                super.onBackPressed()
            }
            dialogBinding.cancelBtn.setOnClickListener {
                alertDialog.dismiss()
            }
        } else {
            super.onBackPressed() // in any page except placement test
        }
    }
}