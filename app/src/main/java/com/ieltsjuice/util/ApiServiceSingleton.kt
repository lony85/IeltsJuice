package com.ieltsjuice.util

import com.ieltsjuice.model.DictionaryApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceSingleton {
    var dictionaryApiService: DictionaryApiService? = null
        get() {
            if (field == null) {
                val retrofit = Retrofit
                    .Builder()
                    .baseUrl(dictionaryBaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                field = retrofit.create(DictionaryApiService::class.java)
            }
            return field
        }
}