package com.ieltsjuice.model

import com.ieltsjuice.util.dictionaryBaseURL
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DictionaryRepository {
    private val dictionaryApiService: DictionaryApiService

    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(dictionaryBaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        dictionaryApiService = retrofit.create(DictionaryApiService::class.java)
    }

    fun getWordMeaning(word:String): Single<Dictionary> {
        return dictionaryApiService.getWord(
            word
        )
    }
}