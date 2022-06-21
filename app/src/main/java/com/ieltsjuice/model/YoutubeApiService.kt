package com.ieltsjuice.model

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
//https://www.googleapis.com/youtube/v3/search?key= {apiKey} &channelId= {...} & part=snippet,id&list={playlistID}

interface YoutubeApiService {
    @GET("{search}")
    fun getYoutubePlayList(
        @Path("search") search:String,
        @Query("key") key:String,
        @Query("channelId") channelId:String,
        @Query("part") part:String,
        @Query("list") list:String
    ): Single<Youtube>
}