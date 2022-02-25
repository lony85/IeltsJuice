package com.ieltsjuice.self_paced.listening

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.internetconnection.NetworkChecker
import com.google.android.material.snackbar.Snackbar
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentTestListeningBinding
import com.ieltsjuice.databinding.TemplateAlertDialogBinding
import com.ieltsjuice.self_paced.speaking.KEY_SelfPacedCourseMainTitle

class FragmentTestListening : Fragment() {
    lateinit var binding: FragmentTestListeningBinding

    var mp: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestListeningBinding.inflate(layoutInflater, container, false)
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
                "L.1.1.About the Listening Test - Quiz" -> {
                    val que1: ViewGroup.LayoutParams = binding.QuestionLayout1.layoutParams
                    que1.height = 0
                    binding.QuestionLayout1.requestLayout()
                    val que2: ViewGroup.LayoutParams = binding.QuestionLayout2.layoutParams
                    que2.height = 0
                    binding.QuestionLayout2.requestLayout()

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
                    val que8: ViewGroup.LayoutParams = binding.QuestionLayout8.layoutParams
                    que8.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que9: ViewGroup.LayoutParams = binding.QuestionLayout9.layoutParams
                    que9.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que10: ViewGroup.LayoutParams = binding.QuestionLayout10.layoutParams
                    que10.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que11: ViewGroup.LayoutParams = binding.QuestionLayout11.layoutParams
                    que11.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que12: ViewGroup.LayoutParams = binding.QuestionLayout12.layoutParams
                    que12.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que13: ViewGroup.LayoutParams = binding.QuestionLayout13.layoutParams
                    que13.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que14: ViewGroup.LayoutParams = binding.QuestionLayout14.layoutParams
                    que14.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que15: ViewGroup.LayoutParams = binding.QuestionLayout15.layoutParams
                    que15.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que16: ViewGroup.LayoutParams = binding.QuestionLayout16.layoutParams
                    que16.height = 0
                    binding.QuestionLayout7.requestLayout()
                }

                "L.1.2 The Listening Test Layout - Quiz" -> {

                    val que1: ViewGroup.LayoutParams = binding.QuestionLayout1.layoutParams
                    que1.height = 0
                    binding.QuestionLayout2.requestLayout()
                    val que3: ViewGroup.LayoutParams = binding.QuestionLayout3.layoutParams
                    que3.height = 0
                    binding.QuestionLayout2.requestLayout()

                    val que5: ViewGroup.LayoutParams = binding.QuestionLayout5.layoutParams
                    que5.height = 0
                    binding.QuestionLayout5.requestLayout()
                    val que6: ViewGroup.LayoutParams = binding.QuestionLayout6.layoutParams
                    que6.height = 0
                    binding.QuestionLayout6.requestLayout()
                    val que9: ViewGroup.LayoutParams = binding.QuestionLayout9.layoutParams
                    que9.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que10: ViewGroup.LayoutParams = binding.QuestionLayout10.layoutParams
                    que10.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que11: ViewGroup.LayoutParams = binding.QuestionLayout11.layoutParams
                    que11.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que12: ViewGroup.LayoutParams = binding.QuestionLayout12.layoutParams
                    que12.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que13: ViewGroup.LayoutParams = binding.QuestionLayout13.layoutParams
                    que13.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que14: ViewGroup.LayoutParams = binding.QuestionLayout14.layoutParams
                    que14.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que15: ViewGroup.LayoutParams = binding.QuestionLayout15.layoutParams
                    que15.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que16: ViewGroup.LayoutParams = binding.QuestionLayout16.layoutParams
                    que16.height = 0
                    binding.QuestionLayout7.requestLayout()

                }

