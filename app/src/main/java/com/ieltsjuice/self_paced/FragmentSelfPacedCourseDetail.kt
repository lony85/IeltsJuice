package com.ieltsjuice.self_paced

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.internetconnection.NetworkChecker
import com.google.android.material.snackbar.Snackbar
import com.ieltsjuice.R
import com.ieltsjuice.databinding.FragmentSelfPacedCourseDetailBinding
import com.ieltsjuice.self_paced.speaking.KEY_SelfPacedCourseMainTitle


class FragmentSelfPacedCourseDetail : Fragment() {

    private var playBackPosition = 0
    private var videoURL: String? = null
    private lateinit var mediaController: MediaController


    lateinit var binding: FragmentSelfPacedCourseDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelfPacedCourseDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Receive Data from FragmentSelfPaced... (speaking,listening,writing,reading)
        val bundle = arguments
        if (bundle != null) {
            val courseTitle = bundle.getString(KEY_SelfPacedCourseMainTitle)
            bindData(courseTitle!!)
        }

        // videoPlayer
        mediaController = MediaController(this.requireActivity())
        val url = Uri.parse(videoURL)
        if (NetworkChecker(this.requireActivity()).isInternetConnected) {
            binding.videoView.setVideoURI(url)
        }
        binding.videoViewPlayButton.setOnClickListener {
            if (NetworkChecker(this.requireActivity()).isInternetConnected) {
                binding.videoViewPreviewImg.visibility = View.GONE
                binding.videoViewProgressBar.visibility = View.VISIBLE
                binding.videoView.start()
                binding.videoViewPlayButton.visibility = View.GONE
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
        binding.videoView.setOnPreparedListener {
            mediaController.setAnchorView(binding.videoContainer)
            binding.videoView.setMediaController(mediaController)
            binding.videoView.seekTo(1)
        }
        binding.videoView.setOnInfoListener { _, what, _ ->   //player & extras renamed to _
            if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                binding.videoViewProgressBar.visibility = View.INVISIBLE
            true
        }
        mediaController.show()

    }
    override fun onPause() {
        super.onPause()
        binding.videoView.pause()
        playBackPosition = binding.videoView.currentPosition
    }
    override fun onStop() {
        binding.videoView.stopPlayback()
        super.onStop()
    }


    //Binding Data
    @SuppressLint("SetTextI18n", "ResourceType")
    fun bindData(courseTitle: String) {
        binding.txtSelfPacedCourseMainTitle.text = courseTitle

        when (courseTitle) {
            // Speaking
            "1.1 Speaking Test Layout" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtSpeakingTestLayoutDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtSpeakingTestLayoutDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2021/03/1.1-The-Speaking-Test-Layout.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_speaking_1_1))
            }
            "1.2 Model Speaking Part 1" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtModelSpeakingPart1Desc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtModelSpeakingPart1Desc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2021/03/1.2-Model-Speaking-Part-1.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_speaking_1_2))


            }
            "1.3 Model Speaking Part 2" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtModelSpeakingPart2Desc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtModelSpeakingPart2Desc2)
                binding.SelfPacedModelSpeakingPart2CardView.text =
                    getString(R.string.txtSelfPacedModelSpeakingPart2CardView)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2021/03/1.3-Model-Speaking-Part-2.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_speaking_1_3))


                //set height of a View
                val lp: ViewGroup.LayoutParams =
                    binding.selfPacedSpeakingCardViewContainer.layoutParams
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT
                binding.selfPacedSpeakingCardViewContainer.requestLayout()
            }
            "1.4 Model Speaking Part 3" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtModelSpeakingPart3Desc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtModelSpeakingPart3Desc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2021/03/1.4-Model-Speaking-Part-3.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_speaking_1_4))

            }

            // Listening
            "1.1 About the Listening Test" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtAboutTheListeningTestDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtAboutTheListeningTestDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2019/05/1-1-academy-listening.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_listening_1_1))


            }
            "1.2 The Listening Test Layout" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtTheListeningTestLayoutDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtTheListeningTestLayoutDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2019/05/1.2-The-Listening-Test-Layout.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_listening_1_2))

            }
            "1.3 English Accents" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtEnglishAccentsDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtEnglishAccentsDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2019/05/1.3-English-Accents.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_listening_1_3))

            }
            "1.4 Features of the Australian Accent" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtFeaturesOfTheAustralianAccentDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtFeaturesOfTheAustralianAccentDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2019/05/1.4-Features-of-the-Australian-Accent.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_listening_1_4))

            }
            "1.5 Listening Question Types" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtListeningQuestionTypesDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtListeningQuestionTypesDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2019/05/1.5-Listening-Question-Types.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_listening_1_5))

            }

            // Writing
            "1.1 About the Writing Test" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtAboutTheWritingTestDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtAboutTheWritingTestDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2021/03/1.1-About-the-Writing-Test.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_writing_1_1))

            }
            "1.2 Academic vs. General Training" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtAcademicVsGeneralTrainingDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtAcademicVsGeneralTrainingDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2021/03/1.2-Academic-vs-General-Training.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_writing_1_2))

            }
            "1.3 Classic or Contemporary Formatting?" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtClassicOrContemporaryFormattingDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtClassicOrContemporaryFormattingDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2021/03/1.3-Classic-or-Contemporary-Formatting%EF%80%A5.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_writing_1_3))

            }
            "1.4 Pen or Pencil?" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtPenOrPencilDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtPenOrPencilDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2021/03/1.4-Pen-or-Pencil.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_writing_1_4))

            }

            // Reading
            "1.1 What’s IELTS reading test like? (About the reading test)" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtAboutTheReadingTestDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtAboutTheReadingTestDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2019/05/1.1-About-the-Reading-Test.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_reading_1_1))

            }
            "1.2 What’s the difference between the reading module in academic IELTS and general training IELTS" -> {
                binding.txtSelfPacedCourseTitle1.text = "Before you watch"
                binding.txtSelfPacedCourseTitle2.text = "After you watch"
                binding.txtSelfPacedCourseDesc1.text =
                    getString(R.string.txtDifferenceBetweenReadingAcademicAndGeneralDesc1)
                binding.txtSelfPacedCourseDesc2.text =
                    getString(R.string.txtDifferenceBetweenReadingAcademicAndGeneralDesc2)
                videoURL =
                    "https://ieltsjuice.com/wp-content/uploads/2019/05/1.2-Academic-vs.-General-Training.mp4"
                binding.videoViewPreviewImg.setImageDrawable(ContextCompat.getDrawable(this.requireActivity(),R.drawable.self_paced_reading_1_2))

            }
        }
    }

}