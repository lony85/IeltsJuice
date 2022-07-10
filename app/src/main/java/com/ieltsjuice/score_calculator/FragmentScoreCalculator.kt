package com.ieltsjuice.score_calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.ieltsjuice.databinding.FragmentScoreCalculatorBinding


class FragmentScoreCalculator : Fragment() {
    lateinit var binding: FragmentScoreCalculatorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScoreCalculatorBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Score Calculator
        binding.scoreCalculatorBtn.setOnClickListener {
            if (binding.txtScoreListening.editText?.text?.isNotEmpty() == true) {
                binding.txtScoreListening.error = null
                val listeningScore: Int =
                    binding.txtScoreListening.editText!!.text.toString().toInt()
                if (listeningScore <= 40) {
                    binding.txtScoreListening.error = null
                    calculateListeningScore(listeningScore)
                } else {
                    binding.txtScoreListening.error = "Enter 0-40"
                }
            }
            if (binding.txtScoreReading.editText?.text?.isNotEmpty() == true) {
                binding.txtScoreReading.error = null
                val readingScore: Int =
                    binding.txtScoreReading.editText!!.text.toString().toInt()

                if (binding.academicRadioBtn.isChecked) {
                    binding.academicRadioBtn.setTextColor(
                        ContextCompat.getColor(
                            this.requireActivity(),
                            android.R.color.black
                        )
                    )
                    binding.generalRadioBtn.setTextColor(
                        ContextCompat.getColor(
                            this.requireActivity(),
                            android.R.color.black
                        )
                    )
                    if (readingScore <= 40) {
                        binding.txtScoreReading.error = null
                        calculateReadingScoreAcademic(readingScore)
                    } else {
                        binding.txtScoreReading.error = "Enter 0-40"
                    }

                } else if (binding.generalRadioBtn.isChecked) {
                    binding.academicRadioBtn.setTextColor(
                        ContextCompat.getColor(
                            this.requireActivity(),
                            android.R.color.black
                        )
                    )
                    binding.generalRadioBtn.setTextColor(
                        ContextCompat.getColor(
                            this.requireActivity(),
                            android.R.color.black
                        )
                    )
                    if (readingScore <= 40) {
                        binding.txtScoreReading.error = null
                        calculateReadingScoreGeneral(readingScore)
                    } else {
                        binding.txtScoreReading.error = "Enter 0-40"
                    }

                } else {
                    binding.academicRadioBtn.setTextColor(
                        ContextCompat.getColor(
                            this.requireActivity(), android.R.color.holo_red_dark
                        )
                    )
                    binding.generalRadioBtn.setTextColor(
                        ContextCompat.getColor(
                            this.requireActivity(),
                            android.R.color.holo_red_dark
                        )
                    )
                    Snackbar.make(binding.root, "Select IELTS Type...", LENGTH_SHORT).show()

                }

            }
        }
        binding.resetCalculatorBtn.setOnClickListener {
            binding.txtScoreListening.editText!!.text.clear()
            binding.txtScoreListeningResult.text = ""
            binding.txtScoreReading.editText!!.text.clear()
            binding.txtScoreReadingResult.text = ""
            binding.academicRadioBtn.isChecked = false
            binding.generalRadioBtn.isChecked = false
            binding.academicRadioBtn.setTextColor(
                ContextCompat.getColor(
                    this.requireActivity(),
                    android.R.color.black
                )
            )
            binding.generalRadioBtn.setTextColor(
                ContextCompat.getColor(
                    this.requireActivity(),
                    android.R.color.black
                )
            )
        }

