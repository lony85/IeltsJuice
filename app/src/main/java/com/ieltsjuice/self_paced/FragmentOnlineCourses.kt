package com.ieltsjuice.self_paced

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.ieltsjuice.ConsultationActivity
import com.ieltsjuice.OneToOneActivity
import com.ieltsjuice.databinding.FragmentOnlineCourcesBinding

class FragmentOnlineCourses:Fragment() {

    private var playBackPosition = 0
    lateinit var mediaController: MediaController
    private var videoURL: String? = null


    lateinit var binding : FragmentOnlineCourcesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnlineCourcesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonConsultation.setOnClickListener {
            val intent = Intent(this.requireActivity(), ConsultationActivity::class.java)
            startActivity(intent)
        }
        binding.buttonMainCoursesOnetoOne.setOnClickListener{
            val intent = Intent(this.requireActivity(), OneToOneActivity::class.java)
            startActivity(intent)
        }
        binding.buttonMainCoursesSelfPaced.setOnClickListener{
            val intent = Intent(this.requireActivity(), SelfPacedActivity::class.java)
            startActivity(intent)
        }

        // videoView

        val videoURL :String= "https://ieltsjuice.com/wp-content/uploads/2021/03/1.1-The-Speaking-Test-Layout.mp4"
        mediaController = MediaController(this.requireActivity())
        val url = Uri.parse(videoURL)
        binding.videoView.setVideoURI(url)

        binding.videoViewPlayButton.setOnClickListener {

            binding.videoViewProgressBar.visibility = View.VISIBLE
            binding.videoView.start()
            binding.videoViewPlayButton.visibility = View.GONE

        }
        binding.videoView.setOnPreparedListener {
            mediaController.setAnchorView(binding.videoContainer)
            binding.videoView.setMediaController(mediaController)
//            binding.videoView.seekTo(playBackPosition)
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
}