package com.ieltsjuice.self_paced.writing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.ieltsjuice.R
import com.ieltsjuice.databinding.ActivitySelfPacedWritingBinding

class SelfPacedWritingActivity : AppCompatActivity() {
    lateinit var binding: ActivitySelfPacedWritingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfPacedWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container_writing, FragmentSelfPacedWriting())
        transaction.commit()

        // Toolbar
        setSupportActionBar(binding.toolbarMain)
        binding.collapsingBarMain.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
        binding.collapsingBarMain.title = "IELTS WRITING"
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