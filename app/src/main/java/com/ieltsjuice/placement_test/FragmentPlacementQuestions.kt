package com.ieltsjuice.placement_test

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentPlacementQuestionsBinding
import com.ieltsjuice.model.PlacementTestQuestions
import com.ieltsjuice.model.Question


const val KEY_testResult = "KEY_testResult"

class FragmentPlacementQuestions : Fragment() {
    lateinit var binding: FragmentPlacementQuestionsBinding
    private var score: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private val imageURL = "https://ieltsjuice.com/wp-content/uploads/app/opt/img_test_"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlacementQuestionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //making question list
        mQuestionsList = PlacementTestQuestions.getQuestions()

        //First Init
        var currentPosition = 1
        var questionNumber = currentPosition - 1


        //First Data:
        val image = imageURL + mQuestionsList!![questionNumber].id + ".jpg"
        Glide.with(this)
            .load(image)
            .into(binding.imgPlacementTest)

        binding.txtQuestion.text = mQuestionsList!![questionNumber].question
        binding.txtAnswerOne.text = mQuestionsList!![questionNumber].optionOne
        binding.txtAnswerTwo.text = mQuestionsList!![questionNumber].optionTwo
        binding.txtAnswerThree.text = mQuestionsList!![questionNumber].optionThree
        binding.txtAnswerFour.text = mQuestionsList!![questionNumber].optionFour

        binding.answerFourCard.layoutParams.height = 0

        //progress bar
        binding.progressBar.progress = currentPosition
        binding.txtProgressBar.text = "$currentPosition" + "/" + binding.progressBar.max

        //choosing answers

        binding.answerOneCard.setOnClickListener {
            if (currentPosition > 19) {
                binding.answerFourCard.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            }
            val correctAnswer = mQuestionsList!![questionNumber].correctAnswer
            if (1 == correctAnswer) {
                val scoreWeight = mQuestionsList!![questionNumber].answerWeight
                score += scoreWeight
            }
            if (mQuestionsList!!.size > currentPosition) {
                currentPosition += 1
                questionNumber += 1
                progressBar(currentPosition)
                setQuestion(questionNumber)
            } else {
                val bundle = Bundle()
                bundle.putInt(KEY_testResult, score)
                val fragment = FragmentPlacementResult()
                fragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
                transaction.commit()

            }
            Log.i("hamed 2", currentPosition.toString())
        }
        binding.answerTwoCard.setOnClickListener {
            if (currentPosition > 19) {
                binding.answerFourCard.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            }
            val correctAnswer = mQuestionsList!![questionNumber].correctAnswer
            if (2 == correctAnswer) {
                val scoreWeight = mQuestionsList!![questionNumber].answerWeight
                score += scoreWeight
            }
            if (mQuestionsList!!.size > currentPosition) {
                currentPosition += 1
                questionNumber += 1
                progressBar(currentPosition)
                setQuestion(questionNumber)
            } else {
                val bundle = Bundle()
                bundle.putInt(KEY_testResult, score)
                val fragment = FragmentPlacementResult()
                fragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
                transaction.commit()
            }
            Log.i("hamed 2", currentPosition.toString())
        }
        binding.answerThreeCard.setOnClickListener {
            if (currentPosition > 19) {
                binding.answerFourCard.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            }
            val correctAnswer = mQuestionsList!![questionNumber].correctAnswer
            if (3 == correctAnswer) {
                val scoreWeight = mQuestionsList!![questionNumber].answerWeight
                score += scoreWeight
            }
            if (mQuestionsList!!.size > currentPosition) {
                currentPosition += 1
                questionNumber += 1
                progressBar(currentPosition)
                setQuestion(questionNumber)
            } else {
                val bundle = Bundle()
                bundle.putInt(KEY_testResult, score)
                val fragment = FragmentPlacementResult()
                fragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
                transaction.commit()
            }
            Log.i("hamed 2", currentPosition.toString())
        }
        binding.answerFourCard.setOnClickListener {
            if (currentPosition > 19) {
                binding.answerFourCard.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            }
            val correctAnswer = mQuestionsList!![questionNumber].correctAnswer
            if (4 == correctAnswer) {
                val scoreWeight = mQuestionsList!![questionNumber].answerWeight
                score += scoreWeight
            }
            if (mQuestionsList!!.size > currentPosition) {
                currentPosition += 1
                questionNumber += 1
                progressBar(currentPosition)
                setQuestion(questionNumber)
            } else {
                val bundle = Bundle()
                bundle.putInt(KEY_testResult, score)
                val fragment = FragmentPlacementResult()
                fragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
                transaction.commit()

            }
            Log.i("hamed 2", currentPosition.toString())
        }

    }

    private fun setQuestion(questionNumber: Int) {
        binding.txtQuestion.text = mQuestionsList!![questionNumber].question
        binding.txtAnswerOne.text = mQuestionsList!![questionNumber].optionOne
        binding.txtAnswerTwo.text = mQuestionsList!![questionNumber].optionTwo
        binding.txtAnswerThree.text = mQuestionsList!![questionNumber].optionThree
        binding.txtAnswerFour.text = mQuestionsList!![questionNumber].optionFour
        val image = imageURL + mQuestionsList!![questionNumber].id + ".jpg"
        Glide.with(this)

            .load(image)
            .placeholder(R.drawable.ic_loading)
            .into(binding.imgPlacementTest)

    }

    @SuppressLint("SetTextI18n")
    fun progressBar(currentPosition: Int) {
        binding.progressBar.progress = currentPosition
        binding.txtProgressBar.text = "$currentPosition" + "/" + binding.progressBar.max
    }

//    override fun onBackPressed() {
//        val alertDialog = AlertDialog.Builder(this).create()
//        val dialogBinding = TemplaterAlertDialogBackTestPlacementBinding.inflate(layoutInflater)
//        alertDialog.setView(dialogBinding.root)
//        alertDialog.setCancelable(true)
//        alertDialog.create()
//        alertDialog.show()
//
//        dialogBinding.continueBtn.setOnClickListener {
//            super.onBackPressed()
//        }
//        dialogBinding.cancelBtn.setOnClickListener {
//            alertDialog.dismiss()
//        }
//    }
}