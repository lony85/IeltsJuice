package com.ieltsjuice.youtube

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieltsjuice.databinding.FragmentYoutubePlayerBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import io.reactivex.annotations.NonNull


class FragmentYoutubePlayer : Fragment() {
    lateinit var binding: FragmentYoutubePlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYoutubePlayerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        val videoId = bundle?.getString("videoId")
        val videoTitle = bundle?.getString("videoTitle")
        val videoDesc = bundle?.getString("videoDesc")

        Log.d("id1",videoId!!)
        binding.youtubeVideoTitle.text = videoTitle
        binding.youtubeVideoDesc.text = videoDesc

        val youTubePlayerView: YouTubePlayerView = binding.webViewYoutubePlayer
//        getLifecycle().addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
        youTubePlayerView.addFullscreenListener(object : FullscreenListener {
            override fun onEnterFullscreen(fullscreenView: View, exitFullscreen: Function0<Unit>) {}
            override fun onExitFullscreen() {}
        })

//        binding.webViewYoutubePlayer.loadData(videoId, "text/html", "utf-8")
//        binding.webViewYoutubePlayer.settings.javaScriptEnabled = true
//        binding.webViewYoutubePlayer.webChromeClient = WebChromeClient()


    }


}


