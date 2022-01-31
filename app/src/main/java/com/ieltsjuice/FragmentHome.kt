package com.ieltsjuice

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.adapters.AboutUsRecyclerAdapter
import com.ieltsjuice.databinding.FragmentHomeBinding
import com.ieltsjuice.model.data

class FragmentHome : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonConsultation.setOnClickListener {
            val intent = Intent(this.requireActivity(), ConsultationActivity::class.java)
            startActivity(intent)
        }
        binding.buttonMainCorrection.setOnClickListener {
            val intent = Intent(this.requireActivity(), CorrectionActivity::class.java)
            startActivity(intent)
        }
        binding.buttonMainCourses.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,FragmentOnlineCourses())
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

}