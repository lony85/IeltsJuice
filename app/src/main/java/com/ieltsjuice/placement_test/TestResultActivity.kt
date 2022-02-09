package com.ieltsjuice.placement_test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.ieltsjuice.R
import com.ieltsjuice.databinding.ActivityTestResultBinding

class TestResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityTestResultBinding
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestResultBinding.inflate(layoutInflater)
        setContentView(binding.root)




        when (intent.getIntExtra(KEY_testResult,-1)) {
            in 0..18 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleA1)
                binding.icResultA1.setImageDrawable(getDrawable(R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleA1)
                binding.txtDescription.text = getString(R.string.txtDescriptionA1)
            }
            in 19..36 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleA2)
                binding.icResultA2.setImageDrawable(getDrawable(R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleA2)
                binding.txtDescription.text = getString(R.string.txtDescriptionA2)
            }
            in 37..54 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleB1)
                binding.icResultB1.setImageDrawable(getDrawable(R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleB1)
                binding.txtDescription.text = getString(R.string.txtDescriptionB1)
            }
            in 55..72 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleB2)
                binding.icResultB2.setImageDrawable(getDrawable(R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleB2)
                binding.txtDescription.text = getString(R.string.txtDescriptionB2)
            }
            in 73..90 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleC1)
                binding.icResultC1.setImageDrawable(getDrawable(R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleC1)
                binding.txtDescription.text = getString(R.string.txtDescriptionC1)
            }
            in 91..108 -> {
                binding.txtResultTitle.text = getString(R.string.txtTitleC2)
                binding.icResultC2.setImageDrawable(getDrawable(R.drawable.ic_hand_point_down))
                binding.txtDescriptionTitle.text = getString(R.string.txtDescriptionTitleC2)
                binding.txtDescription.text = getString(R.string.txtDescriptionC2)
            }
        }

        // Toolbar
        setSupportActionBar(binding.toolbarMain)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.collapsingBarMain.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            onBackPressed()
        }
        return true
    }
}