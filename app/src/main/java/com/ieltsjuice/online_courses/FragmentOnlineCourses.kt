package com.ieltsjuice.online_courses

import android.annotation.SuppressLint
import android.content.Intent
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
import com.ieltsjuice.WithoutBottomNavigationBarActivity
import com.ieltsjuice.databinding.FragmentOnlineCoursesBinding
import com.ieltsjuice.util.PAGE_NAME_KEY

class FragmentOnlineCourses : Fragment() {

    private var playBackPosition = 0
    lateinit var mediaController: MediaController


    lateinit var binding: FragmentOnlineCoursesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnlineCoursesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonConsultation.setOnClickListener {
            val intent = Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY,"Consultation")
            startActivity(intent)
        }
        binding.buttonMainCoursesOneToOne.setOnClickListener {
            val intent = Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY,"OneToOne")
            startActivity(intent)
        }
        binding.buttonMainCoursesSelfPaced.setOnClickListener {
            val intent = Intent(this.requireActivity(), WithoutBottomNavigationBarActivity::class.java)
            intent.putExtra(PAGE_NAME_KEY,"selfPaced")
            startActivity(intent)
        }

        // videoView
        val videoURL =
            "https://embed-cloudfront.wistia.com/deliveries/a7bb347904064619ff32b794604795317c142e08.m3u8"
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

    override fun onDestroy() {
        super.onDestroy()
        binding.videoView.stopPlayback()
    }
}