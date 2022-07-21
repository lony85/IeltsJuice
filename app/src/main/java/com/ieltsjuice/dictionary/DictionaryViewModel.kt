package com.ieltsjuice.dictionary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ieltsjuice.model.Dictionary
import com.ieltsjuice.model.DictionaryRepository
import com.ieltsjuice.model.local.DictionaryLocalDataClass
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class DictionaryViewModel(
    private val dictionaryRepository: DictionaryRepository,
)  : ViewModel() {

    private lateinit var netDisposable : Disposable
    private val errorData = MutableLiveData<String>()

    fun getWordMeaning(word:String):Single<Dictionary>{
        return dictionaryRepository.getWordMeaning(word)
    }
    fun insertWordToFav(dictionaryLocalDataClass: DictionaryLocalDataClass){
        return dictionaryRepository.insertWordToFav(dictionaryLocalDataClass)
    }
    fun deleteWordFromFav(definition:String) {
        return dictionaryRepository.deleteWordFromFav(definition)
    }
    fun getAllFavData() : LiveData<List<DictionaryLocalDataClass>>{
        return dictionaryRepository.getAllFavData()
    }

}