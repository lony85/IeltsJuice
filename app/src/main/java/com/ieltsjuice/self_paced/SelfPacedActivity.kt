package com.ieltsjuice.self_paced

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.MenuItem
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.ieltsjuice.R
import com.ieltsjuice.databinding.ActivitySelfPacedBinding
import com.ieltsjuice.self_paced.listening.SelfPacedListeningActivity
import com.ieltsjuice.self_paced.speaking.SelfPacedSpeakingActivity

class SelfPacedActivity : AppCompatActivity() {
    lateinit var binding:ActivitySelfPacedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfPacedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSelfPacedSpeaking.setOnClickListener {
            val intent = Intent(this, SelfPacedSpeakingActivity::class.java)
            startActivity(intent)
        }
        binding.buttonSelfPacedListening.setOnClickListener {
            val intent = Intent(this, SelfPacedListeningActivity::class.java)
            startActivity(intent)
        }
        binding.buttonSelfPacedWriting.setOnClickListener {
//            val intent = Intent(this, SelfPacedSpeakingActivity::class.java)
//            startActivity(intent)
        }
        binding.buttonSelfPacedReading.setOnClickListener {
//            val intent = Intent(this, SelfPacedSpeakingActivity::class.java)
//            startActivity(intent)
        }
        //FAQ Session
        var result = false
        binding.question1CardView.setOnClickListener {
            // Gets linearlayout
            val layout = binding.questionAnswerDivider1
            // Gets the layout params that will allow you to resize the layout
            val params: ViewGroup.LayoutParams = layout.layoutParams
            if (!result) {
                binding.txtA1.text = getString(R.string.A_selfPaced_01)
                binding.txtA1.textSize = 16f
                binding.icArrowQ1.setImageResource(R.drawable.ic_arrow_down)
                params.height = (2f).toDips().toInt()
                result = true
            } else {
                binding.txtA1.text = ""
                binding.txtA1.textSize = 0f
                binding.icArrowQ1.setImageResource(R.drawable.ic_arrow_right)
                params.height = (0f).toDips().toInt()
                result = false

            }
        }
        binding.question2CardView.setOnClickListener {
            // Gets linearlayout
            val layout = binding.questionAnswerDivider2
            // Gets the layout params that will allow you to resize the layout
            val params: ViewGroup.LayoutParams = layout.layoutParams
            if (!result) {
                binding.txtA2.text = getString(R.string.A_selfPaced_02)
                binding.txtA2.textSize = 16f
                binding.icArrowQ2.setImageResource(R.drawable.ic_arrow_down)
                params.height = (2f).toDips().toInt()
                result = true
            } else {
                binding.txtA2.text = ""
                binding.txtA2.textSize = 0f
                binding.icArrowQ2.setImageResource(R.drawable.ic_arrow_right)
                params.height = (0f).toDips().toInt()
                result = false

            }
        }
        binding.question3CardView.setOnClickListener {
            // Gets linearlayout
            val layout = binding.questionAnswerDivider3
            // Gets the layout params that will allow you to resize the layout
            val params: ViewGroup.LayoutParams = layout.layoutParams
            if (!result) {
                binding.txtA3.text = getString(R.string.A_selfPaced_03)
                binding.icArrowQ3.setImageResource(R.drawable.ic_arrow_down)
                params.height = (2f).toDips().toInt()
                binding.txtA3.textSize = 16f
                result = true
            } else {
                binding.txtA3.text = ""
                binding.icArrowQ3.setImageResource(R.drawable.ic_arrow_right)
                params.height = (0f).toDips().toInt()
                binding.txtA3.textSize = 0f
                result = false

            }
        }
        binding.question4CardView.setOnClickListener {
            // Gets linearlayout
            val layout = binding.questionAnswerDivider4
            // Gets the layout params that will allow you to resize the layout
            val params: ViewGroup.LayoutParams = layout.layoutParams
            if (!result) {
                binding.txtA4.text = getString(R.string.A_selfPaced_04)
                binding.icArrowQ4.setImageResource(R.drawable.ic_arrow_down)
                params.height = (2f).toDips().toInt()
                binding.txtA4.textSize = 16f
                result = true
            } else {
                binding.txtA4.text = ""
                binding.icArrowQ4.setImageResource(R.drawable.ic_arrow_right)
                params.height = (0f).toDips().toInt()
                binding.txtA4.textSize = 0f
                result = false

            }
        }
        binding.question5CardView.setOnClickListener {
            // Gets linearlayout
            val layout = binding.questionAnswerDivider5
            // Gets the layout params that will allow you to resize the layout
            val params: ViewGroup.LayoutParams = layout.layoutParams
            if (!result) {
                binding.txtA5.text = getString(R.string.A_selfPaced_05)
                binding.icArrowQ5.setImageResource(R.drawable.ic_arrow_down)
                params.height = (2f).toDips().toInt()
                binding.txtA5.textSize = 16f
                result = true
            } else {
                binding.txtA5.text = ""
                binding.icArrowQ5.setImageResource(R.drawable.ic_arrow_right)
                params.height = (0f).toDips().toInt()
                binding.txtA5.textSize = 0f
                result = false

            }
        }
        binding.question6CardView.setOnClickListener {
            // Gets linearlayout
            val layout = binding.questionAnswerDivider6
            // Gets the layout params that will allow you to resize the layout
            val params: ViewGroup.LayoutParams = layout.layoutParams
            if (!result) {
                binding.txtA6.text = getString(R.string.A_selfPaced_06)
                binding.icArrowQ6.setImageResource(R.drawable.ic_arrow_down)
                params.height = (2f).toDips().toInt()
                binding.txtA6.textSize = 16f
                result = true
            } else {
                binding.txtA6.text = ""
                binding.icArrowQ6.setImageResource(R.drawable.ic_arrow_right)
                params.height = (0f).toDips().toInt()
                binding.txtA6.textSize = 0f
                result = false

            }
        }


        // Toolbar
        setSupportActionBar(binding.toolbarMain)
        binding.collapsingBarMain.setExpandedTitleColor(ContextCompat.getColor(this,android.R.color.transparent))
        binding.collapsingBarMain.title = "Self-Paced Courses"
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    private fun Float.toDips() =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, resources.displayMetrics)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            onBackPressed()
        }
        return true
    }
}