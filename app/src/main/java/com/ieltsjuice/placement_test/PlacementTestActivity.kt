package com.ieltsjuice.placement_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.ieltsjuice.R
import com.ieltsjuice.databinding.ActivityPlacementTestBinding
import com.ieltsjuice.model.PlacementTestQuestions
import com.ieltsjuice.model.Question

const val KEY_testResult = "KEY_testResult"

class PlacementTestActivity : AppCompatActivity() {

    private var score: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private val imageURL = "https://ieltsjuice.com/wp-content/uploads/app/opt/img_test_"

    lateinit var binding: ActivityPlacementTestBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacementTestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //making question list
        mQuestionsList = PlacementTestQuestions.getQuestions()

        //First Init
        var currentPosition = 1
        var questionNumber = currentPosition - 1


        //First Data:
        var image = imageURL + mQuestionsList!![questionNumber].id +".jpg"
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
                val intent = Intent(this, TestResultActivity::class.java)
                intent.putExtra(KEY_testResult, score)
                startActivity(intent)
                finish()
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
                val intent = Intent(this, TestResultActivity::class.java)
                intent.putExtra(KEY_testResult, score)
                startActivity(intent)
                finish()
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
                val intent = Intent(this, TestResultActivity::class.java)
                intent.putExtra(KEY_testResult, score)
                startActivity(intent)
                finish()
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
                val intent = Intent(this, TestResultActivity::class.java)
                intent.putExtra(KEY_testResult, score)
                startActivity(intent)
                finish()

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
        var image = imageURL + mQuestionsList!![questionNumber].id +".jpg"
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
}
