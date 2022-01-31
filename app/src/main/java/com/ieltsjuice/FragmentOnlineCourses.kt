package com.ieltsjuice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.databinding.FragmentOnlineCourcesBinding

class FragmentOnlineCourses:Fragment() {
    lateinit var binding : FragmentOnlineCourcesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnlineCourcesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonConsultation.setOnClickListener {
            val intent = Intent(this.requireActivity(), ConsultationActivity::class.java)
            startActivity(intent)
        }
        binding.buttonMainCoursesOnetoOne.setOnClickListener{
            val intent = Intent(this.requireActivity(),OneToOneActivity::class.java)
            startActivity(intent)
        }
        binding.buttonMainCoursesSelfPaced.setOnClickListener{
            val intent = Intent(this.requireActivity(), SelfPacedActivity::class.java)
            startActivity(intent)
        }
    }
}