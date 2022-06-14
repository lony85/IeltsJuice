package com.ieltsjuice.placement_test

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentPlacementQuestionsBinding
import com.ieltsjuice.model.PlacementQuizRepository
import com.ieltsjuice.model.Question
import com.ieltsjuice.util.imageURL

const val KEY_testResult = "KEY_testResult"

class FragmentPlacementQuestions : Fragment() {
    lateinit var binding: FragmentPlacementQuestionsBinding
    lateinit var placementQuizViewModel: PlacementQuizViewModel
    private var score: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlacementQuestionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        placementQuizViewModel = PlacementQuizViewModel(PlacementQuizRepository())

        //making question list
        val mQuestionsList= placementQuizViewModel.getQuestions()

        //First Init
        var currentPosition = 1
        var questionNumber = currentPosition - 1

        //First Data:
        val image = imageURL + mQuestionsList[questionNumber].id + ".jpg"
        Glide.with(this)
            .load(image)
            .into(binding.imgPlacementTest)

        binding.txtQuestion.text = mQuestionsList[questionNumber].question
        binding.txtAnswerOne.text = mQuestionsList[questionNumber].optionOne
        binding.txtAnswerTwo.text = mQuestionsList[questionNumber].optionTwo
        binding.txtAnswerThree.text = mQuestionsList[questionNumber].optionThree
        binding.txtAnswerFour.text = mQuestionsList[questionNumber].optionFour

        binding.answerFourCard.layoutParams.height = 0

        //progress bar
        binding.progressBar.progress = currentPosition
        binding.txtProgressBar.text = "$currentPosition" + "/" + binding.progressBar.max

        //choosing answers
        binding.answerOneCard.setOnClickListener {
            if (currentPosition > 19) {
                binding.answerFourCard.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            }
            val correctAnswer = mQuestionsList[questionNumber].correctAnswer
            if (1 == correctAnswer) {
                val scoreWeight = mQuestionsList[questionNumber].answerWeight
                score += scoreWeight
            }
            if (mQuestionsList.size > currentPosition) {
                currentPosition += 1
                questionNumber += 1
                progressBar(currentPosition)
                setQuestion(mQuestionsList,questionNumber)
            } else {
                val bundle = Bundle()
                bundle.putInt(KEY_testResult, score)
                val fragment = FragmentPlacementResult()
                fragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
                transaction.commit()

            }
        }
        binding.answerTwoCard.setOnClickListener {
            if (currentPosition > 19) {
                binding.answerFourCard.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            }
            val correctAnswer = mQuestionsList[questionNumber].correctAnswer
            if (2 == correctAnswer) {
                val scoreWeight = mQuestionsList[questionNumber].answerWeight
                score += scoreWeight
            }
            if (mQuestionsList.size > currentPosition) {
                currentPosition += 1
                questionNumber += 1
                progressBar(currentPosition)
                setQuestion(mQuestionsList,questionNumber)
            } else {
                val bundle = Bundle()
                bundle.putInt(KEY_testResult, score)
                val fragment = FragmentPlacementResult()
                fragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
                transaction.commit()
            }
        }
        binding.answerThreeCard.setOnClickListener {
            if (currentPosition > 19) {
                binding.answerFourCard.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            }
            val correctAnswer = mQuestionsList[questionNumber].correctAnswer
            if (3 == correctAnswer) {
                val scoreWeight = mQuestionsList[questionNumber].answerWeight
                score += scoreWeight
            }
            if (mQuestionsList.size > currentPosition) {
                currentPosition += 1
                questionNumber += 1
                progressBar(currentPosition)
                setQuestion(mQuestionsList,questionNumber)
            } else {
                val bundle = Bundle()
                bundle.putInt(KEY_testResult, score)
                val fragment = FragmentPlacementResult()
                fragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
                transaction.commit()
            }
        }
        binding.answerFourCard.setOnClickListener {
            if (currentPosition > 19) {
                binding.answerFourCard.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            }
            val correctAnswer = mQuestionsList[questionNumber].correctAnswer
            if (4 == correctAnswer) {
                val scoreWeight = mQuestionsList[questionNumber].answerWeight
                score += scoreWeight
            }
            if (mQuestionsList.size > currentPosition) {
                currentPosition += 1
                questionNumber += 1
                progressBar(currentPosition)
                setQuestion(mQuestionsList,questionNumber)
            } else {
                val bundle = Bundle()
                bundle.putInt(KEY_testResult, score)
                val fragment = FragmentPlacementResult()
                fragment.arguments = bundle
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
                transaction.commit()

            }
        }

    }

    //setting Questions
    private fun setQuestion(mQuestionsList:List<Question>,questionNumber: Int) {

        binding.txtQuestion.text = mQuestionsList[questionNumber].question
        binding.txtAnswerOne.text = mQuestionsList[questionNumber].optionOne
        binding.txtAnswerTwo.text = mQuestionsList[questionNumber].optionTwo
        binding.txtAnswerThree.text = mQuestionsList[questionNumber].optionThree
        binding.txtAnswerFour.text = mQuestionsList[questionNumber].optionFour
        val image = imageURL + mQuestionsList[questionNumber].id + ".jpg"
        Glide.with(this)

            .load(image)
            .placeholder(R.drawable.ic_loading)
            .into(binding.imgPlacementTest)
    }

    //Progress Bar
    @SuppressLint("SetTextI18n")
    fun progressBar(currentPosition: Int) {
        binding.progressBar.progress = currentPosition
        binding.txtProgressBar.text = "$currentPosition" + "/" + binding.progressBar.max
    }
}