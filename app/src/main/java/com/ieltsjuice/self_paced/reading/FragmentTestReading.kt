package com.ieltsjuice.self_paced.reading

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentTestReadingBinding
import com.ieltsjuice.databinding.TemplateAlertDialogBinding
import com.ieltsjuice.self_paced.speaking.FragmentTestSpeaking
import com.ieltsjuice.self_paced.speaking.KEY_SelfPacedCourseMainTitle

class FragmentTestReading : Fragment() {
    lateinit var binding: FragmentTestReadingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestReadingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            val quizTitle = bundle.getString(KEY_SelfPacedCourseMainTitle)

            bindData(quizTitle!!)


            //set height of a View
            when (quizTitle) {
                "R.1.1 About the reading test - Quiz" -> {
                    // Do Nothing
                }


                "R.1.2 Academic vs. General Training - Quiz" -> {
                    val que3: ViewGroup.LayoutParams = binding.QuestionLayout3.layoutParams
                    que3.height = 0
                    binding.QuestionLayout1.requestLayout()
                }
            }
        }
    }

    //Binding Data
    @SuppressLint("SetTextI18n")
    fun bindData(quizTitle: String) {
        when (quizTitle) {
            "R.1.1 About the reading test - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQueRadioBtn1.text =
                    "1. Do I need to read all 2200 to 2750 words that IELTS gives me for the Reading part?"
                binding.radioGroup1Btn1.text = "yes, from A – Z; we must not miss a word."
                binding.radioGroup1Btn2.text =
                    "no, we need to learn how to read selectively and efficiently."


                binding.txtQueRadioBtn2.text =
                    "2. Which sentence is true of the IELTS Reading part?"
                binding.radioGroup2Btn1.text =
                    "The number of sections is different in the Academic module from the General Training module."
                binding.radioGroup2Btn2.text =
                    "At the end of the test, you will be given time to transfer your answers onto the Reading answer sheet."
                binding.radioGroup2Btn3.text =
                    "You will lose marks if your handwriting is not clear. (IELTS on Paper)"
                binding.radioGroup2Btn4.text =
                    "A typo or a small mistake in your spelling does not affect your mark."


                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup1Btn2.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup2Btn3.isChecked) {
                        score += 1
                    }

                    if (binding.txtQue3InputLayout1.editText?.text.toString() == "3" || binding.txtQue3InputLayout1.editText?.text.toString()
                            .lowercase() == "three"
                    ) {
                        if (binding.txtQue3InputLayout2.editText?.text.toString() == "40" || binding.txtQue3InputLayout2.editText?.text.toString()
                                .lowercase() == "forty"
                        ) {
                            if (binding.txtQue3InputLayout3.editText?.text.toString() == "60" || binding.txtQue3InputLayout3.editText?.text.toString()
                                    .lowercase() == "sixty"
                            ) {
                                if (binding.txtQue3InputLayout4.editText?.text.toString() == "1" || binding.txtQue3InputLayout4.editText?.text.toString()
                                        .lowercase() == "one"
                                ) {
                                    score += 1

                                }
                            }

                        }
                    }
                    dialogActions(quizTitle, score.toString(), "3")
                }
            }

            "R.1.2 Academic vs. General Training - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQuizTitle.text = quizTitle
                binding.txtQueRadioBtn1.text =
                    "1. Is the following statement true?"
                binding.txtQueRadioBtn12.text = "You must have some academic knowledge about the presented topics in the IELTS Reading sections."
                binding.radioGroup1Btn1.text = "yes, you must have a meaningful understanding of social, scientific, and historical topics."
                binding.radioGroup1Btn2.text =
                    "no, only general knowledge of everyday matters is enough."


                binding.txtQueRadioBtn2.text =
                    "2. The difference between Academic and General Training modules in IELTS Reading is that:"
                binding.radioGroup2Btn1.text =
                    "There are more texts in the Academic module than there are in General Training."
                binding.radioGroup2Btn2.text =
                    "The Academic texts are shorter and more complicated than General Training ones."
                binding.radioGroup2Btn3.text =
                    "The General Training texts are easier in content in comparison with the Academic texts."
                binding.radioGroup2Btn4.text =
                    "Their difference is only in the number of words."

                binding.finishQuizBtn.setOnClickListener {
                    var score = 0

                    if (binding.radioGroup1Btn2.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup2Btn3.isChecked) {
                        score += 1
                    }

                    dialogActions(quizTitle, score.toString(), "2")
                }

            }
        }
    }

    //Dialog Action
    @SuppressLint("SetTextI18n")
    private fun dialogActions(quizTitle: String, score: String, questions: String) {
        val dialog = AlertDialog.Builder(this.requireActivity()).create()
        val dialogBinding = TemplateAlertDialogBinding.inflate(layoutInflater)

        dialog.setView(dialogBinding.root)
        dialog.setCancelable(false)
        dialog.create()
        dialog.show()

        dialogBinding.txtScore.text = "$score of $questions answered correctly."
        dialogBinding.restartBtn.setOnClickListener {
            dialog.dismiss()
            val bundle = Bundle()
            bundle.putString(KEY_SelfPacedCourseMainTitle, quizTitle)
            val fragment = FragmentTestSpeaking()
            fragment.arguments = bundle
            val replaceTransaction = parentFragmentManager.beginTransaction()
            replaceTransaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
            replaceTransaction.addToBackStack(null)
            replaceTransaction.commit()
        }
        dialogBinding.CancelBtn.setOnClickListener {
            dialog.dismiss()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.remove(FragmentTestReading())
            transaction.commit()
        }
        dialogBinding.viewAnswersBtn.setOnClickListener {
            dialog.dismiss()
            correctAnswers(quizTitle)

        }
    }

    //Correct Answers
    @SuppressLint("SetTextI18n")
    private fun correctAnswers(quizTitle: String) {
        when (quizTitle) {
            "R.1.1 About the reading test - Quiz" -> {
                binding.radioGroup1Btn2.isChecked = true
                binding.radioGroup1Btn2.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup1Btn1.isEnabled = false


                binding.radioGroup2Btn3.isChecked = true
                binding.radioGroup2Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup2Btn1.isEnabled = false
                binding.radioGroup2Btn2.isEnabled = false
                binding.radioGroup2Btn4.isEnabled = false



                binding.txtQue3InputLayout1.editText?.setText("3 , three")
                binding.txtQue3InputLayout1.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.txtQue3InputLayout2.editText?.setText("40 , forty")
                binding.txtQue3InputLayout2.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.txtQue3InputLayout3.editText?.setText("60 , sixty")
                binding.txtQue3InputLayout3.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.txtQue3InputLayout4.editText?.setText("1 , one")
                binding.txtQue3InputLayout4.editText?.setTextColor(Color.parseColor("#66BB6A"))

            }

            "R.1.2 Academic vs. General Training - Quiz" -> {
                binding.radioGroup1Btn2.isChecked = true
                binding.radioGroup1Btn2.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup1Btn1.isEnabled = false


                binding.radioGroup2Btn3.isChecked = true
                binding.radioGroup2Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup2Btn1.isEnabled = false
                binding.radioGroup2Btn2.isEnabled = false
                binding.radioGroup2Btn4.isEnabled = false


            }
        }

    }


}