package com.ieltsjuice

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.ieltsjuice.databinding.ActivityOneToOneBinding

class OneToOneActivity : AppCompatActivity() {
    lateinit var binding : ActivityOneToOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneToOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOnetoOneConsultation.setOnClickListener {
            val webUri = Uri.parse("https://ieltsjuice.com/services/consultation/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ieltsjuice.com/services/consultation/")
                    )
                )
            }
        }
        binding.buttonOnetoOneIRAN.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/43/679673/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/43/679673/")
                    )
                )
            }
        }
        binding.buttonOnetoOneRegister.setOnClickListener {
            val webUri = Uri.parse("https://ieltsjuice.com/services/one-to-one/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ieltsjuice.com/services/one-to-one/")
                    )
                )
            }
        }
        // Toolbar
        setSupportActionBar(binding.toolbarMain)
        binding.collapsingBarMain.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))
        binding.collapsingBarMain.title = "Online Private Courses"
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            onBackPressed()
        }
        return true
    }
}