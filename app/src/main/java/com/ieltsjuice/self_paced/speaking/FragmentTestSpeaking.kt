package com.ieltsjuice.self_paced.speaking

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentTestSpeakingBinding
import com.ieltsjuice.databinding.TemplateAlertDialogBinding

class FragmentTestSpeaking : Fragment() {
    lateinit var binding: FragmentTestSpeakingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestSpeakingBinding.inflate(layoutInflater, container, false)
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
                "S.1.1 The Speaking Test Layout - Quiz" -> {
                    val que7: ViewGroup.LayoutParams = binding.QuestionLayout7.layoutParams
                    que7.height = 0
                    binding.QuestionLayout7.requestLayout()
                }


                "S.1.2 Model Speaking Part 1 - Quiz" -> {
                    val que1: ViewGroup.LayoutParams = binding.QuestionLayout1.layoutParams
                    que1.height = 0
                    binding.QuestionLayout1.requestLayout()
                    val que2: ViewGroup.LayoutParams = binding.QuestionLayout2.layoutParams
                    que2.height = 0
                    binding.QuestionLayout2.requestLayout()
                    val que3: ViewGroup.LayoutParams = binding.QuestionLayout3.layoutParams
                    que3.height = 0
                    binding.QuestionLayout3.requestLayout()
                    val que4: ViewGroup.LayoutParams = binding.QuestionLayout4.layoutParams
                    que4.height = 0
                    binding.QuestionLayout4.requestLayout()
                    val que5: ViewGroup.LayoutParams = binding.QuestionLayout5.layoutParams
                    que5.height = 0
                    binding.QuestionLayout5.requestLayout()
                    val que6: ViewGroup.LayoutParams = binding.QuestionLayout6.layoutParams
                    que6.height = 0
                    binding.QuestionLayout6.requestLayout()


                }

                "S.1.3 Model Speaking Part 2 - Quiz" -> {
                    val que4: ViewGroup.LayoutParams = binding.QuestionLayout4.layoutParams
                    que4.height = 0
                    binding.QuestionLayout4.requestLayout()
                    val que5: ViewGroup.LayoutParams = binding.QuestionLayout5.layoutParams
                    que5.height = 0
                    binding.QuestionLayout5.requestLayout()
                    val que6: ViewGroup.LayoutParams = binding.QuestionLayout6.layoutParams
                    que6.height = 0
                    binding.QuestionLayout6.requestLayout()
                    val que7: ViewGroup.LayoutParams = binding.QuestionLayout7.layoutParams
                    que7.height = 0
                    binding.QuestionLayout7.requestLayout()
                }

