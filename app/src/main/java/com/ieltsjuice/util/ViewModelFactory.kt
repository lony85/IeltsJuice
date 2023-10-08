package com.ieltsjuice.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ieltsjuice.dictionary.DictionaryViewModel
import com.ieltsjuice.model.DictionaryRepository

class MainViewModelFactory(private val dictionaryRepository: DictionaryRepository) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DictionaryViewModel(dictionaryRepository) as T
    }
}

//class AddStudentViewModelFactory(private val dictionaryRepository: DictionaryRepository) :ViewModelProvider.Factory {
//
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return AddStudentViewModel(mainRepository) as T
//    }

