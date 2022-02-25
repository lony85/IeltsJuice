package com.ieltsjuice.self_paced.writing

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentTestWritingBinding
import com.ieltsjuice.databinding.TemplateAlertDialogBinding
import com.ieltsjuice.self_paced.speaking.FragmentTestSpeaking
import com.ieltsjuice.self_paced.speaking.KEY_SelfPacedCourseMainTitle

class FragmentTestWriting:Fragment() {
    lateinit var binding: FragmentTestWritingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestWritingBinding.inflate(layoutInflater)
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
                "W.1.1 About the Writing Test - Quiz" -> {
                    val que1: ViewGroup.LayoutParams = binding.QuestionLayout1.layoutParams
                    que1.height = 0
                    binding.QuestionLayout2.requestLayout()
                    val que4: ViewGroup.LayoutParams = binding.QuestionLayout4.layoutParams
                    que4.height = 0
                    binding.QuestionLayout3.requestLayout()
                }


                "W.1.2 Academic vs. General Training - Quiz" -> {

                    val que1: ViewGroup.LayoutParams = binding.QuestionLayout1.layoutParams
                    que1.height = 0
                    binding.QuestionLayout3.requestLayout()
                    val que2: ViewGroup.LayoutParams = binding.QuestionLayout2.layoutParams
                    que2.height = 0
                    binding.QuestionLayout3.requestLayout()
                    val que4: ViewGroup.LayoutParams = binding.QuestionLayout4.layoutParams
                    que4.height = 0
                    binding.QuestionLayout4.requestLayout()

                }

                "W.1.3 Classic or Contemporary Formatting? - Quiz" -> {
                    val que3: ViewGroup.LayoutParams = binding.QuestionLayout3.layoutParams
                    que3.height = 0
                    binding.QuestionLayout3.requestLayout()
                    val que2: ViewGroup.LayoutParams = binding.QuestionLayout2.layoutParams
                    que2.height = 0
                    binding.QuestionLayout4.requestLayout()

                }

