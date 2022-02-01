package com.ieltsjuice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieltsjuice.adapters.SelfPacedAdapter
import com.ieltsjuice.databinding.FragmentSelfPacedSpeakingBinding
import com.ieltsjuice.model.data

class FragmentSelfPacedSpeaking:Fragment() {
    lateinit var binding : FragmentSelfPacedSpeakingBinding
    private lateinit var coursesAdapter:SelfPacedAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelfPacedSpeakingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val courseContent = listOf("Introduction","IELTS Speaking Part 1","IELTS Speaking Part 2","IELTS Speaking Part 3","IELTS Speaking Assessment Criteria","Speaking Practice")
        val adapter = ArrayAdapter(this.requireActivity(),R.layout.drop_down_item,courseContent)
        (binding.dropdownMenu.editText as AutoCompleteTextView).setAdapter(adapter)

        (binding.dropdownMenu.editText as AutoCompleteTextView).addTextChangedListener {
            when (it.toString()){
                "Introduction" -> {
                    coursesAdapter = SelfPacedAdapter(this.requireActivity(),data.speakingIntroduction)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post { binding.scrollView.scrollTo(0, binding.dropdownMenu.y.toInt())}

                }
                "IELTS Speaking Part 1" -> {
                    coursesAdapter = SelfPacedAdapter(this.requireActivity(),data.SpeakingPart1)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post { binding.scrollView.scrollTo(0, binding.dropdownMenu.y.toInt())}

                }
                "IELTS Speaking Part 2" -> {
                    coursesAdapter = SelfPacedAdapter(this.requireActivity(),data.SpeakingPart2)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post { binding.scrollView.scrollTo(0, binding.dropdownMenu.y.toInt())}

                }
                "IELTS Speaking Part 3" -> {
                    coursesAdapter = SelfPacedAdapter(this.requireActivity(),data.SpeakingPart3)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post { binding.scrollView.scrollTo(0, binding.dropdownMenu.y.toInt())}

                }
                "IELTS Speaking Assessment Criteria" -> {
                    coursesAdapter = SelfPacedAdapter(this.requireActivity(),data.SpeakingAssessmentCriteria)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post { binding.scrollView.scrollTo(0, binding.dropdownMenu.y.toInt())}

                }
                "Speaking Practice" -> {
                    coursesAdapter = SelfPacedAdapter(this.requireActivity(),data.SpeakingPractice)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post { binding.scrollView.scrollTo(0, binding.dropdownMenu.y.toInt())}

                }

            }

        }
        val layoutManager = LinearLayoutManager(this.requireActivity())
        binding.courseContentRecyclerView.layoutManager = layoutManager
        binding.courseContentRecyclerView.setHasFixedSize(true)

    }
}