package com.ieltsjuice.dictionary

import com.ieltsjuice.model.Dictionary
import com.ieltsjuice.model.DictionaryRepository
import io.reactivex.Single

class DictionaryViewModel(
    private val dictionaryRepository: DictionaryRepository
) {
    fun getWordMeaning(word:String):Single<Dictionary>{
        return dictionaryRepository.getWordMeaning(word)
    }
}