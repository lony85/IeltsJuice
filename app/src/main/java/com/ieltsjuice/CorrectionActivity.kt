package com.ieltsjuice

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.ieltsjuice.databinding.ActivityCorrectionBinding

class CorrectionActivity : AppCompatActivity() {
    lateinit var binding : ActivityCorrectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCorrectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCorrectionIranDiscount.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/4751/881160/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/4751/881160/")
                    )
                )
            }
        }
        binding.buttonCorrectionIranExpress.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/6086/683111/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/6086/683111/")
                    )
                )
            }
        }
        binding.buttonCorrectionSendNow.setOnClickListener {
            val webUri = Uri.parse("https://ieltsjuice.com/services/writing-correction/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ieltsjuice.com/services/writing-correction/")
                    )
                )
            }
        }
        binding.buttonCorrectionContactUs.setOnClickListener {
            val webUri = Uri.parse("https://ieltsjuice.com/contact/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ieltsjuice.com/contact/")
                    )
                )
            }
        }
        // Toolbar
        setSupportActionBar(binding.toolbarMain)
        binding.collapsingBarMain.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))
        binding.collapsingBarMain.title = "Writing Correction"
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