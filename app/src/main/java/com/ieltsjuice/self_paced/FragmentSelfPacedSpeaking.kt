package com.ieltsjuice.self_paced

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieltsjuice.R
import com.ieltsjuice.adapters.SelfPacedAdapter
import com.ieltsjuice.databinding.FragmentSelfPacedSpeakingBinding
import com.ieltsjuice.model.Data
import com.ieltsjuice.model.SelfPacedCourses

const val KEY_SelfPacedCourseTitle = "KEY_SelfPacedCourseTitle"

class FragmentSelfPacedSpeaking : Fragment(), SelfPacedAdapter.ViewSelected {
    lateinit var binding: FragmentSelfPacedSpeakingBinding
    private lateinit var coursesAdapter: SelfPacedAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelfPacedSpeakingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //toolBar Name

        binding.buttonSpeakingCourseRegister.setOnClickListener {
            val webUri =
                Uri.parse("https://ieltsjuice.com/services/ielts-speaking-self-paced-course/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ieltsjuice.com/services/ielts-speaking-self-paced-course/")
                    )
                )
            }
        }
        binding.buttonSpeakingCourseRegisterIRAN.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/18774/918823/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/18774/918823/")
                    )
                )
            }
        }


        //Choose Courses Content
        val courseContent = listOf(
            "Introduction",
            "IELTS Speaking Part 1",
            "IELTS Speaking Part 2",
            "IELTS Speaking Part 3",
            "IELTS Speaking Assessment Criteria",
            "Speaking Practice"
        )

        val adapter = ArrayAdapter(this.requireActivity(), R.layout.drop_down_item, courseContent)

        (binding.dropdownMenu.editText as AutoCompleteTextView).setAdapter(adapter)

        (binding.dropdownMenu.editText as AutoCompleteTextView).addTextChangedListener {
            when (it.toString()) {
                "Introduction" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.speakingIntroduction, this)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post {
                        binding.scrollView.scrollTo(
                            0,
                            binding.dropdownMenu.y.toInt()
                        )
                    }

                }
                "IELTS Speaking Part 1" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.SpeakingPart1, this)

                }
                "IELTS Speaking Part 2" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.SpeakingPart2, this)
                }
                "IELTS Speaking Part 3" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.SpeakingPart3, this)
                }
                "IELTS Speaking Assessment Criteria" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter = SelfPacedAdapter(
                        this.requireActivity(),
                        Data.SpeakingAssessmentCriteria,
                        this
                    )
                }
                "Speaking Practice" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.SpeakingPractice, this)
                }
            }
            binding.courseContentRecyclerView.adapter = coursesAdapter
            binding.scrollView.post {
                binding.scrollView.scrollTo(
                    0,
                    binding.dropdownMenu.y.toInt()
                )
            }
        }
        val layoutManager = LinearLayoutManager(this.requireActivity())
        binding.courseContentRecyclerView.layoutManager = layoutManager
        binding.courseContentRecyclerView.setHasFixedSize(true)

    }

    override fun selectedView(Course: SelfPacedCourses, position: Int) {
        if (binding.dropdownMenu.editText!!.text.toString() == "Introduction") {
            val bundle = Bundle()
            bundle.putString(KEY_SelfPacedCourseTitle, Course.Title)

            val fragment = FragmentSelfPacedCourseDetail()
            fragment.arguments = bundle

            val replaceTransaction = parentFragmentManager.beginTransaction()
            replaceTransaction.replace(R.id.frameLayout_SelfPaced, fragment)
            replaceTransaction.addToBackStack(null)
            replaceTransaction.commit()
        }
    }

}