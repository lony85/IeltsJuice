package com.ieltsjuice.self_paced.reading

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
import com.ieltsjuice.databinding.FragmentSelfPacedReadingBinding
import com.ieltsjuice.databinding.TemplateRegisterAlertDialogBinding
import com.ieltsjuice.model.Data
import com.ieltsjuice.model.SelfPacedCourses
import com.ieltsjuice.self_paced.FragmentSelfPacedCourseDetail
import com.ieltsjuice.self_paced.speaking.KEY_SelfPacedCourseMainTitle

class FragmentSelfPacedReading:Fragment() , SelfPacedAdapter.ViewSelected {

    lateinit var binding: FragmentSelfPacedReadingBinding
    private lateinit var coursesAdapter: SelfPacedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelfPacedReadingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonReadingCourseRegister.setOnClickListener {
            val dialog = AlertDialog.Builder(this.requireActivity()).create()
            val dialogBinding = TemplateRegisterAlertDialogBinding.inflate(layoutInflater)

            dialog.setView(dialogBinding.root)
            dialog.setCancelable(false)
            dialog.create()
            dialog.show()

            dialogBinding.registerBtn.setOnClickListener {
                dialog.dismiss()
                val webUri =
                    Uri.parse("https://ieltsjuice.com/services/ielts-reading-self-paced-course/")
                val iWeb = Intent(Intent.ACTION_VIEW, webUri)
                iWeb.setPackage("com.android.chrome")
                try {
                    startActivity(iWeb)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://ieltsjuice.com/services/ielts-reading-self-paced-course/")
                        )
                    )
                }
            }

            dialogBinding.CancelBtn.setOnClickListener {
                dialog.dismiss()
            }
        }

        binding.buttonReadingCourseRegisterIRAN.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/18757/769507/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/18757/769507/")
                    )
                )
            }
        }

        //Choose Courses Content
        val courseContent = listOf(
            "Introduction",
            "Vocabulary and Grammar",
            "Reading Skills",
            "Different IELTS Reading Question Types",
            "How to Answer Golden Questions",
            "How to Answer Silver Questions",
            "How to Answer Iron Questions",
            "Final Tips"
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
                        SelfPacedAdapter(this.requireActivity(), Data.ReadingIntroduction, this)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post {
                        binding.scrollView.scrollTo(
                            0,
                            binding.dropdownMenu.y.toInt()
                        )
                    }

                }
                "Vocabulary and Grammar" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.VocabularyAndGrammar, this)

                }
                "Reading Skills" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.ReadingSkills, this)
                }
                "Different IELTS Reading Question Types" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.DifferentIELTSReadingQuestionTypes, this)
                }
                "How to Answer Golden Questions" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter = SelfPacedAdapter(
                        this.requireActivity(),
                        Data.HowToAnswerGoldenQuestions,
                        this
                    )
                }
                "How to Answer Silver Questions" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.HowToAnswerSilverQuestions, this)
                }
                "How to Answer Iron Questions" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.HowToAnswerIronQuestions, this)
                }
                "Final Tips" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.ReadingFinalTips, this)
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

    //implement "selected view" fun that are coming from SelfPacedAdapter
    override fun selectedView(Course: SelfPacedCourses, position: Int) {
        if (binding.dropdownMenu.editText!!.text.toString() == "Introduction") {

            val bundle = Bundle()
            bundle.putString(KEY_SelfPacedCourseMainTitle, Course.Title)
            when (Course.Title) {
                "1.1 What’s IELTS reading test like? (About the reading test)" -> {
                    course("1.1 What’s IELTS reading test like? (About the reading test)")
                }
                "1.2 What’s the difference between the reading module in academic IELTS and general training IELTS" -> {
                    course("1.2 What’s the difference between the reading module in academic IELTS and general training IELTS")
                }
                "R.1.1 About the reading test - Quiz" -> {
                    quiz("R.1.1 About the reading test - Quiz")
                }
                "R.1.2 Academic vs. General Training - Quiz" -> {
                    quiz("R.1.2 Academic vs. General Training - Quiz")
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
        val fragment = FragmentTestReading()
        fragment.arguments = bundle

        val replaceTransaction = parentFragmentManager.beginTransaction()
        replaceTransaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
        replaceTransaction.addToBackStack(null)
        replaceTransaction.commit()
    }
}
