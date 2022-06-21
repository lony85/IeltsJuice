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

}



