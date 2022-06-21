package com.ieltsjuice.model

import com.ieltsjuice.util.*
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class YoutubeRepository {
    private val youtubeApiService: YoutubeApiService

    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(youtubeBaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        youtubeApiService = retrofit.create(YoutubeApiService::class.java)
    }

    fun getListeningPlayList(): Single<Youtube> {

        return youtubeApiService.getYoutubePlayList(
            "search",
            YouTubeApiKey,
            channelId,
            "snippet,id",
            listeningPlayList
        )

    }
}