        //Score Overall Calculator
        binding.scoreCalculatorOverallBtn.setOnClickListener {
            binding.txtScoreOverallListening.error = null
            binding.txtScoreOverallReading.error = null
            binding.txtScoreOverallSpeaking.error = null
            binding.txtScoreOverallWriting.error = null


            if (binding.txtScoreOverallListening.editText?.text?.isNotEmpty() == true
                && binding.txtScoreOverallReading.editText?.text?.isNotEmpty() == true
                && binding.txtScoreOverallWriting.editText?.text?.isNotEmpty() == true
                && binding.txtScoreOverallSpeaking.editText?.text?.isNotEmpty() == true
            ) {

                val listeningScoreOverall: Float =
                    binding.txtScoreOverallListening.editText!!.text.toString().toFloat()
                val speakingScoreOverall: Float =
                    binding.txtScoreOverallSpeaking.editText!!.text.toString().toFloat()
                val writingScoreOverall: Float =
                    binding.txtScoreOverallWriting.editText!!.text.toString().toFloat()
                val readingScoreOverall: Float =
                    binding.txtScoreOverallReading.editText!!.text.toString().toFloat()

                if (listeningScoreOverall <= 9
                    && speakingScoreOverall <= 9
                    && writingScoreOverall <= 9
                    && readingScoreOverall <= 9
                ) {
                    scoreOverallCalculator(
                        listeningScoreOverall,
                        speakingScoreOverall,
                        writingScoreOverall,
                        readingScoreOverall
                    )
                } else {
                    if (binding.txtScoreOverallListening.editText!!.text.toString().toFloat() > 9){
                        binding.txtScoreOverallListening.error = "Enter 0-9"
                    }
                    if (binding.txtScoreOverallReading.editText!!.text.toString().toFloat() > 9){
                        binding.txtScoreOverallReading.error = "Enter 0-9"
                    }
                    if (binding.txtScoreOverallWriting.editText!!.text.toString().toFloat() > 9){
                        binding.txtScoreOverallWriting.error = "Enter 0-9"
                    }
                    if (binding.txtScoreOverallSpeaking.editText!!.text.toString().toFloat() > 9){
                        binding.txtScoreOverallSpeaking.error = "Enter 0-9"
                    }
                }

            }else{
                if (binding.txtScoreOverallListening.editText?.text?.isEmpty() == true){
                    binding.txtScoreOverallListening.error = "Enter your score..."
                }
                if (binding.txtScoreOverallReading.editText?.text?.isEmpty() == true){
                    binding.txtScoreOverallReading.error = "Enter your score..."
                }
                if (binding.txtScoreOverallWriting.editText?.text?.isEmpty() == true){
                    binding.txtScoreOverallWriting.error = "Enter your score..."
                }
                if (binding.txtScoreOverallSpeaking.editText?.text?.isEmpty() == true){
                    binding.txtScoreOverallSpeaking.error = "Enter your score..."
                }
            }
        }
        binding.scoreCalculatorOverallResetBtn.setOnClickListener {
            binding.txtScoreOverallResult.text = ""
            binding.txtScoreOverallListening.editText!!.text.clear()
            binding.txtScoreOverallReading.editText!!.text.clear()
            binding.txtScoreOverallSpeaking.editText!!.text.clear()
            binding.txtScoreOverallWriting.editText!!.text.clear()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun scoreOverallCalculator(
        listeningScoreOverall: Float,
        speakingScoreOverall: Float,
        writingScoreOverall: Float,
        readingScoreOverall: Float
    ) {
        Log.i("hamed-1", listeningScoreOverall.toString())
        Log.i("hamed-2", speakingScoreOverall.toString())
        Log.i("hamed-3", writingScoreOverall.toString())
        Log.i("hamed-4", readingScoreOverall.toString())
        val overallResult: Float =
            (listeningScoreOverall + speakingScoreOverall + writingScoreOverall + readingScoreOverall) / 4
        Log.i("hamed", overallResult.toString())
        var overallResultInt = overallResult.toInt()
        val overallResultDecimal = overallResult - overallResultInt
        Log.i("hamed", overallResultDecimal.toString())
        if (overallResultDecimal in 0.0..0.24) {
            binding.txtScoreOverallResult.text = "Your overall score is : $overallResultInt"
        } else if (overallResultDecimal in 0.25..0.74) {
            binding.txtScoreOverallResult.text = "Your overall score is : $overallResultInt.5"
        } else if (overallResultDecimal in 0.75..1.00) {
            overallResultInt += 1
            binding.txtScoreOverallResult.text = "Your overall score is : $overallResultInt"
        }

    }

    @SuppressLint("SetTextI18n")
    private fun calculateReadingScoreGeneral(readingScore: Int) {
        if (readingScore in 1..2) {
            binding.txtScoreReadingResult.text = "Your Score is : 1.0"
        } else if (readingScore in 3..5) {
            binding.txtScoreReadingResult.text = "Your Score is : 2.0"
        } else if (readingScore in 6..8) {
            binding.txtScoreReadingResult.text = "Your Score is : 2.5"
        } else if (readingScore in 9..11) {
            binding.txtScoreReadingResult.text = "Your Score is : 3.0"
        } else if (readingScore in 12..14) {
            binding.txtScoreReadingResult.text = "Your Score is : 3.5"
        } else if (readingScore in 15..18) {
            binding.txtScoreReadingResult.text = "Your Score is : 4.0"
        } else if (readingScore in 19..22) {
            binding.txtScoreReadingResult.text = "Your Score is : 4.5"
        } else if (readingScore in 23..26) {
            binding.txtScoreReadingResult.text = "Your Score is : 5.0"
        } else if (readingScore in 27..29) {
            binding.txtScoreReadingResult.text = "Your Score is : 5.5"
        } else if (readingScore in 30..31) {
            binding.txtScoreReadingResult.text = "Your Score is : 6.0"
        } else if (readingScore in 32..33) {
            binding.txtScoreReadingResult.text = "Your Score is : 6.5"
        } else if (readingScore in 34..35) {
            binding.txtScoreReadingResult.text = "Your Score is : 7.0"
        } else if (readingScore in 36..37) {
            binding.txtScoreReadingResult.text = "Your Score is : 7.5"
        } else if (readingScore == 38) {
            binding.txtScoreReadingResult.text = "Your Score is : 8.0"
        } else if (readingScore == 39) {
            binding.txtScoreReadingResult.text = "Your Score is : 8.5"
        } else if (readingScore == 40) {
            binding.txtScoreReadingResult.text = "Your Score is : 9.0"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateReadingScoreAcademic(readingScore: Int) {
        if (readingScore == 1) {
            binding.txtScoreReadingResult.text = "Your Score is : 1.0"
        } else if (readingScore in 2..3) {
            binding.txtScoreReadingResult.text = "Your Score is : 2.0"
        } else if (readingScore in 4..5) {
            binding.txtScoreReadingResult.text = "Your Score is : 2.5"
        } else if (readingScore in 6..7) {
            binding.txtScoreReadingResult.text = "Your Score is : 3.0"
        } else if (readingScore in 8..9) {
            binding.txtScoreReadingResult.text = "Your Score is : 3.5"
        } else if (readingScore in 10..12) {
            binding.txtScoreReadingResult.text = "Your Score is : 4.0"
        } else if (readingScore in 13..14) {
            binding.txtScoreReadingResult.text = "Your Score is : 4.5"
        } else if (readingScore in 15..18) {
            binding.txtScoreReadingResult.text = "Your Score is : 5.0"
        } else if (readingScore in 19..22) {
            binding.txtScoreReadingResult.text = "Your Score is : 5.5"
        } else if (readingScore in 23..26) {
            binding.txtScoreReadingResult.text = "Your Score is : 6.0"
        } else if (readingScore in 27..29) {
            binding.txtScoreReadingResult.text = "Your Score is : 6.5"
        } else if (readingScore in 30..32) {
            binding.txtScoreReadingResult.text = "Your Score is : 7.0"
        } else if (readingScore in 33..34) {
            binding.txtScoreReadingResult.text = "Your Score is : 7.5"
        } else if (readingScore in 35..36) {
            binding.txtScoreReadingResult.text = "Your Score is : 8.0"
        } else if (readingScore in 37..38) {
            binding.txtScoreReadingResult.text = "Your Score is : 8.5"
        } else if (readingScore in 39..40) {
            binding.txtScoreReadingResult.text = "Your Score is : 9.0"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateListeningScore(listeningScore: Int) {
        if (listeningScore in 1..2) {
            binding.txtScoreListeningResult.text = "Your Score is : 1.0"
        } else if (listeningScore in 3..4) {
            binding.txtScoreListeningResult.text = "Your Score is : 2.0"
        } else if (listeningScore in 5..6) {
            binding.txtScoreListeningResult.text = "Your Score is : 2.5"
        } else if (listeningScore in 7..8) {
            binding.txtScoreListeningResult.text = "Your Score is : 3.0"
        } else if (listeningScore in 9..10) {
            binding.txtScoreListeningResult.text = "Your Score is : 3.5"
        } else if (listeningScore in 11..12) {
            binding.txtScoreListeningResult.text = "Your Score is : 4.0"
        } else if (listeningScore in 13..15) {
            binding.txtScoreListeningResult.text = "Your Score is : 4.5"
        } else if (listeningScore in 16..17) {
            binding.txtScoreListeningResult.text = "Your Score is : 5.0"
        } else if (listeningScore in 18..22) {
            binding.txtScoreListeningResult.text = "Your Score is : 5.5"
        } else if (listeningScore in 23..25) {
            binding.txtScoreListeningResult.text = "Your Score is : 6.0"
        } else if (listeningScore in 26..29) {
            binding.txtScoreListeningResult.text = "Your Score is : 6.5"
        } else if (listeningScore in 30..31) {
            binding.txtScoreListeningResult.text = "Your Score is : 7.0"
        } else if (listeningScore in 32..34) {
            binding.txtScoreListeningResult.text = "Your Score is : 7.5"
        } else if (listeningScore in 35..36) {
            binding.txtScoreListeningResult.text = "Your Score is : 8.0"
        } else if (listeningScore in 37..38) {
            binding.txtScoreListeningResult.text = "Your Score is : 8.5"
        } else if (listeningScore in 39..40) {
            binding.txtScoreListeningResult.text = "Your Score is : 9.0"
        }

    }


}
