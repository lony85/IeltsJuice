package com.ieltsjuice.self_paced.listening

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
import com.ieltsjuice.databinding.FragmentSelfPacedListeningBinding
import com.ieltsjuice.databinding.TemplateRegisterAlertDialogBinding
import com.ieltsjuice.model.Data
import com.ieltsjuice.model.SelfPacedCourses
import com.ieltsjuice.self_paced.FragmentSelfPacedCourseDetail
import com.ieltsjuice.self_paced.speaking.KEY_SelfPacedCourseMainTitle

class FragmentSelfPacedListening : Fragment(), SelfPacedAdapter.ViewSelected {

    lateinit var binding: FragmentSelfPacedListeningBinding
    private lateinit var coursesAdapter: SelfPacedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelfPacedListeningBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSpeakingCourseRegister.setOnClickListener {
            val dialog = AlertDialog.Builder(this.requireActivity()).create()
            val dialogBinding = TemplateRegisterAlertDialogBinding.inflate(layoutInflater)

            dialog.setView(dialogBinding.root)
            dialog.setCancelable(false)
            dialog.create()
            dialog.show()

            dialogBinding.registerBtn.setOnClickListener {
                dialog.dismiss()
                val webUri =
                    Uri.parse("https://ieltsjuice.com/services/ielts-listening-self-paced-course/")
                val iWeb = Intent(Intent.ACTION_VIEW, webUri)
                iWeb.setPackage("com.android.chrome")
                try {
                    startActivity(iWeb)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://ieltsjuice.com/services/ielts-listening-self-paced-course/")
                        )
                    )
                }
            }

            dialogBinding.CancelBtn.setOnClickListener {
                dialog.dismiss()
            }
        }

        binding.buttonListeningCourseRegisterIRAN.setOnClickListener {
            val webUri = Uri.parse("https://forush.co/18756/133280/")
            val iWeb = Intent(Intent.ACTION_VIEW, webUri)
            iWeb.setPackage("com.android.chrome")
            try {
                startActivity(iWeb)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://forush.co/18756/133280/")
                    )
                )
            }
        }


        //Choose Courses Content
        val courseContent = listOf(
            "Introduction",
            "Vocabulary for Listening",
            "The Art of Prediction",
            "Spelling",
            "Listening Part 1",
            "Listening Part 2",
            "Listening Part 3",
            "Listening Part 4",
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
                        SelfPacedAdapter(this.requireActivity(), Data.ListeningIntroduction,this)
                    binding.courseContentRecyclerView.adapter = coursesAdapter
                    binding.scrollView.post {
                        binding.scrollView.scrollTo(
                            0,
                            binding.dropdownMenu.y.toInt()
                        )
                    }

                }
                "Vocabulary For Listening" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.VocabularyForListening, this)

                }
                "The Art Of Prediction" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.TheArtOfPrediction, this)
                }
                "Spelling" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.Spelling, this)
                }
                "Listening Part 1" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter = SelfPacedAdapter(
                        this.requireActivity(),
                        Data.ListeningPart1,
                        this
                    )
                }
                "Listening Part 2" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.ListeningPart2, this)
                }
                "Listening Part 3" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.ListeningPart3, this)
                }
                "Listening Part 4" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.ListeningPart4, this)
                }
                "Final Tips" -> {
                    //set height of RecyclerView Container
                    val lp: ViewGroup.LayoutParams = binding.frameViewRecyclerView.layoutParams
                    lp.height = 1000
                    binding.frameViewRecyclerView.requestLayout()

                    coursesAdapter =
                        SelfPacedAdapter(this.requireActivity(), Data.FinalTips, this)
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
                "1.1 About the Listening Test" -> {
                    course("1.1 About the Listening Test")
                }
                "1.2 The Listening Test Layout" -> {
                    course("1.2 The Listening Test Layout")
                }

                "1.3 English Accents" -> {
                    course("1.3 English Accents")
                }
                "1.4 Features of the Australian Accent" -> {
                    course("1.4 Features of the Australian Accent")
                }
                "1.5 Listening Question Types" -> {
                    course("1.5 Listening Question Types")
                }

                "L.1.1.About the Listening Test - Quiz" -> {
                    quiz("L.1.1.About the Listening Test - Quiz")
                }
                "L.1.2 The Listening Test Layout - Quiz" -> {
                    quiz("L.1.2 The Listening Test Layout - Quiz")
                }

                "L.1.3 English Accents - Quiz" -> {
                    quiz("L.1.3 English Accents - Quiz")
                }

                "L.1.4 Features of the Australian Accent - Quiz" -> {
                    quiz("L.1.4 Features of the Australian Accent - Quiz")
                }
                "L.1.5 Listening Question Types - Quiz" -> {
                    quiz("L.1.5 Listening Question Types - Quiz")
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
        val fragment = FragmentTestListening()
        fragment.arguments = bundle

        val replaceTransaction = parentFragmentManager.beginTransaction()
        replaceTransaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
        replaceTransaction.addToBackStack(null)
        replaceTransaction.commit()
    }
}