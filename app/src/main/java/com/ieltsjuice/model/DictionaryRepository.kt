package com.ieltsjuice.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.ieltsjuice.model.local.DictionaryDao
import com.ieltsjuice.model.local.DictionaryDatabase
import com.ieltsjuice.model.local.DictionaryLocalDataClass
import com.ieltsjuice.util.dictionaryBaseURL
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DictionaryRepository(
    private val dictionaryApiService: DictionaryApiService,
    private val dictionaryDao: DictionaryDao
) {


    fun getWordMeaning(word: String): Single<Dictionary> {
        return dictionaryApiService.getWord(
            word
        )
    }

    fun insertWordToFav(dictionaryLocalDataClass: DictionaryLocalDataClass) {
        return dictionaryDao.insertWord(dictionaryLocalDataClass)
    }
    fun deleteWordFromFav(definition:String) {
       return dictionaryDao.deleteByWordDefinition(definition)
    }
    fun getAllFavData(): LiveData<List<DictionaryLocalDataClass>> {
        return dictionaryDao.getAllFavData()
    }

}