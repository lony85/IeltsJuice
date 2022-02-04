package com.ieltsjuice.self_paced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ieltsjuice.R
import com.ieltsjuice.databinding.ActivitySelfPacedBinding

class SelfPacedActivity : AppCompatActivity() {
    lateinit var binding:ActivitySelfPacedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfPacedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout_SelfPaced, FragmentSelfPaced())
        transaction.commit()


    }
}