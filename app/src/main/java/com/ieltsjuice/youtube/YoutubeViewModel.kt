package com.ieltsjuice.youtube

import com.ieltsjuice.model.Youtube
import com.ieltsjuice.model.YoutubeRepository
import io.reactivex.Single

class YoutubeViewModel(
    private val youtubeRepository : YoutubeRepository
) {

    fun getListeningPlayList(): Single<Youtube> {
        return youtubeRepository.getListeningPlayList()
    }
    fun getReadingPlayList(): Single<Youtube> {
        return youtubeRepository.getReadingPlayList()
    }
    fun getWritingPlayList(): Single<Youtube> {
        return youtubeRepository.getWritingPlayList()
    }
    fun getSpeakingPlayList(): Single<Youtube> {
        return youtubeRepository.getSpeakingPlayList()
    }
    fun getOverviewPlayList(): Single<Youtube> {
        return youtubeRepository.getOverviewPlayList()
    }

}



