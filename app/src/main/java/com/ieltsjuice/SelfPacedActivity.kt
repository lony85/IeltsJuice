package com.ieltsjuice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import com.ieltsjuice.databinding.ActivitySelfPacedBinding

class SelfPacedActivity : AppCompatActivity() {
    lateinit var binding:ActivitySelfPacedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfPacedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trasaction = supportFragmentManager.beginTransaction()
        trasaction.add(R.id.frameLayout_SelfPaced, FragmentSelfPaced())
        trasaction.commit()


    }





}