                "L.1.3 English Accents - Quiz" -> {

                    val que2: ViewGroup.LayoutParams = binding.QuestionLayout2.layoutParams
                    que2.height = 0
                    binding.QuestionLayout2.requestLayout()
                    val que3: ViewGroup.LayoutParams = binding.QuestionLayout3.layoutParams
                    que3.height = 0
                    binding.QuestionLayout2.requestLayout()
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
                    val que8: ViewGroup.LayoutParams = binding.QuestionLayout8.layoutParams
                    que8.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que12: ViewGroup.LayoutParams = binding.QuestionLayout12.layoutParams
                    que12.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que13: ViewGroup.LayoutParams = binding.QuestionLayout13.layoutParams
                    que13.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que14: ViewGroup.LayoutParams = binding.QuestionLayout14.layoutParams
                    que14.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que15: ViewGroup.LayoutParams = binding.QuestionLayout15.layoutParams
                    que15.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que16: ViewGroup.LayoutParams = binding.QuestionLayout16.layoutParams
                    que16.height = 0
                    binding.QuestionLayout7.requestLayout()
                }

                "L.1.4 Features of the Australian Accent - Quiz" -> {
                    val que1: ViewGroup.LayoutParams = binding.QuestionLayout1.layoutParams
                    que1.height = 0
                    binding.QuestionLayout2.requestLayout()
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
                    val que7: ViewGroup.LayoutParams = binding.QuestionLayout7.layoutParams
                    que7.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que8: ViewGroup.LayoutParams = binding.QuestionLayout8.layoutParams
                    que8.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que10: ViewGroup.LayoutParams = binding.QuestionLayout10.layoutParams
                    que10.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que11: ViewGroup.LayoutParams = binding.QuestionLayout11.layoutParams
                    que11.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que12: ViewGroup.LayoutParams = binding.QuestionLayout12.layoutParams
                    que12.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que13: ViewGroup.LayoutParams = binding.QuestionLayout13.layoutParams
                    que13.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que14: ViewGroup.LayoutParams = binding.QuestionLayout14.layoutParams
                    que14.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que15: ViewGroup.LayoutParams = binding.QuestionLayout15.layoutParams
                    que15.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que16: ViewGroup.LayoutParams = binding.QuestionLayout16.layoutParams
                    que16.height = 0
                    binding.QuestionLayout7.requestLayout()
                }

