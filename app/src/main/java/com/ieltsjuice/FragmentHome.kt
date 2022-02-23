package com.ieltsjuice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.databinding.FragmentHomeBinding

const val PAGE_NAME_KEY = "PAGE_NAME_KEY"

class FragmentHome : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonConsultation.setOnClickListener {
            val intent = Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY,"Consultation")
            startActivity(intent)
        }
        binding.buttonMainCorrection.setOnClickListener {
            val intent = Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY,"Correction")
            startActivity(intent)
        }
        binding.buttonMainCourses.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, FragmentOnlineCourses())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.buttonMainScoreCalculator.setOnClickListener {
            val intent =
                Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY, "calculator")
            startActivity(intent)
        }
    }
}