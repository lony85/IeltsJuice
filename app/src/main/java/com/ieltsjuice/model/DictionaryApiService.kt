package com.ieltsjuice.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApiService {

    @GET("{word}")
    fun getWord(
        @Path("word") word:String
    ):Single<Dictionary>
}