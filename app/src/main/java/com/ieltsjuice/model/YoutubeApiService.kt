package com.ieltsjuice.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
//https://www.googleapis.com/youtube/v3/search?key= {apiKey} &channelId= {...} & part=snippet,id&list={playlistID}

interface YoutubeApiService {
    @GET("{playlistItems}")
    fun getYoutubePlayList(
        @Path("playlistItems") playlistItems:String,
        @Query("key") key:String,
        @Query("part") part:String,
        @Query("playlistId") playlistId:String,
        @Query("maxResults") maxResults:String
    ): Single<Youtube>
}