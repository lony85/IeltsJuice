package com.ieltsjuice.self_paced.writing

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieltsjuice.R
import com.ieltsjuice.adapters.SelfPacedAdapter
import com.ieltsjuice.databinding.FragmentSelfPacedWritingBinding
import com.ieltsjuice.databinding.TemplateRegisterAlertDialogBinding
import com.ieltsjuice.model.Data
import com.ieltsjuice.model.SelfPacedCourses
import com.ieltsjuice.self_paced.FragmentSelfPacedCourseDetail
import com.ieltsjuice.self_paced.speaking.KEY_SelfPacedCourseMainTitle

class FragmentSelfPacedWriting :Fragment(), SelfPacedAdapter.ViewSelected {
    lateinit var binding: FragmentSelfPacedWritingBinding
    private lateinit var coursesAdapter: SelfPacedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelfPacedWritingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonWritingCourseRegister.setOnClickListener {
            val dialog = AlertDialog.Builder(this.requireActivity()).create()
            val dialogBinding = TemplateRegisterAlertDialogBinding.inflate(layoutInflater)

            dialog.setView(dialogBinding.root)
            dialog.setCancelable(false)
            dialog.create()
            dialog.show()

            dialogBinding.registerBtn.setOnClickListener {
                dialog.dismiss()
                val webUri =
                    Uri.parse("https://ieltsjuice.com/services/ielts-writing-self-paced-course/")
                val iWeb = Intent(Intent.ACTION_VIEW, webUri)
                iWeb.setPackage("com.android.chrome")
                try {
                    startActivity(iWeb)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://ieltsjuice.com/services/ielts-writing-self-paced-course/")
                        )
                    )
                }

            }
            dialogBinding.CancelBtn.setOnClickListener {
                dialog.dismiss()
            }
        }

        binding.buttonWritingCourseRegisterIRAN.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/18773/583490/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/18773/583490/")
                    )
                )
            }
        }


        //Choose Courses Content
        val courseContent = listOf(
            "Introduction",
            "IELTS Language",
            "Stages of Writing",
            "Paragraph Structure",
            "Essay Writing (Task 2)",
            "Letter Writing (General Training Task 1)",
            "Report Writing (Academic Task 1)",
            "Writing Assessment Criteria"

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
                        SelfPacedAdapter(this.requireActivity(), Data.WritingIntroduction, this)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post {
                        binding.scrollView.scrollTo(
                            0,
                            binding.dropdownMenu.y.toInt()
                        )
                    }

                }
                "IELTS Language" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.IELTSLanguage, this)

                }
                "Stages of Writing" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.StagesOfWriting, this)
                }
                "Paragraph Structure" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.ParagraphStructure, this)
                }
                "Essay Writing (Task 2)" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter = SelfPacedAdapter(
                        this.requireActivity(),
                        Data.EssayWritingTask2,
                        this
                    )
                }
                "Letter Writing (General Training Task 1)" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.LetterWritingGeneralTrainingTask1, this)
                }
                "Report Writing (Academic Task 1)" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.ReportWritingAcademicTask1, this)
                }
                "Writing Assessment Criteria" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.WritingAssessmentCriteria, this)
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
            bundle.putString(KEY_SelfPacedCourseMainTitle, Course.Title)
            when (Course.Title) {
                "1.1 About the Writing Test" -> {
                    course("1.1 About the Writing Test")
                }
                "1.2 Academic vs. General Training" -> {
                    course("1.2 Academic vs. General Training")
                }

                "1.3 Classic or Contemporary Formatting?" -> {
                    course("1.3 Classic or Contemporary Formatting?")
                }
                "1.4 Pen or Pencil?" -> {
                    course("1.4 Pen or Pencil?")
                }
                "W.1.1 About the Writing Test - Quiz" -> {
                    quiz("W.1.1 About the Writing Test - Quiz")
                }
                "W.1.2 Academic vs. General Training - Quiz" -> {
                    quiz("W.1.2 Academic vs. General Training - Quiz")
                }

                "W.1.3 Classic or Contemporary Formatting? - Quiz" -> {
                    quiz("W.1.3 Classic or Contemporary Formatting? - Quiz")
                }

                "W.1.4 Pen or Pencil? - Quiz" -> {
                    quiz("W.1.4 Pen or Pencil? - Quiz")
                }
            }
        }
    }

    //If user choose Course from drop down menu
    fun course(Course: String) {
        val bundle = Bundle()
        bundle.putString(KEY_SelfPacedCourseMainTitle, Course)
        val fragment = FragmentSelfPacedCourseDetail()
        fragment.arguments = bundle

        val replaceTransaction = parentFragmentManager.beginTransaction()
        replaceTransaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
        replaceTransaction.addToBackStack(null)
        replaceTransaction.commit()
    }

    //If user choose Quiz from drop down menu
    private fun quiz(quiz: String) {
        val bundle = Bundle()
        bundle.putString(KEY_SelfPacedCourseMainTitle, quiz)
        val fragment = FragmentTestWriting()
        fragment.arguments = bundle

        val replaceTransaction = parentFragmentManager.beginTransaction()
        replaceTransaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
        replaceTransaction.addToBackStack(null)
        replaceTransaction.commit()
    }
}