                "S.1.4 Model Speaking Part 3 - Quiz" -> {
                    val que3: ViewGroup.LayoutParams = binding.QuestionLayout3.layoutParams
                    que3.height = 0
                    binding.QuestionLayout3.requestLayout()
                    val que4: ViewGroup.LayoutParams = binding.QuestionLayout4.layoutParams
                    que4.height = 0
                    binding.QuestionLayout4.requestLayout()
                    val que5: ViewGroup.LayoutParams = binding.QuestionLayout5.layoutParams
                    que5.height = 0
                    binding.QuestionLayout5.requestLayout()
                    val que6: ViewGroup.LayoutParams = binding.QuestionLayout6.layoutParams
                    que6.height = 0
                    binding.QuestionLayout6.requestLayout()
                    val que7: ViewGroup.LayoutParams = binding.QuestionLayout7.layoutParams
                    que7.height = 0
                    binding.QuestionLayout7.requestLayout()
                }

            }

        }
    }

    @SuppressLint("SetTextI18n")
    fun bindData(quizTitle: String) {
        when (quizTitle) {
            "S.1.1 The Speaking Test Layout - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQueRadioBtn1.text =
                    "1. Is the Speaking exam different for Academic and General Training Modules?"
                binding.txtQueRadioBtn2.text =
                    "2. Can the Speaking session be held on the written exam day?"
                binding.txtQueRadioBtn3.text =
                    "3. Which English accent is used during the Speaking session?"
                binding.radioGroup3Btn1.text = "Modern Standard British English"
                binding.radioGroup3Btn2.text = " North American English"
                binding.radioGroup3Btn3.text = "Australian and British English"
                binding.radioGroup3Btn4.text = "Accents may vary"
                binding.txtFillTheGap.text =
                    "The Speaking test is ___ and is close to a real-life situation which means you will talk to a certified IELTS examiner face to face and answer the questions."
                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup1Btn2.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup2Btn1.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup3Btn4.isChecked) {
                        score += 1
                    }
                    if (binding.txtInputLayout.editText?.text.toString()
                            .lowercase() == "interactive"
                    ) {
                        score += 1
                    }

                    if (binding.txtLayoutOrder1.editText?.text.toString() == "2" && binding.txtLayoutOrder2.editText?.text.toString() == "1" && binding.txtLayoutOrder3.editText?.text.toString() == "3") {
                        score += 1
                    }
                    if (binding.radioGroup7Btn1.isChecked) {
                        score += 1
                    }

                    dialogActions(quizTitle, score.toString(), "6")
                }
            }

            "S.1.2 Model Speaking Part 1 - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.finishQuizBtn.setOnClickListener {
                    var score = 0


                    if (binding.txtLayoutQue7Order1.editText?.text.toString() == "2" && binding.txtLayoutQue7Order2.editText?.text.toString() == "4" && binding.txtLayoutQue7Order3.editText?.text.toString() == "3" && binding.txtLayoutQue7Order4.editText?.text.toString() == "1" && binding.txtLayoutQue7Order5.editText?.text.toString() == "6" && binding.txtLayoutQue7Order6.editText?.text.toString() == "5") {
                        score += 1
                    }

                    dialogActions(quizTitle, score.toString(), "1")


                }

            }

            "S.1.3 Model Speaking Part 2 - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQueRadioBtn1.text =
                    "1. Should you be worried if the examiner stops you in part 2?"
                binding.txtQueRadioBtn2.text =
                    "2. Can the examiner ask you a few questions when your 2-minute speaking is over?"
                binding.txtQueRadioBtn3.text =
                    "3. Which statement is true about IELTS Speaking part 2?"
                binding.radioGroup3Btn1.text =
                    "You can take the question card, the one which the examiner gives you, out of the session."
                binding.radioGroup3Btn2.text =
                    "You must answer all the questions by writing them first on the paper."
                binding.radioGroup3Btn3.text =
                    "You do not need to carry a pen or pencil to the session. The examiner will give you one."
                binding.radioGroup3Btn4.text =
                    "The examiner sometimes asks questions in the middle of your 2-minute talk."



                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup1Btn2.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup2Btn1.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup3Btn3.isChecked) {
                        score += 1
                    }

                    dialogActions(quizTitle, score.toString(), "3")


                }
            }

            "S.1.4 Model Speaking Part 3 - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQueRadioBtn1.text =
                    "1. Can you ask the examiner what he/she thinks about the topic?"
                binding.txtQueRadioBtn2.text =
                    "2. Can the examiner ask you to explain more about your opinion?"

                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup1Btn2.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup2Btn1.isChecked) {
                        score += 1
                    }


                    dialogActions(quizTitle, score.toString(), "2")


                }
            }

        }
    }

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
            transaction.remove(FragmentTestSpeaking())
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
            "S.1.1 The Speaking Test Layout - Quiz" -> {
                binding.radioGroup1Btn2.isChecked = true
                binding.radioGroup1Btn2.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup1Btn1.isEnabled = false


                binding.radioGroup2Btn1.isChecked = true
                binding.radioGroup2Btn1.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup2Btn2.isEnabled = false

                binding.radioGroup3Btn4.isChecked = true
                binding.radioGroup3Btn4.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup3Btn1.isEnabled = false
                binding.radioGroup3Btn2.isEnabled = false
                binding.radioGroup3Btn3.isEnabled = false

                binding.txtInputLayout.editText?.setText("interactive")
                binding.txtInputLayout.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.txtLayoutOrder1.editText?.setText("2")
                binding.txtLayoutOrder1.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.txtLayoutOrder2.editText?.setText("1")
                binding.txtLayoutOrder2.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.txtLayoutOrder3.editText?.setText("3")
                binding.txtLayoutOrder3.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.radioGroup7Btn1.isChecked = true
                binding.radioGroup7Btn1.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup7Btn2.isEnabled = false
                binding.radioGroup7Btn3.isEnabled = false


            }

            "S.1.2 Model Speaking Part 1 - Quiz" -> {
                binding.txtLayoutQue7Order1.editText?.setText("2")
                binding.txtLayoutQue7Order1.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue7Order2.editText?.setText("4")
                binding.txtLayoutQue7Order2.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue7Order3.editText?.setText("3")
                binding.txtLayoutQue7Order3.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue7Order4.editText?.setText("1")
                binding.txtLayoutQue7Order4.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue7Order5.editText?.setText("6")
                binding.txtLayoutQue7Order5.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue7Order6.editText?.setText("5")
                binding.txtLayoutQue7Order6.editText?.setTextColor(Color.parseColor("#66BB6A"))


            }


            "S.1.3 Model Speaking Part 2 - Quiz" -> {
                binding.radioGroup1Btn2.isChecked = true
                binding.radioGroup1Btn2.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup1Btn1.isEnabled = false

                binding.radioGroup2Btn1.isChecked = true
                binding.radioGroup2Btn1.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup2Btn2.isEnabled = false

                binding.radioGroup3Btn3.isChecked = true
                binding.radioGroup3Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup3Btn1.isEnabled = false
                binding.radioGroup3Btn2.isEnabled = false
                binding.radioGroup3Btn4.isEnabled = false


            }

            "S.1.4 Model Speaking Part 3 - Quiz" -> {
                binding.radioGroup1Btn2.isChecked = true
                binding.radioGroup1Btn2.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup1Btn1.isEnabled = false

                binding.radioGroup2Btn1.isChecked = true
                binding.radioGroup2Btn1.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup2Btn2.isEnabled = false

            }

        }

    }


}