                "L.1.5 Listening Question Types - Quiz" -> {
                    val que1: ViewGroup.LayoutParams = binding.QuestionLayout1.layoutParams
                    que1.height = 0
                    binding.QuestionLayout1.requestLayout()
                    val que2: ViewGroup.LayoutParams = binding.QuestionLayout2.layoutParams
                    que2.height = 0
                    binding.QuestionLayout2.requestLayout()
                    val que3: ViewGroup.LayoutParams = binding.QuestionLayout3.layoutParams
                    que3.height = 0
                    binding.QuestionLayout2.requestLayout()
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
                    val que8: ViewGroup.LayoutParams = binding.QuestionLayout8.layoutParams
                    que8.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que9: ViewGroup.LayoutParams = binding.QuestionLayout9.layoutParams
                    que9.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que10: ViewGroup.LayoutParams = binding.QuestionLayout10.layoutParams
                    que10.height = 0
                    binding.QuestionLayout7.requestLayout()
                    val que11: ViewGroup.LayoutParams = binding.QuestionLayout11.layoutParams
                    que11.height = 0
                    binding.QuestionLayout7.requestLayout()
                }

            }

        }
    }

    //Binding Data
    @SuppressLint("SetTextI18n", "ShowToast")
    fun bindData(quizTitle: String) {
        when (quizTitle) {
            "L.1.1.About the Listening Test - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQueRadioBtn3.text =
                    "1. What do we mean by “test-taking approach?"
                binding.radioGroup3Btn1.text =
                    "The differences between the tests."
                binding.radioGroup3Btn2.text =
                    "You do not listen enough to English audio materials."
                binding.radioGroup3Btn3.text =
                    "If you know the format of the test better, you can improve your chances of success."
                binding.radioGroup3Btn4.text =
                    "Improving your general listening is more important than knowing the test format."


                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup3Btn3.isChecked) {
                        score += 1

                    }

                    dialogActions(quizTitle, score.toString(), "1")
                }
            }

            "L.1.2 The Listening Test Layout - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQueRadioBtn2.text = "3. Is the following statement true?"
                binding.txtQueRadioBtn2Desc.text =
                    "IELTS Listening part has four sections, 10 questions each, and the questions gradually become harder as the test reaches its end."
                binding.txtFillTheGap.text =
                    "The Listening module is the ___ part of the IELTS test. It takes about ___ minutes and there are exactly ___ questions."


                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup2Btn1.isChecked) {
                        score += 1
                    }
                    if (binding.txtLayoutQue7Order1.editText?.text.toString() == "2" && binding.txtLayoutQue7Order2.editText?.text.toString() == "4" && binding.txtLayoutQue7Order3.editText?.text.toString() == "1" && binding.txtLayoutQue7Order4.editText?.text.toString() == "3") {
                        score += 1
                    }
                    if (binding.txtLayoutQue8Order1.editText?.text.toString() == "1" && binding.txtLayoutQue8Order2.editText?.text.toString() == "4" && binding.txtLayoutQue8Order3.editText?.text.toString() == "2" && binding.txtLayoutQue8Order4.editText?.text.toString() == "3") {
                        score += 1
                    }
                    if (binding.txtInputLayout1.editText?.text.toString() == "1" || binding.txtInputLayout1.editText?.text.toString()
                            .lowercase() == "1st" || binding.txtInputLayout1.editText?.text.toString()
                            .lowercase() == "first"
                    ) {
                        if (binding.txtInputLayout2.editText?.text.toString() == "30" || binding.txtInputLayout2.editText?.text.toString()
                                .lowercase() == "thirty"
                        ) {
                            if (binding.txtInputLayout3.editText?.text.toString() == "40" || binding.txtInputLayout3.editText?.text.toString()
                                    .lowercase() == "forty"
                            )
                                score += 1
                        }

                    }
                    dialogActions(quizTitle, score.toString(), "4")


                }

            }

            "L.1.3 English Accents - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQueRadioBtn1.text =
                    "1. What English accents are common in IELTS?"
                binding.radioGroup1Btn1.text =
                    "MSBE, New Zealand English, Australian accent"
                binding.radioGroup1Btn2.text =
                    "North American accent, British RP accent, Canadian accent"
                binding.radioGroup1Btn3.text =
                    "MSBE accent, Australian accent, North American accent"

                binding.txtQue9RadioBtn1.text =
                    "2. Listen to the audio and decide which accent it is?"
                binding.radioGroup9Btn1.text =
                    "Modern Standard British English accent"
                binding.radioGroup9Btn2.text =
                    "Australian accent"
                binding.radioGroup9Btn3.text =
                    "North American accent"

                binding.txtQue10RadioBtn1.text =
                    "3. Listen to the audio and decide which accent it is?"
                binding.radioGroup10Btn1.text =
                    "Modern Standard British English accent"
                binding.radioGroup10Btn2.text =
                    "Australian accent"
                binding.radioGroup10Btn3.text =
                    "North American accent"

                binding.txtQue11RadioBtn1.text =
                    "4. Listen to the audio and decide which accent it is?"
                binding.radioGroup11Btn1.text =
                    "Modern Standard British English accent"
                binding.radioGroup11Btn2.text =
                    "Australian accent"
                binding.radioGroup11Btn3.text =
                    "North American accent"

                // Sound Player

                binding.fabPlayQue9.setOnClickListener {
                    if (NetworkChecker(this.requireActivity()).isInternetConnected) {

                        when {
                            mp == null -> {
                                mp = MediaPlayer()
                                mp!!.setDataSource("https://ieltsjuice.com/wp-content/uploads/2021/08/Accent-1-NA.mp3?_=4")
                                mp!!.prepare()
                                mp?.start()
                                binding.fabPlayQue9.setImageResource(R.drawable.ic_baseline_stop)
                                initialiseSeekBar("Que9")

                            }
                            mp!!.isPlaying -> {
                                mp?.pause()
                                mp?.stop()
                                mp?.reset()
                                mp?.release()
                                mp = null
                                binding.seekBarQue9.progress = 0
                                binding.seekBarQue10.progress = 0
                                binding.seekBarQue11.progress = 0
                                binding.fabPlayQue9.setImageResource(R.drawable.ic_baseline_play)
                            }
                            else -> {
                                mp?.start()
                                binding.fabPlayQue9.setImageResource(R.drawable.ic_baseline_stop)
                            }
                        }
                    } else {
                        Snackbar.make(binding.root, R.string.NoInternet, Snackbar.LENGTH_SHORT)
                            .setBackgroundTint(
                                ContextCompat.getColor(
                                    this.requireActivity(),
                                    R.color.colorPrimary
                                )
                            )
                            .show()
                    }

                }
                //  SeekBar
                seekBarChangeListener("Que9")
                seekBarChangeListener("Que10")
                seekBarChangeListener("Que11")


                binding.fabPlayQue10.setOnClickListener {
                    if (NetworkChecker(this.requireActivity()).isInternetConnected) {

                        when {
                            mp == null -> {
                                mp = MediaPlayer()
                                mp!!.setDataSource("https://ieltsjuice.com/wp-content/uploads/2021/08/Accent-2-Aus.mp3?_=5")
                                mp!!.prepare()
                                mp?.start()
                                binding.fabPlayQue10.setImageResource(R.drawable.ic_baseline_stop)
                                initialiseSeekBar("Que10")

                            }
                            mp!!.isPlaying -> {
                                mp?.pause()
                                mp?.stop()
                                mp?.reset()
                                mp?.release()
                                mp = null
                                binding.seekBarQue9.progress = 0
                                binding.seekBarQue10.progress = 0
                                binding.seekBarQue11.progress = 0
                                binding.fabPlayQue10.setImageResource(R.drawable.ic_baseline_play)
                            }
                            else -> {
                                mp?.start()
                                binding.fabPlayQue10.setImageResource(R.drawable.ic_baseline_stop)
                            }
                        }
                    } else {
                        Snackbar.make(binding.root, R.string.NoInternet, Snackbar.LENGTH_SHORT)
                            .setBackgroundTint(
                                ContextCompat.getColor(
                                    this.requireActivity(),
                                    R.color.colorPrimary
                                )
                            )
                            .show()
                    }
                }


                binding.fabPlayQue11.setOnClickListener {
                    if (NetworkChecker(this.requireActivity()).isInternetConnected) {

                        when {
                            mp == null -> {
                                mp = MediaPlayer()
                                mp!!.setDataSource("https://ieltsjuice.com/wp-content/uploads/2021/08/Accent-3-Br.mp3?_=6")
                                mp!!.prepare()
                                mp?.start()
                                binding.fabPlayQue11.setImageResource(R.drawable.ic_baseline_stop)
                                initialiseSeekBar("Que11")

                            }
                            mp!!.isPlaying -> {
                                mp?.pause()
                                mp?.stop()
                                mp?.reset()
                                mp?.release()
                                mp = null
                                binding.seekBarQue9.progress = 0
                                binding.seekBarQue10.progress = 0
                                binding.seekBarQue11.progress = 0
                                binding.fabPlayQue11.setImageResource(R.drawable.ic_baseline_play)
                            }
                            else -> {
                                mp?.start()
                                binding.fabPlayQue11.setImageResource(R.drawable.ic_baseline_stop)
                            }
                        }
                    } else {
                        Snackbar.make(binding.root, R.string.NoInternet, Snackbar.LENGTH_SHORT)
                            .setBackgroundTint(
                                ContextCompat.getColor(
                                    this.requireActivity(),
                                    R.color.colorPrimary
                                )
                            )
                            .show()
                    }
                }


                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup1Btn3.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup9Btn3.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup10Btn2.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup11Btn1.isChecked) {
                        score += 1
                    }

                    dialogActions(quizTitle, score.toString(), "4")


                }
            }

            "L.1.4 Features of the Australian Accent - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle
                binding.txtQue9RadioBtn1.text =
                    "Choose the word you hear:"
                binding.txtQue9RadioBtn1Desc.text =
                    "To today’s program: Overweight Kids. \n According to medical research, obesity is fast becoming the most serious and costly disease among our children. Overeating and under-exercising lie at the _____ of the problem."


                binding.radioGroup9Btn1.text = "hat"
                binding.radioGroup9Btn2.text = "hard"
                binding.radioGroup9Btn3.text = "heart"

                // Sound Player

                seekBarChangeListener("Que9")
                binding.fabPlayQue9.setOnClickListener {
                    if (NetworkChecker(this.requireActivity()).isInternetConnected) {

                        when {
                            mp == null -> {
                                mp = MediaPlayer()
                                mp!!.setDataSource("https://ieltsjuice.com/wp-content/uploads/2021/08/IELTS_Juice_Obesity_Overweight_kids.mp3?_=2")
                                mp!!.prepare()
                                mp?.start()
                                binding.fabPlayQue9.setImageResource(R.drawable.ic_baseline_pause)
                            }
                            mp!!.isPlaying -> {
                                mp?.pause()
                                binding.fabPlayQue9.setImageResource(R.drawable.ic_baseline_play)
                            }
                            else -> {
                                mp?.start()
                                binding.fabPlayQue9.setImageResource(R.drawable.ic_baseline_pause)
                            }
                        }
                        initialiseSeekBar("Que9")
                    } else {
                        Snackbar.make(binding.root, R.string.NoInternet, Snackbar.LENGTH_SHORT)
                            .setBackgroundTint(
                                ContextCompat.getColor(
                                    this.requireActivity(),
                                    R.color.colorPrimary
                                )
                            )
                            .show()
                    }
                }
                //  SeekBar
                seekBarChangeListener("Que9")



                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup9Btn3.isChecked) {
                        score += 1
                    }

                    dialogActions(quizTitle, score.toString(), "1")

                }
            }

            "L.1.5 Listening Question Types - Quiz" -> {
                binding.txtQuizTitle.text = quizTitle

                binding.txtQueRadioBtn12.text =
                    "This picture shows which IELTS Listening question type?"
                binding.radioGroup12Btn1.text =
                    "Summary Completion"
                binding.radioGroup12Btn2.text =
                    "Table Completion"
                binding.radioGroup12Btn3.text =
                    "Sentence Completion"
                binding.radioGroup12Btn4.text =
                    "Note Completion"

                binding.txtQueRadioBtn13.text =
                    "This picture shows which IELTS Listening question type?"
                binding.radioGroup13Btn1.text =
                    "Sentence Completion"
                binding.radioGroup13Btn2.text =
                    "Short-answer"
                binding.radioGroup13Btn3.text =
                    "Classification"
                binding.radioGroup13Btn4.text =
                    "Matching"

                binding.txtQueRadioBtn14.text =
                    "This picture shows which IELTS Listening question type?"
                binding.radioGroup14Btn1.text =
                    "Classification"
                binding.radioGroup14Btn2.text =
                    "Multiple choice"
                binding.radioGroup14Btn3.text =
                    "Matching"
                binding.radioGroup14Btn4.text =
                    "Labeling a diagram"

                binding.txtQueRadioBtn15.text =
                    "This picture shows which IELTS Listening question type?"
                binding.radioGroup15Btn1.text =
                    "Classification"
                binding.radioGroup15Btn2.text =
                    "Matching"
                binding.radioGroup15Btn3.text =
                    "Multiple choice (A, B, and C)"
                binding.radioGroup15Btn4.text =
                    "Multiple choice (Pick from a list)"

                binding.txtQueRadioBtn16.text =
                    "This picture shows which IELTS Listening question type?"
                binding.radioGroup16Btn1.text =
                    "Sentence Completion"
                binding.radioGroup16Btn2.text =
                    "Short-answer"
                binding.radioGroup16Btn3.text =
                    "Classification"
                binding.radioGroup16Btn4.text =
                    "Matching"

                binding.finishQuizBtn.setOnClickListener {
                    var score = 0
                    if (binding.radioGroup12Btn4.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup13Btn1.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup14Btn2.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup15Btn4.isChecked) {
                        score += 1
                    }
                    if (binding.radioGroup16Btn3.isChecked) {
                        score += 1
                    }



                    dialogActions(quizTitle, score.toString(), "5")


                }
            }
        }
    }

    //Audio Player
    private fun initialiseSeekBar(Que: String) {
        when (Que) {
            "Que9" -> {
                binding.seekBarQue9.max = mp!!.duration
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed(object : Runnable {
                    override fun run() {
                        try {
                            // Update positionBar
                            binding.seekBarQue9.progress = mp!!.currentPosition


                            handler.postDelayed(this, 1000)


                        } catch (ex: Exception) {
//                        seekBar.progress = 0              //Error when User Press Back Button
                        }
                    }
                }, 0)
            }
            "Que10" -> {
                binding.seekBarQue10.max = mp!!.duration
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed(object : Runnable {
                    override fun run() {
                        try {
                            // Update positionBar
                            binding.seekBarQue10.progress = mp!!.currentPosition


                            handler.postDelayed(this, 1000)


                        } catch (ex: Exception) {
//                        seekBar.progress = 0              //Error when User Press Back Button
                        }
                    }
                }, 0)
            }
            "Que11" -> {
                binding.seekBarQue11.max = mp!!.duration
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed(object : Runnable {
                    override fun run() {
                        try {
                            // Update positionBar
                            binding.seekBarQue11.progress = mp!!.currentPosition


                            handler.postDelayed(this, 1000)


                        } catch (ex: Exception) {
//                        seekBar.progress = 0              //Error when User Press Back Button
                        }
                    }
                }, 0)
            }
        }

    }
    private fun seekBarChangeListener(Que: String) {
        when (Que) {
            "Que9" -> {
                binding.seekBarQue9.setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seebar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        if (fromUser) {
                            mp?.seekTo(progress)
                        }

                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {
                    }
                })
            }
            "Que10" -> {
                binding.seekBarQue10.setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seebar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        if (fromUser) {
                            mp?.seekTo(progress)
                        }

                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {
                    }
                })
            }
            "Que11" -> {
                binding.seekBarQue11.setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seebar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        if (fromUser) {
                            mp?.seekTo(progress)
                        }

                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {
                    }
                })
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
            val fragment = FragmentTestListening()
            fragment.arguments = bundle
            val replaceTransaction = parentFragmentManager.beginTransaction()
            replaceTransaction.replace(R.id.fragment_container_withoutNavigationActivity, fragment)
            replaceTransaction.addToBackStack(null)
            replaceTransaction.commit()
        }
        dialogBinding.CancelBtn.setOnClickListener {
            dialog.dismiss()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.remove(FragmentTestListening())
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
            "L.1.1.About the Listening Test - Quiz" -> {

                binding.radioGroup3Btn3.isChecked = true
                binding.radioGroup3Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup3Btn1.isEnabled = false
                binding.radioGroup3Btn2.isEnabled = false
                binding.radioGroup3Btn4.isEnabled = false

            }

            "L.1.2 The Listening Test Layout - Quiz" -> {
                binding.txtLayoutQue7Order1.editText?.setText("2")
                binding.txtLayoutQue7Order1.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue7Order2.editText?.setText("4")
                binding.txtLayoutQue7Order2.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue7Order3.editText?.setText("1")
                binding.txtLayoutQue7Order3.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue7Order4.editText?.setText("3")
                binding.txtLayoutQue7Order4.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.txtLayoutQue8Order1.editText?.setText("1")
                binding.txtLayoutQue8Order1.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue8Order2.editText?.setText("4")
                binding.txtLayoutQue8Order2.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue8Order3.editText?.setText("2")
                binding.txtLayoutQue8Order3.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtLayoutQue8Order4.editText?.setText("3")
                binding.txtLayoutQue8Order4.editText?.setTextColor(Color.parseColor("#66BB6A"))

                binding.radioGroup2Btn1.isChecked = true
                binding.radioGroup2Btn1.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup2Btn2.isEnabled = false

                binding.txtInputLayout1.editText?.setText("1,1st,first")
                binding.txtInputLayout1.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtInputLayout2.editText?.setText("30,thirty")
                binding.txtInputLayout2.editText?.setTextColor(Color.parseColor("#66BB6A"))
                binding.txtInputLayout3.editText?.setText("40,forty")
                binding.txtInputLayout3.editText?.setTextColor(Color.parseColor("#66BB6A"))

            }


            "L.1.3 English Accents - Quiz" -> {
                binding.radioGroup1Btn3.isChecked = true
                binding.radioGroup1Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup1Btn1.isEnabled = false
                binding.radioGroup1Btn2.isEnabled = false

                binding.radioGroup9Btn3.isChecked = true
                binding.radioGroup9Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup9Btn1.isEnabled = false
                binding.radioGroup9Btn2.isEnabled = false

                binding.radioGroup10Btn2.isChecked = true
                binding.radioGroup10Btn2.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup10Btn1.isEnabled = false
                binding.radioGroup10Btn3.isEnabled = false

                binding.radioGroup11Btn1.isChecked = true
                binding.radioGroup11Btn1.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup11Btn3.isEnabled = false
                binding.radioGroup11Btn2.isEnabled = false


            }

            "L.1.4 Features of the Australian Accent - Quiz" -> {
                binding.radioGroup9Btn3.isChecked = true
                binding.radioGroup9Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup9Btn1.isEnabled = false
                binding.radioGroup9Btn2.isEnabled = false


            }
            "L.1.5 Listening Question Types - Quiz" -> {
                binding.radioGroup12Btn4.isChecked = true
                binding.radioGroup12Btn4.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup12Btn1.isEnabled = false
                binding.radioGroup12Btn2.isEnabled = false
                binding.radioGroup12Btn3.isEnabled = false

                binding.radioGroup13Btn1.isChecked = true
                binding.radioGroup13Btn1.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup13Btn4.isEnabled = false
                binding.radioGroup13Btn2.isEnabled = false
                binding.radioGroup13Btn3.isEnabled = false

                binding.radioGroup14Btn2.isChecked = true
                binding.radioGroup14Btn2.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup14Btn1.isEnabled = false
                binding.radioGroup14Btn4.isEnabled = false
                binding.radioGroup14Btn3.isEnabled = false

                binding.radioGroup15Btn4.isChecked = true
                binding.radioGroup15Btn4.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup15Btn1.isEnabled = false
                binding.radioGroup15Btn2.isEnabled = false
                binding.radioGroup15Btn3.isEnabled = false

                binding.radioGroup16Btn3.isChecked = true
                binding.radioGroup16Btn3.setTextColor(Color.parseColor("#66BB6A"))
                binding.radioGroup16Btn1.isEnabled = false
                binding.radioGroup16Btn2.isEnabled = false
                binding.radioGroup16Btn4.isEnabled = false

            }
        }
    }
}