                "W.1.4 Pen or Pencil? - Quiz" -> {
                    val que1: ViewGroup.LayoutParams = binding.QuestionLayout1.layoutParams
                    que1.height = 0
                    binding.QuestionLayout3.requestLayout()
                    val que2: ViewGroup.LayoutParams = binding.QuestionLayout2.layoutParams
                    que2.height = 0
                    binding.QuestionLayout3.requestLayout()
                    val que4: ViewGroup.LayoutParams = binding.QuestionLayout4.layoutParams
                    que4.height = 0
                    binding.QuestionLayout4.requestLayout()

                }

            }

        }
    }

    //Binding Data
    @SuppressLint("SetTextI18n")
    fun bindData(quizTitle: String) {
        when (quizTitle) {

            "W.1.1 About the Writing Test - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle


                binding.txtQueRadioBtn2.text =
                    "1. Match the different skill types to their definitions:"
                binding.txtQueRadioBtn21.text =
                    "The skills in which do not need to produce the language, but they receive and understand it.they are also known as passive skills."
                binding.txtQueRadioBtn22.text =
                    "The skills in which learners must produce the language. They are also known as active skills."


                binding.txtQueRadioBtn3.text = "2. Which are the two “productive skills” at IELTS?"
                binding.radioGroup3Btn1.text = "Writing and Reading"
                binding.radioGroup3Btn2.text = "Writing and Listening"
                binding.radioGroup3Btn3.text = "Speaking and Writing"
                binding.radioGroup3Btn4.text = "Speaking and Reading"


                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup3Btn3.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup2Btn1.isChecked && binding.radioGroup2Btn4.isChecked) {
                        score += 1
                    }


                    dialogActions(quizTitle, score.toString(), "2")
                }
            }

            "W.1.2 Academic vs. General Training - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle

                binding.txtQueRadioBtn3.text = "1. Which sentence is completely True about the IELTS Writing Module?"
                binding.radioGroup3Btn1.text = "IELTS Writing is the same for both General Training and Academic modules."
                binding.radioGroup3Btn2.text = "In the General Training module, you are expected to write a letter and a report."
                binding.radioGroup3Btn3.text = "In the Academic module, you are expected to write a letter and an essay."
                binding.radioGroup3Btn4.text = "There are two tasks, and task 2 is the same in both General Training and Academic modules."


                binding.finishQuizBtn.setOnClickListener {
                    var score = 0


                    if (binding.radioGroup3Btn4.isChecked) {
                        score += 1
                    }

                    dialogActions(quizTitle, score.toString(), "1")


                }

            }

            "W.1.3 Classic or Contemporary Formatting? - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle


                binding.txtQueRadioBtn1.text =
                    "1. Which paragraph style is preferable for IELTS Writing tasks?"
                binding.radioGroup1Btn1.text ="Contemporary style"
                binding.radioGroup1Btn2.text = "Classic style"
                binding.radioGroup1Btn3.text ="both styles"


                binding.txtQuestionLayout4.text ="2. Fill the gap. Write no more than ONE WORD or A NUMBER in each gap:"
                binding.txtFillTheGap.text = "Paragraphing using the ___ style is more suitable for handwritten texts. Because it makes paragraphing clearer. What’s more, unlike the ___ style, it saves more space, and you don’t need to ask for an extra answer sheet during the exam."


                binding.finishQuizBtn.setOnClickListener {
                    var score = 0

                    if(binding.radioGroup1Btn3.isChecked){
                        score += 1
                    }
                    if (binding.txtQue4InputLayout1.editText?.text.toString().lowercase() == "classic" && binding.txtQue4InputLayout2.editText?.text.toString().lowercase() == "contemporary" ) {
                        score += 1
                    }


                    dialogActions(quizTitle, score.toString(), "2")


                }
            }

            "W.1.4 Pen or Pencil? - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle

                binding.txtQueRadioBtn3.text = "1. How should we use the stationery when there is an error in our writing?"
                binding.radioGroup3Btn1.text = "Erase the wrong word; then, write the correct version."
                binding.radioGroup3Btn2.text = "Use your pencil and cross the wrong word out in a way that the examiner cannot see the wrong word; then, write the correct version on top of it."
                binding.radioGroup3Btn3.text = "Use your pencil and cross the wrong word out; then, write the correct version on top of it."
                binding.radioGroup3Btn4.text = "Use your pen instead."


                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup3Btn3.isChecked) {
                        score += 1
                    }
                        dialogActions(quizTitle, score.toString(), "1")
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
            transaction.remove(FragmentTestWriting())
            transaction.commit()
        }
        dialogBinding.viewAnswersBtn.setOnClickListener {
            dialog.dismiss()
            correctAnswers(quizTitle)

        }
    }

    @SuppressLint("SetTextI18n")
    private fun correctAnswers(quizTitle: String) {
        when (quizTitle) {
            "W.1.1 About the Writing Test - Quiz" -> {
                binding.radioGroup3Btn3.isChecked = true
                binding.radioGroup3Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup3Btn1.isEnabled = false
                binding.radioGroup3Btn2.isEnabled = false
                binding.radioGroup3Btn4.isEnabled = false


                binding.radioGroup2Btn1.isChecked = true
                binding.radioGroup2Btn1.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup2Btn2.isEnabled = false

                binding.radioGroup2Btn4.isChecked = true
                binding.radioGroup2Btn4.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup2Btn3.isEnabled = false

                    }

            "W.1.2 Academic vs. General Training - Quiz" -> {
                binding.radioGroup3Btn4.isChecked = true
                binding.radioGroup3Btn4.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup3Btn1.isEnabled = false
                binding.radioGroup3Btn2.isEnabled = false
                binding.radioGroup3Btn3.isEnabled = false


            }


            "W.1.3 Classic or Contemporary Formatting? - Quiz" -> {
                binding.radioGroup1Btn3.isChecked = true
                binding.radioGroup1Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup1Btn2.isChecked = false
                binding.radioGroup1Btn1.isChecked = false

                binding.txtQue4InputLayout1.editText?.setText("classic")
                binding.txtQue4InputLayout1.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtQue4InputLayout2.editText?.setText("contemporary")
                binding.txtQue4InputLayout2.editText?.setTextColor(Color.parseColor("#66BB6A"))


            }

            "W.1.4 Pen or Pencil? - Quiz" -> {
                binding.radioGroup3Btn3.isChecked = true
                binding.radioGroup3Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup3Btn1.isEnabled = false
                binding.radioGroup3Btn2.isEnabled = false
                binding.radioGroup3Btn4.isEnabled = false


            }

        }

    }


}