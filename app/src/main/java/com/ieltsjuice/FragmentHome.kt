package com.ieltsjuice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ieltsjuice.databinding.FragmentHomeBinding
import com.ieltsjuice.util.PAGE_NAME_KEY


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
            findNavController().navigate(R.id.navigation_studyOnline)

        }
        binding.buttonMainScoreCalculator.setOnClickListener {
            val intent =
                Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY, "calculator")
            startActivity(intent)
        }
    }
  }